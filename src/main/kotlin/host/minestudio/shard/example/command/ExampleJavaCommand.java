package host.minestudio.shard.example.command;

import com.google.auto.service.AutoService;
import host.minestudio.frost.api.shards.command.ShardCommand;
import host.minestudio.frost.api.shards.command.annotation.Argument;
import host.minestudio.frost.api.shards.command.annotation.Command;
import host.minestudio.frost.api.shards.command.annotation.Subcommand;
import net.minestom.server.command.builder.arguments.ArgumentString;
import net.minestom.server.command.builder.arguments.minecraft.registry.ArgumentEntityType;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

@AutoService(Command.class)
@Command(
        name = "examplejava",
        description = "An example command"
)
public class ExampleJavaCommand extends ShardCommand {

    @Override
    public void execute(
            @NotNull Player executor
    ) {
        executor.sendMessage("Hello, " + executor.getUsername());
    }

    @Subcommand(
            path = "argument",
            description = "Example command with argument",
            usage = "/example arg1 <name>"
    )
    public void argument(
            Player executor,
            @Argument(type = ArgumentEntityType.class) EntityType name,
            @Argument(type = ArgumentString.class) String playerName
    ) {
        executor.sendMessage("Hello, " + playerName + ", you picked a " + name);
    }
}
