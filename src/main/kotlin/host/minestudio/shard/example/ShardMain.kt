package host.minestudio.shard.example

import com.google.auto.service.AutoService
import host.minestudio.frost.api.shards.Shard
import host.minestudio.frost.api.shards.annotations.ShardConfig
import host.minestudio.frost.api.shards.enum.LogLevel

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
        val logger = getLogEmitter()

        /*
        * The logger does not output messages to the console.
        * Instead, it sends events to the web dashboard's event monitor.
        * Each logger event is tracked as a dashboard event.
        *
        * Use println() for local debugging, as the logger is meant
        * for production environments without console access.
        */
        logger.emit(LogLevel.INFO, "Shard is starting up")
        /*
        logger.trace("This is a trace message")
        logger.debug("This is a debug message")
        logger.info("This is an info message")
        logger.warn("This is a warning message")
        logger.error("This is an error message")
        logger.fatal("This is a fatal message")
         */

        publishConfigSchema(ShardConfig().genConfig())
    }

    override fun delete() {
        println("Deleting shard")
    }

}