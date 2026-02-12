package com.example.bot3;


import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    public Client client(){
        return Client.builder()
                .apiKey("AIzaSyDC5qP4hRcyjwWWeBqSF9eie7fO9PLsj9U")
                .build();
    }
//sdfgsdfgsdfg
}


