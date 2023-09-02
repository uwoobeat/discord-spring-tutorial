package com.uwoobeat.discordbot.discord.listener;

import com.uwoobeat.discordbot.domain.member.MemberService;
import com.uwoobeat.discordbot.global.annotations.Listener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Slf4j
@Listener
@RequiredArgsConstructor
public class MemberJoinListener extends ListenerAdapter {

    private final MemberService memberService;

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        log.info("Member {} joined", event.getMember().getEffectiveName());

        if (!memberService.checkMembershipFeePaid()) {
            Member toBeKickedMember = event.getMember();
            toBeKickedMember.kick().queue();
            TextChannel channel = event.getGuild().getDefaultChannel().asTextChannel();
            channel.sendMessage(toBeKickedMember.getEffectiveName() + " have not paid membership fee!").queue();
        }
    }
}
