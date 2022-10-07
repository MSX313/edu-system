package org.msx.software.edu.system.controller.vm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.msx.software.edu.system.business.util.Hashable;
import org.msx.software.edu.system.business.util.Util;

public class MasterVm extends Hashable {

    @JsonIgnore
    public final long serialVersionUID;

    public MasterVm(Class clazz) {
        this.serialVersionUID = Util.generateSerialVersionUID(clazz);
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}