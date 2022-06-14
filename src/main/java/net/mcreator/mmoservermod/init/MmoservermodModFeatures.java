
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mmoservermod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import net.mcreator.mmoservermod.world.features.ores.MithrilOreFeature;
import net.mcreator.mmoservermod.world.features.ores.DeepslateMithrilOreFeature;
import net.mcreator.mmoservermod.world.features.ores.DeepslateLonsdaleiteOreFeature;
import net.mcreator.mmoservermod.MmoservermodMod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class MmoservermodModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, MmoservermodMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> MITHRIL_ORE = register("mithril_ore", MithrilOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, MithrilOreFeature.GENERATE_BIOMES, MithrilOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DEEPSLATE_MITHRIL_ORE = register("deepslate_mithril_ore", DeepslateMithrilOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, DeepslateMithrilOreFeature.GENERATE_BIOMES,
					DeepslateMithrilOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DEEPSLATE_LONSDALEITE_ORE = register("deepslate_lonsdaleite_ore",
			DeepslateLonsdaleiteOreFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
					DeepslateLonsdaleiteOreFeature.GENERATE_BIOMES, DeepslateLonsdaleiteOreFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
