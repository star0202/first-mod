package io.github.star0202.first;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class First implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("first");

	public static final Item FIRST_ITEM = new Item(new FabricItemSettings());
	public static final ItemGroup FIRST_GROUP = FabricItemGroupBuilder.build(
			new Identifier("first", "first_group"),
			() -> new ItemStack(FIRST_ITEM));

	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext options) {
		tooltip.add(Text.translatable("item.first.starcea.tooltip"));
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.ITEM, new Identifier("first", "starcea"), FIRST_ITEM);

	}
}
