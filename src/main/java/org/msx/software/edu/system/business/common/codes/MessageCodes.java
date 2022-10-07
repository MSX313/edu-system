package org.msx.software.edu.system.business.common.codes;

public interface MessageCodes {

    // Category Element Creator
    String PROBABLY_THERE_IS_NOT_VALUE_OR_CODE_METHOD_IN_THIS_CATEGORY = "***Exception*** %s -----> %s. probably there isn't value() or code() method in this category.";
    String PROBABLY_VALUE_OR_CODE_METHOD_HAS_PRIVATE_IDENTIFIER = "***Exception*** %s -----> %s. probably value() or code() method has private identifier.%n";
    String PROBABLY_VALUE_OR_CODE_METHOD_THAT_YOU_INVOKED_THREW_AN_EXCEPTION = "***Exception*** %s -----> %s. probably value() or code() method that you invoked threw an exception.";
    String YOU_SHOULD_CREATE_IT_FIRST = " %s You should create it first.";
    String CATEGORY_ELEMENT_VALUE = "getValue";
    String CATEGORY_ELEMENT_CODE = "getCode";
    String CATEGORY_PROCEED = "------------- Category %s  processed. -------------";
    String CATEGORY_CREATE = " Create %s";
    String CATEGORY_UPDATE = " Update %s";

    // Category Element Business
    String INPUT_CODE = " input code :  %s";
    String ENUM_CLASS = " enum class :  %s";
    String RESULT = "result is : %s";
    String ENUM_CODE="enum code : %s";
    String FOUND_CODE_IN_ENUM="found code in enum";
}