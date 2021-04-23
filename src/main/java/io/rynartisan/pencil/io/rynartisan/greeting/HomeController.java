package io.rynartisan.pencil.io.rynartisan.greeting;

import io.rynartisan.pencil.io.rynartisan.counting.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HomeController {

    private final CountService countService;

    public HomeController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/hi")
    public Map<String, String> greet() {
        return Collections.singletonMap("Message", "Hello Pencil!!!");
    }

    @GetMapping("/count-please")
    public Map<String, Object> countPls() {
        return Collections.singletonMap("count", countService.count());
    }
}
