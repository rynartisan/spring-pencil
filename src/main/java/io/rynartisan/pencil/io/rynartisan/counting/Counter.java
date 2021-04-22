package io.rynartisan.pencil.io.rynartisan.counting;

public class Counter {
    // Where to store the value of the current count.
    private int count;

    /**
     * Count up by one every time this getter is invoked.
     *
     * @return int count.
     */
    public int getCount() {
        return this.count += 1;
    }

    public Counter() {
        this.count = 0; // Initialize value to zero.
    }
}
