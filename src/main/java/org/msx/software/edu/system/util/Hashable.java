package org.msx.software.edu.system.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Hashable implements Serializable {

    @JsonIgnore
    private int objectHashCode;

    public int getObjectHashCode() {
        if (objectHashCode == 0) {
            objectHashCode = System.identityHashCode(this);
        }
        return objectHashCode;
    }

    public void setObjectHashCode(int objectHashCode) {
        this.objectHashCode = objectHashCode;
    }
}