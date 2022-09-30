package org.msx.software.edu.system.model.dto.util;

import org.msx.software.edu.system.util.Hashable;

public class MasterDto extends Hashable {

    private Long id;

    public MasterDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}