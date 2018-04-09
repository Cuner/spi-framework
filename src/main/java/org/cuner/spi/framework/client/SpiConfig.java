package org.cuner.spi.framework.client;

/**
 * Created by houan on 18/3/16.
 */
public class SpiConfig {

    /**
     * 是否互斥
     * false:满足执行条件的其他实现也一并调用
     * true:当前实现满足执行要求并执行成功后直接返回，忽略满足执行条件的其他实现
     */
    private boolean mutex;

    /**
     * 优先值
     * 该值越高，执行优先级越高
     */
    private int priority;

    /**
     * 名称 作为标识
     */
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
