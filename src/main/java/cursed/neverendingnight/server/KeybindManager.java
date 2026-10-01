package cursed.neverendingnight.server;

import cursed.neverendingnight.Neverendingnight;
import cursed.neverendingnight.core.capabilities.Capabilities;
import net.minecraft.server.level.ServerPlayer;

public class KeybindManager {
    public static void onKeycode(int key, ServerPlayer p) {
        switch (key) {
            case 0: onCastKeybind(p);
            case 1: ;
            default:
                Neverendingnight.LOGGER.error("Unrecognized Keycode! {}", key);
        }
    }

    private static void onCastKeybind(ServerPlayer player) {
        player.getCapability(Capabilities.PLAYER_CAPABILITY).ifPresent(p -> {
            boolean canCast = false;
            for (int i = 0; i < p.getSelectedSpell().requiredTag().size(); i++) {
                if (player.getMainHandItem().is(p.getSelectedSpell().requiredTag().get(i))) {
                    canCast = true;
                    break;
                }
            }
            if (canCast)
                Neverendingnight.LOGGER.debug("{}", p.getSelectedSpell().cast(player, null, player.level()));
        });
    }
}
