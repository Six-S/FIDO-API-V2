package com.fido.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import java.util.HashMap;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/command")
public class mainController {
    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, String> index() {
        HashMap<String, String> returnObject = new HashMap<>();
        returnObject.put("test1", "value1");
        returnObject.put("test2", "value2");

        return returnObject;
    }
}
