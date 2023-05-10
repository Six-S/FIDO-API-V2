package com.fido.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

import java.util.HashMap;

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
        OpenAIInterface client = new OpenAIInterface();
        String response = client.makeChatRequest(String.valueOf(request.getBody().get().findValue("msg")));

        System.out.println(response);
        return HttpResponse.ok();
    }
}
