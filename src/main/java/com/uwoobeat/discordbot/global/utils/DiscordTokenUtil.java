package com.uwoobeat.discordbot.global.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DiscordTokenUtil {
    public static String token;

    @Value("${discord.bot.token}")
    public void setToken(String value) {
        DiscordTokenUtil.token = value;
    }
}
