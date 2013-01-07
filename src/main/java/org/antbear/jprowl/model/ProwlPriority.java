package org.antbear.jprowl.model;

public enum ProwlPriority {
    VERY_LOW(-2), MODERATE(-1), NORMAL(0), HIGH(1), EMERGENCY(2);

    private final int code;

    ProwlPriority(final int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
