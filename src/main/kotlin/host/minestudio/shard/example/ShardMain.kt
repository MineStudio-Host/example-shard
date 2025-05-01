package host.minestudio.shard.example

import com.google.auto.service.AutoService
import host.minestudio.frost.api.shards.Shard
import host.minestudio.frost.api.shards.annotations.ShardConfig

@AutoService(Shard::class)
@ShardConfig(
    id = "example",
    name = "Example Shard",
    version = "1.0",
    author = "MineStudio",
    // authors = ["MineStudio"],
    // deps = ["example-dep"]
)
class ShardMain : Shard() {

    override fun create() {
        println("Creating shard")
    }

    override fun delete() {
        println("Deleting shard")
    }

}