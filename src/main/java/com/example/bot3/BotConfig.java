package com.example.bot3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfig {
    @Autowired
    private HandleUpdate update;

    @Bean
    public TelegramBotsApi telegramBotsApi(){
        try {
            TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(update);
            return telegramBotsApi;
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


}
