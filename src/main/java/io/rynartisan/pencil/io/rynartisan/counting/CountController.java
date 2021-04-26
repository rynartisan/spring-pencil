package io.rynartisan.pencil.io.rynartisan.counting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class CountController {

    // Since this is annotated as a service it's automatically injected. or not?
    private CountService countService;

    @Autowired
    public CountController() {
        this.countService = new CountService();
    }

    // Autowired can be omitted since this class contains only one constructor.


    @GetMapping("/count")
    public Map<String, Object> count() {
        return Collections.singletonMap("count", countService.count());
    }
}
