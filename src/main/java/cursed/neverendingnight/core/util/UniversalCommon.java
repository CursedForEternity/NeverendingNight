/* (C) TAMA Studios 2025 */
package cursed.neverendingnight.core.util;

import cursed.neverendingnight.Neverendingnight;
import cursed.neverendingnight.core.networking.ImAPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.joml.Vector3d;
import org.joml.Vector3f;

import java.util.function.Supplier;

/**
 * This class exists to make it easier to port to newer/older MC versions by taking methods/names that are prone to changing and abstracting them
 * For example. `new ResourceLocation()` has been removed in 1.20.6, in older versions you have to use new ResourceLocation, to remedy this, UniversalCommon#newRL() exists which does the same thing, and by using this, once updating to MC 1.20.6+, only UniversalCommon has to change, not your entire codebase.
 */
public class UniversalCommon {

	/**
	 * @return A new ResourceLocation
	 */
	public static ResourceLocation newRL(String namespace, String path) {
		return new ResourceLocation(namespace, path);
		// TODO: Replace with \/ Once porting to/past 1.20.6. Keep it ^ for now though because the bottom doesn't exist in older Forge versions for 1.20.1
		//return ResourceLocation.tryBuild(namespace, path);
	}

	/**
	 * @return A new ResourceLocation with namespace "minecraft"
	 */
	public static ResourceLocation newRL(String path) {
		return newRL("minecraft", path);
	}

	public static ResourceLocation parse(String path) {
		return new ResourceLocation(path);
		// TODO: Replace with \/ Once porting to/past 1.20.6. Keep it ^ for now though because the bottom doesn't exist in older Forge versions for 1.20.1
//		return ResourceLocation.tryParse(path);
	}

	/**
	 * @return A new ResourceLocation with namespace being your mod id
	 */
	public static ResourceLocation modRL(String path) {
		return newRL(Neverendingnight.MODID, path);
	}

	public static class Pos {
		public static int x(BlockPos pos) {
			return pos.getX();
		}
		public static int y(BlockPos pos) {
			return pos.getY();
		}
		public static int z(BlockPos pos) {
			return pos.getZ();
		}

		public static double x(Vec3 pos) {
			return pos.x();
		}
		public static double y(Vec3 pos) {
			return pos.y();
		}
		public static double z(Vec3 pos) {
			return pos.z();
		}

		public static int x(Vec3i pos) {
			return pos.getZ();
		}
		public static int y(Vec3i pos) {
			return pos.getZ();
		}
		public static int z(Vec3i pos) {
			return pos.getZ();
		}

		public static float x(Vector3f pos) {
			return pos.x();
		}
		public static float y(Vector3f pos) {
			return pos.y();
		}
		public static float z(Vector3f pos) {
			return pos.z();
		}

		public static double x(Vector3d pos) {
			return pos.x();
		}
		public static double y(Vector3d pos) {
			return pos.y();
		}
		public static double z(Vector3d pos) {
			return pos.z();
		}
	}

	public static class Level {
		public BlockState getState(net.minecraft.world.level.Level world, BlockPos pos) {
			return world.getBlockState(pos);
		}
	}

	// Don't need this yet, but when it is I'll port it over.
	public static class Networking {
		private static int ID = 0;
		public static int id() { return ID++; }
		private static final String PROTOCOL = "1";

		private static final SimpleChannel Network = NetworkRegistry.ChannelBuilder
				.named(newRL(Neverendingnight.MODID, "main")).clientAcceptedVersions(PROTOCOL::equals)
				.serverAcceptedVersions(PROTOCOL::equals).networkProtocolVersion(() -> PROTOCOL).simpleChannel();

		public static SimpleChannel getInstance() {
			return Network;
		}

		@SuppressWarnings("unchecked")
		public static <MSG extends ImAPacket> void registerMsg(Class<MSG> packet) {
			register((Class<Object>) (Object) packet); // This works by casting packet down to an object (which it is)
														// and
														// casting that to Class<Object>, Prob shouldn't do this, but it
														// works.
		}

		private static void register(Class<Object> packet) {
			getInstance().registerMessage(Networking.id(), packet, (msg, buf) -> {
				try {
					packet.getMethod("encode", packet, FriendlyByteBuf.class).invoke(null, msg, buf);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}, (buf) -> {
				try {
					return packet.getMethod("decode", FriendlyByteBuf.class).invoke(null, buf);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}, (msg, ctx) -> {
				try {
					packet.getMethod("handle", packet, Supplier.class).invoke(null, msg, ctx);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});
		}

	}
}
