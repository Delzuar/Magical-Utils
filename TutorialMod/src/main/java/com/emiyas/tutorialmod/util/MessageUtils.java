package com.emiyas.tutorialmod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class MessageUtils
{
	public static void informationMessage(String text, EntityPlayer player)
	{
		TextComponentTranslation textTeleporter = new TextComponentTranslation(text);
		textTeleporter.getStyle().setColor(TextFormatting.DARK_PURPLE);
		player.sendStatusMessage(textTeleporter, false);
	}
}
