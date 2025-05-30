package host.minestudio.shard.example

import com.google.auto.service.AutoService
import host.minestudio.frost.api.dependencies.RemoteRepository
import host.minestudio.frost.api.dependencies.resolver.MavenResolver
import host.minestudio.frost.api.shards.ShardDependencyLoader
import org.eclipse.aether.artifact.DefaultArtifact
import org.eclipse.aether.graph.Dependency

@AutoService(ShardDependencyLoader::class)
class DepResolver : ShardDependencyLoader() {

    override fun loadDependencies(mavenResolver: MavenResolver?) {
        // Add the dependencies to be loaded
        mavenResolver?.addDependency(
            this::class.java,
            Dependency(
                DefaultArtifact(
                    "net.minestom:minestom-snapshots:87f6524aeb"
                ),
                "compile"
            )
        )

        // Add the repositories to be used
        mavenResolver?.addRepository(
            this::class.java,
            RemoteRepository(
                "https://repo.maven.apache.org/maven2"
            )
        )
    }
}