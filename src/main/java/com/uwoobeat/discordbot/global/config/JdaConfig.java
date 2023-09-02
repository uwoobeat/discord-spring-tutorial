package com.uwoobeat.discordbot.global.config;

import com.uwoobeat.discordbot.discord.listener.CustomDiscordListener;
import com.uwoobeat.discordbot.global.utils.DiscordTokenUtil;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdaConfig {

    @Bean
    JDA jda() {
        return JDABuilder.createDefault(DiscordTokenUtil.token)
                .setActivity(Activity.playing("with JDA"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new CustomDiscordListener())
                .build();
    }
}
