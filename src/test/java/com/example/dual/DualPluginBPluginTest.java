package com.example.dual;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class DualPluginBPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(DualPluginBPlugin.class);
		RuneLite.main(args);
	}
}