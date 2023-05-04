package com.fido.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller("/command")
public class mainController {
    @Get
    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    public HashMap<String, String> index() {
        HashMap<String, String> returnObject = new HashMap<>();
        returnObject.put("test1", "value1");
        returnObject.put("test2", "value2");

        return returnObject;
    }
    @Post("/text")
    public HttpResponse<?> test(HttpRequest<ObjectNode> request)
    {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_API_KEY"));
        System.out.println("Streaming chat completion...");
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "Hello! I hope you are doing well.");
        messages.add(systemMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        System.out.println(service.createChatCompletion(chatCompletionRequest));
//        service.streamChatCompletion(chatCompletionRequest)
//                .doOnError(Throwable::printStackTrace)
//                .blockingForEach(System.out::println);

        System.out.println(request.getBody().get().findValue("test"));
        return HttpResponse.ok();
    }
}
