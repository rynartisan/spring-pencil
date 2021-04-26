package io.rynartisan.pencil.io.rynartisan.pencil;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PencilService {

    private final PencilRepo pencilRepo;

    // Am I going to regret this later? TODO: regret
    public PencilService(PencilRepo pencilRepo) {
        this.pencilRepo = pencilRepo;
    }

    public List<Pencil> getAll() {
        List<Pencil> pencils = new ArrayList<>();
        pencilRepo.findAll()
                .forEach(pencils::add);
        return pencils;
    }

    public Pencil makePencil() {
        Pencil p = new Pencil();
        p.setMake("HB2");
        pencilRepo.save(p);
        return p;
    }


}
