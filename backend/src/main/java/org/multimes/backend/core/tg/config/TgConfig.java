package org.multimes.backend.core.tg.config;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("/application.yml")
public class TgConfig {
    @Bean
    public TelegramBot bot(@Value("${tg.bot-token}") String token) {
        return new TelegramBot(token);
    }
}
