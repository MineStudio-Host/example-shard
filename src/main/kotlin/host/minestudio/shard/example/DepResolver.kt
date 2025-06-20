package host.minestudio.shard.example

import host.minestudio.frost.api.dependencies.resolver.MavenResolver
import host.minestudio.frost.api.shards.ShardDependencyLoader
import org.eclipse.aether.artifact.DefaultArtifact
import org.eclipse.aether.graph.Dependency

class DepResolver : ShardDependencyLoader() {

    override fun loadDependencies(mavenResolver: MavenResolver?) {
        // Add the dependencies to be loaded
        mavenResolver?.addDependency(
            this::class.java,
            Dependency(
                DefaultArtifact(
                    "dev.expx:minestom-invs:1.0.6"
                ),
                "compile"
            )
        )

        // Add the repositories to be used
        // maven central built in
        /*mavenResolver?.addRepository(
            this::class.java,
            RemoteRepository(
                "http://repo1.maven.org/maven2"
            )
        )*/
    }
}