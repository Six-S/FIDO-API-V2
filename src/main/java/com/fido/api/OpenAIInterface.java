package com.fido.api;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenAIInterface {

    public String makeChatRequest(String msg){

        Utils.log("Making new chat request.", "INFO");

        OpenAiService service = getOpenAIClient();
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), msg);
        messages.add(systemMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        ChatCompletionResult result = service.createChatCompletion(chatCompletionRequest);

        return result.getChoices().get(0).getMessage().getContent();
    }

    public OpenAiService getOpenAIClient(){
        return new OpenAiService(System.getenv("OPENAI_API_KEY"));
    }
}
