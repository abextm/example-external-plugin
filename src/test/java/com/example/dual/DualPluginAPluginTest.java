package com.example.dual;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class DualPluginAPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(DualPluginAPlugin.class);
		RuneLite.main(args);
	}
}