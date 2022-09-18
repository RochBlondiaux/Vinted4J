package me.rochblondiaux.vinted4j.task;

import lombok.Getter;
import me.rochblondiaux.vinted4j.VintedAPI;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Getter
public abstract class RecurrentTask implements Runnable {

    private static final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);

    protected final VintedAPI api;
    protected long delay;
    protected long period;
    protected TimeUnit unit;

    public RecurrentTask(VintedAPI api) {
        this.api = api;
    }

    public RecurrentTask(VintedAPI api, long delay, long period, TimeUnit unit) {
        this.api = api;
        this.delay = delay;
        this.period = period;
        this.unit = unit;
    }

    public void start() {
        start(delay, period, unit);
    }

    public void start(long delay, long period, TimeUnit unit) {
        if (!isRunning())
            executor.scheduleAtFixedRate(this, delay, period, unit);
    }

    public void stop() {
        if (isRunning())
            executor.remove(this);
    }

    public boolean isRunning() {
        return executor.getQueue().contains(this);
    }
}
