/* (C) TAMA Studios 2025 */
package cursed.neverendingnight.core.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ExamplePacket implements ImAPacket {
	int x;

	public ExamplePacket(int x) {
		this.x = x;
	}

	public static ExamplePacket decode(FriendlyByteBuf buffer) {
		return new ExamplePacket(buffer.readInt());
	}

	public static void encode(ExamplePacket packet, FriendlyByteBuf buffer) {
		buffer.writeInt(packet.x);
	}

	public static void handle(ExamplePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			System.out.println(packet.x);
		});
		context.setPacketHandled(true);
	}
}
