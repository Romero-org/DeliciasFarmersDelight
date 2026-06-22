@file:Suppress("UnstableApiUsage")

plugins {
    id("net.fabricmc.fabric-loom-remap")
    id("dev.kikugie.postprocess.jsonlang")
    id("me.modmuss50.mod-publish-plugin")
    id("maven-publish")
}

val minecraft = stonecutter.current.version
val mcVersion = stonecutter.current.project.substringBeforeLast('-')

tasks.named<ProcessResources>("processResources") {
    fun prop(name: String) = project.property(name) as String

    val props = HashMap<String, String>().apply {
        this["version"] = "${prop("mod.version")}+${prop("deps.minecraft")}"
        this["minecraft"] = prop("mod.mc_dep_fabric")
        this["fd"] = prop("deps.fd_meta")
        this["bnc"] = prop("deps.bnc_meta")
    }

    filesMatching(listOf("fabric.mod.json", "META-INF/neoforge.mods.toml", "META-INF/mods.toml")) {
        expand(props)
    }

}

tasks.named("processResources") {
    dependsOn(":${stonecutter.current.project}:stonecutterGenerate")
}

version = "${property("mod.version")}+${property("deps.minecraft")}-fabric"
base.archivesName = property("mod.id") as String

// loom {
//     accessWidenerPath = rootProject.file("src/main/resources/${property("mod.id")}.classtweaker")
// }

jsonlang {
    languageDirectories = listOf("assets/${property("mod.id")}/lang")
    prettyPrint = true
}

repositories {
    mavenLocal()
    mavenCentral()
    val exclusiveRepos: List<Triple<String, String, List<String>>> = listOf(
        Triple("macuguita Maven", "https://maven.macuguita.com/releases/", listOf("com.macuguita", "folk.sisby", "org.quiltmc")),
        Triple("Minecraft Forge", "https://maven.minecraftforge.net", emptyList()),
        Triple("shedaniel (Cloth Config)", "https://maven.shedaniel.me/", listOf("me.shedaniel")),
        Triple("Xander Maven", "https://maven.isxander.dev/releases/", listOf("dev.isxander")),
        Triple("Terraformers (Mod Menu)", "https://maven.terraformersmc.com/releases/", listOf("com.terraformersmc", "dev.emi")),
        Triple("Modrinth", "https://api.modrinth.com/maven", listOf("maven.modrinth")),
        Triple("Greenhouse", "https://maven.greenhouse.lgbt/releases/", listOf("vectorwing", "umpaz.brewinandchewin", "house.greenhouse")),
        Triple("Jitpack", "https://jitpack.io", listOf()),
    )

    exclusiveRepos.forEach { (name, url, groups) ->
        if (groups.isNotEmpty()) {
            exclusiveContent {
                forRepository {
                    maven {
                        this.name = name
                        setUrl(url)
                    }
                }
                filter {
                    groups.forEach { includeGroupAndSubgroups(it) }
                }
            }
        } else {
            maven {
                this.name = name
                setUrl(url)
            }
        }
    }
}

dependencies {
    val mappingsAttribute = Attribute.of("net.minecraft.mappings", String::class.java)
    minecraft("com.mojang:minecraft:${property("deps.minecraft")}")
    mappings(loom.layered {
        officialMojangMappings()
        if (hasProperty("deps.parchment"))
            parchment("org.parchmentmc.data:parchment-${property("deps.parchment")}@zip")
    })
    modImplementation("net.fabricmc:fabric-loader:${property("deps.fabric-loader")}")
    api("dev.yumi.mc.core:yumi-mc-foundation:${property("deps.yumi_mc_foundation")}") {
        attributes {
            attribute(mappingsAttribute, "mojmap")
        }
    }
    include("dev.yumi.mc.core:yumi-mc-foundation:${property("deps.yumi_mc_foundation")}")

    implementation("folk.sisby:kaleido-config:${property("deps.kaleido")}")
    include("folk.sisby:kaleido-config:${property("deps.kaleido")}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("deps.fabric_api")}")
    compileOnly("org.jspecify:jspecify:1.0.0")

    modImplementation("vectorwing:FarmersDelight:${property("deps.fd")}+refabricated")
    modImplementation("umpaz.brewinandchewin:BrewinAndChewin-fabric:${property("deps.bnc")}")

    if (hasProperty("deps.mcqoy")) {
        modLocalRuntime("maven.modrinth:mcqoy:${property("deps.mcqoy")}")
    }

    if (hasProperty("deps.modmenu")) {
        modLocalRuntime("com.terraformersmc:modmenu:${property("deps.modmenu")}")
    }

    if (hasProperty("deps.yacl")) {
        modLocalRuntime("dev.isxander:yet-another-config-lib:${property("deps.yacl")}-fabric")
    }
}

configurations.all {
    resolutionStrategy {
        force("net.fabricmc:fabric-loader:${property("deps.fabric-loader")}")
    }
}

stonecutter {
    replacements.string {
        direction = eval(current.version, ">1.21.10")
        replace("ResourceLocation", "Identifier")
    }
}

tasks {
    processResources {
        exclude("**/neoforge.mods.toml", "**/mods.toml")
    }

    register<Copy>("buildAndCollect") {
        group = "build"
        from(remapJar.map { it.archiveFile })
        into(rootProject.layout.buildDirectory.file("libs/${project.property("mod.version")}"))
        dependsOn("build")
    }
}

loom.runs.named("server") {
    isIdeConfigGenerated = false
}

fabricApi {
    configureDataGeneration {
        outputDirectory = file("$rootDir/src/main/generated")
        client = true
    }
}

java {
    withSourcesJar()
    val javaCompat = JavaVersion.VERSION_21
    sourceCompatibility = javaCompat
    targetCompatibility = javaCompat
}

val additionalVersionsStr = findProperty("publish.additionalVersions") as String?
val additionalVersions: List<String> = additionalVersionsStr
    ?.split(",")
    ?.map { it.trim() }
    ?.filter { it.isNotEmpty() }
    ?: emptyList()

publishMods {
    file.set(tasks.named<org.gradle.jvm.tasks.Jar>("remapJar").map { it.archiveFile.get() })
    additionalFiles.from(
        tasks.named<net.fabricmc.loom.task.RemapSourcesJarTask>("remapSourcesJar").map { it.archiveFile.get() }
    )

    // one of BETA, ALPHA, STABLE
    type = STABLE
    displayName = "${property("mod.name")} ${property("mod.version")} for ${stonecutter.current.version} Fabric"
    version = "${property("mod.version")}+${property("deps.minecraft")}-fabric"
    changelog = provider { rootProject.file("CHANGELOG-LATEST.md").readText() }
    modLoaders.add("fabric")
    modLoaders.add("quilt")

    modrinth {
        projectId = property("publish.modrinth") as String
        accessToken = env.MODRINTH_API_KEY.orNull()
        minecraftVersions.add(property("deps.minecraft").toString())
        minecraftVersions.addAll(additionalVersions)
        requires("fabric-api")
        requires("macu-lib")
        optional("modmenu")
        optional("mcqoy")
        optional("qomc")
    }

    curseforge {
        projectId = property("publish.curseforge") as String
        accessToken = env.CURSEFORGE_API_KEY.orNull()
        minecraftVersions.add(stonecutter.current.version)
        minecraftVersions.addAll(additionalVersions)
        requires("fabric-api")
        requires("macu-lib")
        optional("modmenu")
        optional("mcqoy")
        optional("qomc")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = property("mod.group") as String
            artifactId = (property("mod.id") as String) + "-fabric"
            version = (property("mod.version") as String) + "+${property("deps.minecraft")}"
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
        maven {
            name = "macuguita"
            url = uri("https://maven.macuguita.com/releases")

            credentials {
                username = env.MAVEN_USERNAME.orNull()
                password = env.MAVEN_KEY.orNull()
            }
        }
    }
}