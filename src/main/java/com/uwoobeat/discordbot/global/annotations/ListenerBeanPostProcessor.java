package com.uwoobeat.discordbot.global.annotations;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListenerBeanPostProcessor implements BeanPostProcessor {

    private final JDA jda;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean.getClass().isAnnotationPresent(Listener.class)) {
            jda.addEventListener(bean);
        }
        return bean;
    }
}
