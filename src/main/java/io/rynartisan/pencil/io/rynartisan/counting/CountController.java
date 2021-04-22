package io.rynartisan.pencil.io.rynartisan.counting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    private final CountService countService;

    @Autowired
    public CountController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/count")
    public int count() {
        return this.countService.count();
    }
}
