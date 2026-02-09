package com.example.bot3;


import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    public Client client(@Value("${gemini}")String token){
        return Client.builder()
                .apiKey(token)
                .build();
    }
//sdfgsdfgsdfg
}


