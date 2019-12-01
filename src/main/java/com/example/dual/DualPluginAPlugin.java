package com.example.dual;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PluginDescriptor(
	name = "DualPluginA"
)
public class DualPluginAPlugin extends Plugin
{
	@Inject
	Client client;

	@Inject
	DualPluginAConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("DualPluginA started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("DualPluginA stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "DualPluginA says " + config.greeting(), null);
		}
	}

	@Provides
	DualPluginAConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DualPluginAConfig.class);
	}
}
