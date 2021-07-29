package io.rynartisan.pencil.counting;

import org.springframework.stereotype.Service;

@Service
public class CountService {

    private final Counter counter;

    public CountService() {
        this.counter = new Counter();
    }

    public int count() {
        return counter.getCount();
    }
}
