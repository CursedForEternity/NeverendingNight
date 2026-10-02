package cursed.neverendingnight.client.events;

import cursed.neverendingnight.Neverendingnight;
import cursed.neverendingnight.client.packets.KeybindPacketC2S;
import cursed.neverendingnight.core.util.UniversalCommon;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Neverendingnight.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player.level().isClientSide) {
            while (ClientSetup.CAST_SPELL.consumeClick()) {
                UniversalCommon.Networking.getInstance().sendToServer(new KeybindPacketC2S(0));
            }
            while (ClientSetup.SWITCH_SPELL.consumeClick()) {
                UniversalCommon.Networking.getInstance().sendToServer(new KeybindPacketC2S(1));
            }
        }
    }
}
