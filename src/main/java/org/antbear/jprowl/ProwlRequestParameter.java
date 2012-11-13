package org.antbear.jprowl;

import org.javatuples.KeyValue;

public class ProwlRequestParameter {

    private final KeyValue<String, String> keyValue;

    public ProwlRequestParameter(String key, String value) {
        this.keyValue = new KeyValue<String, String>(key, value);
    }

    public String getKey() {
        return this.keyValue.getKey();
    }

    public String getValue() {
        return this.keyValue.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProwlRequestParameter that = (ProwlRequestParameter) o;
        if (keyValue != null ? !keyValue.equals(that.keyValue) : that.keyValue != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return keyValue != null ? keyValue.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ProwlRequestParameter{" +
                "keyValue=" + keyValue +
                '}';
    }
}
