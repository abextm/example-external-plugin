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
	name = "DualPluginB"
)
public class DualPluginBPlugin extends Plugin
{
	@Inject
	Client client;

	@Inject
	DualPluginBConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("DualPluginB started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("DualPluginB stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "DualPluginB says " + config.greeting(), null);
		}
	}

	@Provides
	DualPluginBConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DualPluginBConfig.class);
	}
}
