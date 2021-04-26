package io.rynartisan.pencil.io.rynartisan.pencil;

import jdk.jfr.Unsigned;

import javax.persistence.*;

@Entity
@Table(name = "pencils")
public class Pencil {

    @Id
    @Unsigned
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String make;

    private boolean isNew;

    @Enumerated(EnumType.ORDINAL)
    private color color;

    public enum color {
        RED, BLUE, GREEN
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setColor(Pencil.color color) {
        this.color = color;
    }
}
