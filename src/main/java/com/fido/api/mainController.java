package com.fido.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import java.util.HashMap;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;



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

        System.out.println(request.getBody().get());
        return HttpResponse.ok();
    }
}
