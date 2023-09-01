package com.uwoobeat.discordbot;

import com.uwoobeat.discordbot.discord.listener.CustomDiscordListener;
import com.uwoobeat.discordbot.global.utils.DiscordTokenUtil;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscordbotApplication.class, args);

		JDA jda = JDABuilder.createDefault(DiscordTokenUtil.token)
				.setActivity(Activity.playing("with JDA"))
				.enableIntents(GatewayIntent.MESSAGE_CONTENT)
				.addEventListeners(new CustomDiscordListener())
				.build();
	}

}
