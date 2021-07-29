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
    private Color color;

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public boolean isNew() {
        return isNew;
    }

    public Color getColor() {
        return color;
    }



    public void setMake(String make) {
        this.make = make;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", isNew=" + isNew +
                ", color=" + color +
                '}';
    }
}
