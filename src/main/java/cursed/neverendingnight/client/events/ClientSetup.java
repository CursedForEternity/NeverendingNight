package cursed.neverendingnight.client.events;

import com.mojang.blaze3d.platform.InputConstants;
import cursed.neverendingnight.Neverendingnight;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Neverendingnight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    public static final KeyMapping CAST_SPELL = new KeyMapping("neverendingnight.keybinds.cast_spell",
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
            GLFW.GLFW_KEY_G, "key.categories.neverendingnight" // Mapping will be in the main category
    );

    public static final KeyMapping SWITCH_SPELL = new KeyMapping("neverendingnight.keybinds.switch_spell",
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
            GLFW.GLFW_KEY_G, "key.categories.neverendingnight" // Mapping will be in the main category
    );

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(CAST_SPELL);
        event.register(SWITCH_SPELL);
    }
}
