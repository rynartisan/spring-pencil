package io.rynartisan.pencil.pencil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("/pencil/{id}")
    public Pencil getAll(@PathVariable String id) {
        return pencilService.getPencilDetails((Integer.parseInt(id)));
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

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(
            NoSuchElementException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Couldn't find any pencils with that ID!");
    }
}
