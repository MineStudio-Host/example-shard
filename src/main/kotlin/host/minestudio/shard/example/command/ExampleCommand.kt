package host.minestudio.shard.example.command

import com.google.auto.service.AutoService
import host.minestudio.frost.api.shards.command.ShardCommand
import host.minestudio.frost.api.shards.command.annotation.Argument
import host.minestudio.frost.api.shards.command.annotation.Command
import host.minestudio.frost.api.shards.command.annotation.Subcommand
import net.minestom.server.command.builder.arguments.ArgumentString
import net.minestom.server.command.builder.arguments.minecraft.registry.ArgumentEntityType
import net.minestom.server.entity.EntityType
import net.minestom.server.entity.Player

@AutoService(ShardCommand::class)
@Command(
    name = "example",
    description = "An example command",
    aliases = ["ex"]
)
class ExampleCommand : ShardCommand() {

    override fun execute(executor: Player) {
        executor.sendMessage("Hello, ${executor.username}!")
    }

    @Subcommand(
        path = "argument",
        description = "An example subcommand with an argument",
        usage = "/example arg1 <name>",
    )
    fun argument(
        executor: Player,
        @Argument(ArgumentEntityType::class) name: EntityType,
        @Argument(ArgumentString::class) playerName: String
    ) {
        executor.sendMessage("Hello, $playerName, you picked a $name!")
    }
}