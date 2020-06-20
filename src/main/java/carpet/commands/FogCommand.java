package carpet.commands;


import carpet.utils.Messenger;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.BaseText;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class FogCommand
{

    public static float min = 1.6F, max = 2.0F, water = 0.5F, waterBiome = 0.005F, lava = 2.0F;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        dispatcher.register(literal("fog").executes(context -> f0(context.getSource())).then(argument("min", FloatArgumentType.floatArg(0.0F)).executes(context -> f1(context.getSource(), FloatArgumentType.getFloat(context, "min")))).then(argument("max", FloatArgumentType.floatArg(0.0F)).executes(context -> f2(context.getSource(), FloatArgumentType.getFloat(context, "max")))).then(argument("water", FloatArgumentType.floatArg(0.0F)).executes(context -> f3(context.getSource(), FloatArgumentType.getFloat(context, "water")))).then(argument("waterBiome", FloatArgumentType.floatArg(0.0F)).executes(context -> f4(context.getSource(), FloatArgumentType.getFloat(context, "waterBiome")))).then(argument("lava", FloatArgumentType.floatArg(0.0F)).executes(context -> f5(context.getSource(), FloatArgumentType.getFloat(context, "lava")))));
    }

    /* Functions */

    /* /fog */
    private static int f0(ServerCommandSource src) {
        src.sendFeedback(Messenger.c("Multiplicador inicial: " + min), false);
        src.sendFeedback(Messenger.c("Multiplicador final: " + max), false);
        src.sendFeedback(Messenger.c("Multiplicador agua: " + water), false);
        src.sendFeedback(Messenger.c("Adición por bioma: " + waterBiome), false);
        src.sendFeedback(Messenger.c("Multiplicador lava: " + lava), false);

        return 1;
    }

    /* /fog float_min */
    private static int f1(ServerCommandSource src, float min) {
        FogCommand.min = min;

        return 1;
    }

    /* /fog float_max */
    private static int f2(ServerCommandSource src, float max) {
        FogCommand.max = max;

        return 1;
    }

    /* /fog float_water */
    private static int f3(ServerCommandSource src, float water) {
        FogCommand.water = water;

        return 1;
    }

    /* /fog float_waterBiome */
    private static int f4(ServerCommandSource src, float waterBiome) {
        FogCommand.waterBiome = waterBiome;

        return 1;
    }

    /* /fog float_lava */
    private static int f5(ServerCommandSource src, float lava) {
        FogCommand.lava = lava;

        return 1;
    }

}
