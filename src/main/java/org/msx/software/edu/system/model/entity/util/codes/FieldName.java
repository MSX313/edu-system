package org.msx.software.edu.system.model.entity.util.codes;

public interface FieldName {

    // General
    String ID = "C_ID";
    String INSERT_USER = "C_INSERT_USER";
    String UPDATE_USER = "C_UPDATE_USER";
    String INSERT_DATE_TIME = "C_INSERT_DATE_TIME";
    String UPDATE_DATE_TIME = "C_UPDATE_DATE_TIME";
    String VERSION = "C_VERSION";
    String IS_ACTIVE = "C_IS_ACTIVE";
    //
    String UUID = "C_UUID";
    String CODE = "C_CODE";
    String VALUE = "C_VALUE";
    String FIRST_NAME = "C_FIRST_NAME";
    String LAST_NAME = "C_LAST_NAME";
    String EMAIL = "C_EMAIL";
    String DATE_OF_BIRTH = "C_DATE_OF_BIRTH";
    String AGE = "C_AGE";
    String CARD_NUMBER = "C_CARD_NUMBER";
    String CREATED_AT = "C_CREATED_AT";
    String NAME = "C_NAME";
    String DEPARTMENT = "C_DEPARTMENT";

    // Student
    String STUDENT_ID = "C_STUDENT_ID";
    String CATEGORY="F_CATEGORY";
    String CATEGORY_CATEGORY_ELEMENT_ID_FOREIGN_KEY = "C_CTG_CTGE_ID_FK";
    String STUDENT_CARD_ID_FOREIGN_KEY = "C_ST_CD_ID_FK";
    String STUDENT_BOOK_ID_FOREIGN_KEY = "C_ST_BK_ID_FK";
    String STUDENT_ENROLMENT_ID_FOREIGN_KEY = "C_ST_EN_ID_FK";

    // Course
    String COURSE_ID = "C_COURSE_ID";
    String COURSE_ID_FOREIGN_KEY = "C_COURSE_ID_FK";
}