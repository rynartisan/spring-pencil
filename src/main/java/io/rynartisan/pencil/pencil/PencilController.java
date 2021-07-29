package io.rynartisan.pencil.pencil;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class PencilController {

    private final PencilService pencilService;
    Logger logger = LoggerFactory.getLogger(this.getClass());


    public PencilController(PencilService pencilService) {
        this.pencilService = pencilService;
    }

    @GetMapping("/pencils")
    public List<Pencil> getAll() {
        return pencilService.getAll();
    }

    @PostMapping("/pencil")
    public Pencil makePencil() {
        Pencil p = this.pencilService.makePencil();
        return p;
    }

    @DeleteMapping("/pencil")
    public Pencil destroyPencil() {
        try {
            return this.pencilService.destroyPencil();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; //TODO: Change the return type of this controller.
    }
}
