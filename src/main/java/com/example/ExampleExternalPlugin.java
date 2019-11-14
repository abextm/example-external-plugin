package com.example;

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
	name = "Example External"
)
public class ExampleExternalPlugin extends Plugin
{
	@Inject
	Client client;

	@Inject
	ExampleExternalConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example External started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example External stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example External says " + config.greeting(), null);
		}
	}

	@Provides
	ExampleExternalConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ExampleExternalConfig.class);
	}
}
