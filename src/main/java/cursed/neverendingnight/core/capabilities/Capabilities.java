/* (C) TAMA Studios 2025 */
package cursed.neverendingnight.core.capabilities;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import cursed.neverendingnight.core.capabilities.caps.PlayerCapability;
import cursed.neverendingnight.core.capabilities.interfaces.IPlayerCap;
import cursed.neverendingnight.core.capabilities.providers.SerializableCapabilityProvider;
import cursed.neverendingnight.core.util.UniversalCommon;

import static cursed.neverendingnight.Neverendingnight.MODID;


@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Capabilities {

	public static final ResourceLocation FRAGMENT_LINKS = UniversalCommon.modRL("fragment_links");
	public static final ResourceLocation PLAYER = UniversalCommon.modRL("player");
	public static final Capability<IPlayerCap> PLAYER_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
	});

	/**
	 * A capability for levels
	 * We don't need this yet, but if we ever need to store data on a level, it's right here
	 */
//	public static final Capability<ILevelCap> LEVEL_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
//	});

//	public static final ResourceLocation LEVEL_CAP_KEY = UniversalCommon.modRL("level_cap");

	public static <T, O extends ICapabilityProvider> LazyOptional<T> getCap(Capability<T> cap, O object) {
		return object == null ? LazyOptional.empty() : object.getCapability(cap);
	}

	@SubscribeEvent
	public static void register(RegisterCapabilitiesEvent event) {
		event.register(IPlayerCap.class);
	}

	@Mod.EventBusSubscriber(modid = MODID)
	public static class AttachCapabilities {
		@SubscribeEvent
		public static void AttachWorldCapabilities(AttachCapabilitiesEvent<Level> event) {

			// For unregistered worlds, because some mods either aren't that bright or just
			// as hacky and
			// gimmicky as a
			// nintendo console
			if (event.getObject().registryAccess().registryOrThrow(Registries.DIMENSION_TYPE)
					.getKey(event.getObject().dimensionType()) == null)
				return;

//			event.addCapability(Capabilities.LEVEL_CAP_KEY,
//					new SerializableCapabilityProvider<>(LEVEL_CAPABILITY, new LevelCapability(event.getObject())));

		}

		@SubscribeEvent
		public static void attachPlayerCapability(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player) {
				event.addCapability(Capabilities.PLAYER, new SerializableCapabilityProvider<>(PLAYER_CAPABILITY,
						new PlayerCapability(event.getObject())));
			}
		}
	}
}
