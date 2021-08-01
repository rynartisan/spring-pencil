package io.rynartisan.pencil.counting;

import org.springframework.stereotype.Service;

@Service
public class CountService {

    private final Counter counter = new Counter();

    public CountService() {
    }

    public int count() {
        return counter.getCount();
    }
}
