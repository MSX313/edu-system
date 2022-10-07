package org.msx.software.edu.system.model.entity.util;

import java.sql.Timestamp;

public interface Entity {

    Long getId();

    String getInsertUser();

    String getUpdateUser();

    Timestamp getInsertDateTime();

    Timestamp getUpdateDateTime();

    Integer getVersion();

    boolean isActive();
}