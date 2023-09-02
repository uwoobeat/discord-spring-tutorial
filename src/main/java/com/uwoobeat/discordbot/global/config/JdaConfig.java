package com.uwoobeat.discordbot.global.config;

import com.uwoobeat.discordbot.discord.listener.CustomDiscordListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdaConfig {

    @Value("${discord.bot.token}")
    private String token;

    @Bean
    JDA jda() {
        return JDABuilder.createDefault(token)
                .setActivity(Activity.playing("with JDA"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new CustomDiscordListener())
                .build();
    }
}
