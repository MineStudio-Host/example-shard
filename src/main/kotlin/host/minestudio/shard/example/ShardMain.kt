package host.minestudio.shard.example

import com.google.auto.service.AutoService
import host.minestudio.frost.api.shards.Shard

@AutoService(Shard::class)
class ShardMain : Shard() {

    override fun create() {
        println("Creating shard")
    }

    override fun delete() {
        println("Deleting shard")
    }

}