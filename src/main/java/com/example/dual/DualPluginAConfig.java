
package com.example.dual;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("dualplugina")
public interface DualPluginAConfig extends Config
{
	@ConfigItem(
		keyName = "greeting",
		name = "Welcome Greeting",
		description = "I don't know why you say goodbye, I say"
	)
	default String greeting()
	{
		return "Hello";
	}
}
