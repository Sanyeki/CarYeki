package carpet.commands;


import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class FogCommand
{

    public static float min = 1.6F, max = 2.0F;


    public static void register(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        dispatcher.register(literal("fog").then(literal("min").then(argument("value", FloatArgumentType.floatArg(0.0F)).executes(context -> f0(context.getSource(), FloatArgumentType.getFloat(context, "value"))))).then(literal("max").then(argument("value", FloatArgumentType.floatArg(0.0F)).executes(context -> f1(context.getSource(), FloatArgumentType.getFloat(context, "value"))))));
    }

    /* Functions */

    /* fog min float_value */
    private static int f0(ServerCommandSource src, float value) {

        min = value;

        return 1;
    }


    /* fog max float_value */
    private static int f1(ServerCommandSource src, float value) {

        max = value;

        return 1;
    }

}
