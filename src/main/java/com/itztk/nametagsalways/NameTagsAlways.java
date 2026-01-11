package com.itztk.nametagsalways;


import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class NameTagsAlways implements ClientModInitializer {
	public static final String MOD_ID = "name-tags-always";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {

		ModConfig.init();
		ModConfig config = ModConfig.INSTANCE;
		KeyMapping toggleNames = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.nametagsalways.toggle_names", InputConstants.UNKNOWN.getValue(), "key.categories.nametagsalways"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (toggleNames.consumeClick()) {
				config.displayNamesEnabled = !config.displayNamesEnabled;
        if (client.player != null && config.sendToggleNotifications) {
          client.player.sendSystemMessage(Component.literal("Name tag display: " + config.displayNamesEnabled));
        }
      }
		});



	}



}