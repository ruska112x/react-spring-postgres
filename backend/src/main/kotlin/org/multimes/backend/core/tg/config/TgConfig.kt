package org.multimes.backend.core.tg.config

import com.pengrad.telegrambot.TelegramBot
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("/application.yml")
class TgConfig {

    @Bean
    fun bot(@Value("\${tg.bot-token}") token: String): TelegramBot {
        return TelegramBot(token)
    }
}
