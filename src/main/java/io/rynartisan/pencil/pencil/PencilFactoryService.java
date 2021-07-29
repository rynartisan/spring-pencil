package io.rynartisan.pencil.pencil;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class PencilFactoryService {

    private Faker faker;

    public PencilFactoryService() {
        this.faker = new Faker();
    }

    public Pencil fakePencil() {
        Pencil p = new Pencil();
        p.setMake(this.faker.company().name());
        p.setColor(this.faker.options().option(Color.class));
        p.setNew(this.faker.bool().bool());
        return p;
    }
}
