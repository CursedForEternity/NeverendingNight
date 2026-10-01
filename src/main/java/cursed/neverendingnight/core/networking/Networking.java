package cursed.neverendingnight.core.networking;

import cursed.neverendingnight.client.packets.KeybindPacketC2S;
import cursed.neverendingnight.client.packets.SpellCastC2S;
import cursed.neverendingnight.core.util.UniversalCommon;

public class Networking {
    public static void registerPackets() {
        UniversalCommon.Networking.registerMsg(KeybindPacketC2S.class);
        UniversalCommon.Networking.registerMsg(SpellCastC2S.class);
    }
}
