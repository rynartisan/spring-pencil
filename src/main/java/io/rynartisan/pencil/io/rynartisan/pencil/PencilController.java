package io.rynartisan.pencil.io.rynartisan.pencil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PencilController {

    private final PencilService pencilService;

    public PencilController(PencilService pencilService) {
        this.pencilService = pencilService;
    }

    @GetMapping("/pencils")
    public List<Pencil> getAll() {
        return pencilService.getAll();
    }

    @PostMapping("/pencil")
    public Pencil makePencil() {
        return this.pencilService.makePencil();
    }
}
