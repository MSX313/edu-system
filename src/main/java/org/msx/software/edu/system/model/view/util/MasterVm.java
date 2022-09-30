package org.msx.software.edu.system.model.view.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.msx.software.edu.system.util.Hashable;
import org.msx.software.edu.system.util.Util;

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