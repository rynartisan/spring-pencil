package io.rynartisan.pencil.pencil;

import jdk.jfr.Unsigned;

import javax.persistence.*;

@Entity
public class Pencil {

    @Id
    @Unsigned
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String make;

    private boolean isNew;

    @Enumerated(EnumType.ORDINAL)
    private color color;

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public boolean isNew() {
        return isNew;
    }

    public Pencil.color getColor() {
        return color;
    }

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
