package io.rynartisan.pencil.io.rynartisan.pencil;

import jdk.jfr.Unsigned;

import javax.persistence.*;

@Entity
@Table(name = "pencils")
public class Pencil {

    @Id
    @Unsigned
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String make;
    private boolean isNew;

    private enum color {
        RED, BLUE, GREEN
    }

    @Enumerated(EnumType.ORDINAL)
    private color color;

}
