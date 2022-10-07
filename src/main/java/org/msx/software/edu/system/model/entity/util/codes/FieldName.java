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
    String USER_NAME = "C_USER_NAME";
    String PASSWORD = "C_PASSWORD";
    String IMAGE = "C_IMAGE";
    String EMAIL = "C_EMAIL";
    String DATE_OF_BIRTH = "C_DATE_OF_BIRTH";
    String CARD_NUMBER = "C_CARD_NUMBER";
    String CREATED_AT = "C_CREATED_AT";
    String NAME = "C_NAME";
    String DEPARTMENT = "C_DEPARTMENT";
    String COST="C_COST";
    String DESCRIPTION = "C_DESCRIPTION";
    String ROLE_SET = "roleSet";

    // Student
    String STUDENT_ID = "C_STUDENT_ID";
    String CATEGORY = "F_CATEGORY";
    String USER = "F_USER";
    String ENROLMENT = "F_ENROLMENT";
    String USER_ENTITY_USER_ENTITY_CARD_ID_FOREIGN_KEY = "C_USR_ENT_USR_ENT_ID_CARD_FK";
    String ROLE = "F_ROLE";
    String CONTACT_INFORMATION_TYPE = "C_CONTACT_INFORMATION_TYPE";
    String CURRENCY_TYPE_COST = "C_CURRENCY_TYPE_COST";
    String GENDER_TYPE = "C_GENDER_TYPE";
    String TYPE = "C_TYPE";
    String USER_ENTITY_CONTACT_INFORMATION_ID_FOREIGN_KEY = "C_USR_CONTACT_INF_ID_FK";
    String CATEGORY_CATEGORY_ELEMENT_ID_FOREIGN_KEY = "C_CTG_CTGE_ID_FK";
    String USER_ENTITY_BOOK_ID_FOREIGN_KEY = "C_USR_ENT_BOOK_ID_FK";
    String STUDENT_CARD_ID_FOREIGN_KEY = "C_ST_CD_ID_FK";
    String STUDENT_BOOK_ID_FOREIGN_KEY = "C_ST_BK_ID_FK";
    String STUDENT_ENROLMENT_ID_FOREIGN_KEY = "C_ST_EN_ID_FK";
    String USER_ENTITY_ENROLMENT_ID_FOREIGN_KEY = "C_USR_ENT_ENROL_ID_FK";

    // Course
    String COURSE_ID = "C_COURSE_ID";
    String USER_ENTITY_ID = "C_USER_ENTITY_ID";
    String COURSE = "F_COURSE";
    String COURSE_ID_FOREIGN_KEY = "C_COURSE_ID_FK";
    String COURSE_ENROLMENT_ID_FOREIGN_KEY = "C_CRS_ENROL_ID_FK";
}