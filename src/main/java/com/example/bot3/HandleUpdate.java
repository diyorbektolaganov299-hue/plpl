package com.example.bot3;


import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class HandleUpdate extends TelegramLongPollingBot {

    @Value("${bot.token}")
    private String token;
    @Value("${bot.username}")
    private String username;
    @Autowired
    private Client client;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            User from = message.getFrom();
            String text = message.getText();
            System.out.println(chatId+",\t"+from.getFirstName());
            SendMessage m=new SendMessage();
            m.setChatId(8245802629L);
            m.setText(from.getFirstName()+" botga yozdi");
            try {
                execute(m);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
            if (message.hasText()){
                String result = a(text);
                SendMessage sendMessage=new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(result);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }else {


                SendMessage sendMessage=new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("menga tekst yuboring "+from.getFirstName());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public String a(String text){

        try {
            GenerateContentResponse generateContentResponse =
                    client.models.generateContent(
                            "gemini-3-flash-preview"
                            , text,
                            null
                    );
            return generateContentResponse.text();
        }catch (Exception e){
            return "damizni oling men charchadim";
        }
    }
    @Override
    public String getBotUsername() {
        return username;
    }
}

