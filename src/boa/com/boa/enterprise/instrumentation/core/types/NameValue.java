package com.boa.enterprise.instrumentation.core.types;

import java.io.Serializable;

public class NameValue implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private Object value;

    public NameValue(String name) {
        this.name = name;
        this.value = null;
    }

    public NameValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
