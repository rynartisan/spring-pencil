package io.rynartisan.pencil.pencil;

import io.rynartisan.pencil.exceptions.NoSuchPencilException;
import io.rynartisan.pencil.logging.logService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PencilController {
    /**
     * Pencil service injection.
     */
    private final PencilService pencilService;

    private logService logService;

    public PencilController(PencilService pencilService, io.rynartisan.pencil.logging.logService logService) {
        this.pencilService = pencilService;
        this.logService = logService;
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

    @ExceptionHandler(NoSuchPencilException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(
            NoSuchPencilException exception
    ) {
        String response = "Couldn't find any pencils with ID (" + exception.getPencilID() + ")!";
        logService.logError(response);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response); //IDEA: override this with a logger response entity? or make your logger class handle that?
    }
}
