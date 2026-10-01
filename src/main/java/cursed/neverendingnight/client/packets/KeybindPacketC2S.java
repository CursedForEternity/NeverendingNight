/* (C) TAMA Studios 2025 */
package cursed.neverendingnight.client.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import cursed.neverendingnight.core.networking.ImAPacket;
import cursed.neverendingnight.server.KeybindManager;

import java.util.function.Supplier;

public class KeybindPacketC2S implements ImAPacket {
	int key;

	public KeybindPacketC2S(int key) {
		this.key = key;
	}

	public static KeybindPacketC2S decode(FriendlyByteBuf buffer) {
		return new KeybindPacketC2S(buffer.readInt());
	}

	public static void encode(KeybindPacketC2S packet, FriendlyByteBuf buffer) {
		buffer.writeInt(packet.key);
	}

	public static void handle(KeybindPacketC2S packet, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			KeybindManager.onKeycode(packet.key, context.getSender());
			System.out.println(packet.key);
		});
		context.setPacketHandled(true);
	}
}
