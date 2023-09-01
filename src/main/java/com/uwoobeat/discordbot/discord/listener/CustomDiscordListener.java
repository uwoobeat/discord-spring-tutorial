package com.uwoobeat.discordbot.discord.listener;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Slf4j
public class CustomDiscordListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        TextChannel channel = event.getChannel().asTextChannel();
        Message message = event.getMessage();

        log.info("Message from {} in {}: {}", author.getName(), channel.getName(), message.getContentDisplay());

        if (author.isBot()) {
            return;
        }

        if (message.getContentRaw().equals("!ping")) {
            log.info("ping command received");
            channel.sendMessage("Pong!").queue();
        }
    }
}
