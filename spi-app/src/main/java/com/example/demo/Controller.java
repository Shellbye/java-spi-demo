package com.example.demo;

import com.shellbye.ContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

@RestController
public class Controller {

    @GetMapping
    public String main() {
        System.out.println("enter");
        List<ContentService> services = new ArrayList<>();
        ServiceLoader<ContentService> loader = ServiceLoader.load(ContentService.class);

        loader.forEach(contentProvider -> {
            services.add(contentProvider);
            System.out.println(contentProvider.getContent());
        });
        return "OK";
    }
}
