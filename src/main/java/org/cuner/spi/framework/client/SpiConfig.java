package org.cuner.spi.framework.client;

/**
 * Created by houan on 18/3/16.
 */
public class SpiConfig {
    private boolean mutex;
    private int priority;
    private String name;

    public SpiConfig() {
        this.mutex = true;
        this.priority = 0;
        this.name = null;
    }

    public SpiConfig(boolean mutex, int priority) {
        this.mutex = mutex;
        this.priority = priority;
        this.name = null;
    }

    public SpiConfig(boolean mutex, int priority, String name) {
        this.mutex = mutex;
        this.priority = priority;
        this.name = name;
    }

    public boolean isMutex() {
        return this.mutex;
    }

    public void setMutex(boolean mutex) {
        this.mutex = mutex;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
