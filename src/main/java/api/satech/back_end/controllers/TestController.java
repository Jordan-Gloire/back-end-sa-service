package api.satech.back_end.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path="/api/v1")

public class TestController {
    @GetMapping("/test")
    public String test(){
        return "Test successful";
    }
}
