package com.fido.api;

import io.micronaut.http.annotation.Controller;
import io.micronaut.runtime.Micronaut;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}