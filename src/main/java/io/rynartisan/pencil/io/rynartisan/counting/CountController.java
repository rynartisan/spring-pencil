package io.rynartisan.pencil.io.rynartisan.counting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class CountController {

    // Since this is annotated as a service it's automatically injected.
    private final CountService countService;

    // Autowired can be omitted since this class contains only one constructor.
    public CountController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/count")
    public Map<String, Object> count() {
        return Collections.singletonMap("count", countService.count());
    }
}
