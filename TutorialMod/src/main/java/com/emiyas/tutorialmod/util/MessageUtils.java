package com.emiyas.tutorialmod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class MessageUtils
{
	public static void informationMessage(String text, EntityPlayer player)
	{
		TextComponentTranslation testComponent = new TextComponentTranslation(text);
		testComponent.getStyle().setColor(TextFormatting.DARK_PURPLE);
		player.sendStatusMessage(testComponent, false);
	}
}
