package io.rynartisan.pencil.pencil;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PencilService {

    private final PencilRepository pencilRepository;
    private PencilFactoryService pencilFactoryService;

    // Am I going to regret this later? TODO: regret
    public PencilService(PencilRepository pencilRepository, PencilFactoryService pencilFactoryService) {
        this.pencilRepository = pencilRepository;
        this.pencilFactoryService = pencilFactoryService;
    }

    public List<Pencil> getAll() {
        List<Pencil> pencils = new ArrayList<>();
        pencilRepository.findAll().forEach(pencils::add);
        return pencils;
    }

    public Pencil makePencil() {
        Pencil p = this.pencilFactoryService.fakePencil();
        p = pencilRepository.save(p);
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
