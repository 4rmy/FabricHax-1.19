package net.army.fabrichax.util;

public class Timer {
    public Long lastMs = System.currentTimeMillis();

    public void reset() {
        lastMs = System.currentTimeMillis();
    }

    public boolean hasTimeElapsed(long time, boolean reset) {
        if (System.currentTimeMillis()-lastMs > time) {
            if (reset)
                reset();
            return true;
        }
        return false;
    }
}
