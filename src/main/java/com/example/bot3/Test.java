package com.example.bot3;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test {

    @Autowired
    private Client client;


    @PostMapping(value = "/{text}")
    public String gemini(@PathVariable String text){

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

}
