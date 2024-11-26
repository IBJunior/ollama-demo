package com.example.ollama_demo;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OllamaDemoApplicationTests {

    @Autowired
    private ChatClient.Builder builder;

    @Test
    void ollamaChatClientTest() {
        ChatClient chatClient = builder.build();

        String content = chatClient.prompt()
                .user("Tell me a joke about Software Engineers")
                .call()
                .content();
        System.out.println("The content is : " + content);
    }

    @Test
    void ollamaCustomModelTest() {
        ChatClient chatClient = builder
                .defaultOptions(ChatOptionsBuilder.builder()
                        .withModel("french-llama-3-2")
                        .build())
                .build();

        String content = chatClient.prompt()
                .user("Tell me a joke about Software Engineers")
                .call()
                .content();
        System.out.println("The content is : " + content);
    }

}
