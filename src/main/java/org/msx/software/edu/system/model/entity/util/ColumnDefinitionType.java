package org.msx.software.edu.system.model.entity.util;

public interface ColumnDefinitionType {

    String NUMBER = "NUMBER";
    String VARCHAR_2_50 = "VARCHAR2(50)";
    String VARCHAR_2_15 = "VARCHAR2(15)";
    String VARCHAR_2_1000_WITH_DEFAULT_VALUE = "VARCHAR2(1000) DEFAULT 'Default Value For Description'";
    String INTEGER = "INTEGER";
    String INTEGER_WITH_DEFAULT_VALUE = "INTEGER DEFAULT 25";
    String BOOLEAN_DEFAULT_FALSE = "BOOLEAN DEFAULT FALSE";
    String BOOLEAN_DEFAULT_TRUE = "BOOLEAN DEFAULT FALSE";
    String LOCAL_DATE = "DATE";
    String LOCAL_DATE_TIME = "TIMESTAMP";
    String LOCAL_TIME = "TIME";
    String TIME_STAMP = "TIMESTAMP";
    String TIMESTAMP_WITHOUT_TIME_ZONE = "TIMESTAMP WITHOUT TIME ZONE";
}