package org.msx.software.edu.system.business.dto.util;

import org.msx.software.edu.system.business.util.Hashable;

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