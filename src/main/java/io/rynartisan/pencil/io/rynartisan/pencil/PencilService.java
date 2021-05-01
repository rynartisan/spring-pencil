package io.rynartisan.pencil.io.rynartisan.pencil;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PencilService {

    private final PencilRepository pencilRepository;

    // Am I going to regret this later? TODO: regret
    public PencilService(PencilRepository pencilRepository) {
        this.pencilRepository = pencilRepository;
    }

    public List<Pencil> getAll() {
        List<Pencil> pencils = new ArrayList<>();
        pencilRepository.findAll().forEach(pencils::add);
        return pencils;
    }

    public Pencil makePencil() {
        Pencil p = new Pencil();
        p.setMake("HB2");
        p.setColor(Pencil.color.GREEN);
        pencilRepository.save(p);
        return p;
    }

    public Pencil destroyPencil() throws Exception {
        List<Pencil> pencils = new ArrayList<>();
        pencilRepository.findAll().forEach(pencils::add);
        Pencil p = pencils.get(0);
        pencilRepository.deleteById(p.getId());
        return p;
    }

}
