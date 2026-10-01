/* (C) TAMA Studios 2025 */
package cursed.neverendingnight.client.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import cursed.neverendingnight.core.networking.ImAPacket;

import java.util.function.Supplier;

public class SpellCastC2S implements ImAPacket {
		public SpellCastC2S() {}

	public static SpellCastC2S decode(FriendlyByteBuf buffer) {
		return new SpellCastC2S();
	}

	public static void encode(SpellCastC2S packet, FriendlyByteBuf buffer) {

	}

	public static void handle(SpellCastC2S packet, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			System.out.println("FIREBALL!!");
		});
		context.setPacketHandled(true);
	}
}
