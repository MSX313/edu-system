package org.msx.software.edu.system.business.operation.categoryelement;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msx.software.edu.system.model.entity.Category;
import org.msx.software.edu.system.model.entity.CategoryElement;
import org.msx.software.edu.system.business.operation.category.CategoryBusiness;
import org.msx.software.edu.system.business.common.codes.MessageCodes;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

@Named
@RequiredArgsConstructor
@Slf4j
public class CategoryElementCreatorImpl implements CategoryElementCreator {

    private final CategoryBusiness categoryBusiness;

    @Override
    @Transactional
    public void saveOrUpdateByEnum(Class<?> enumClass) {
        try {
            String categoryCode = enumClass.getSimpleName();
            Category category = loadOrCreateCategory(categoryCode);
            Set<CategoryElement> categoryElementSet = category.getCategoryElementSet();
            Object[] enumElements = enumClass.getEnumConstants();
            for (Object enumElement : enumElements) {
                try {
                    addCategoryElementToList(category, categoryElementSet, enumElement);
                } catch (NoSuchMethodException ex) {
                    log.error(String.format(
                            MessageCodes.PROBABLY_THERE_IS_NOT_VALUE_OR_CODE_METHOD_IN_THIS_CATEGORY,
                            categoryCode, enumElement));
                } catch (IllegalAccessException ex) {
                    log.error(String.format(
                            MessageCodes.PROBABLY_VALUE_OR_CODE_METHOD_HAS_PRIVATE_IDENTIFIER,
                            categoryCode, enumElement));
                } catch (InvocationTargetException ex) {
                    log.error(String.format(
                            MessageCodes.PROBABLY_VALUE_OR_CODE_METHOD_THAT_YOU_INVOKED_THREW_AN_EXCEPTION,
                            categoryCode, enumElement));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            category.setCategoryElementSet(categoryElementSet);
            categoryBusiness.save(category);
            log.info(String.format(MessageCodes.CATEGORY_PROCEED, categoryCode));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addCategoryElementToList(
            Category category, Set<CategoryElement> categoryElementList, Object enumElement)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> enumElementClass = enumElement.getClass();
        Method valueMethod = enumElementClass.getDeclaredMethod(MessageCodes.CATEGORY_ELEMENT_VALUE);
        Method codeMethod = enumElementClass.getDeclaredMethod(MessageCodes.CATEGORY_ELEMENT_CODE);
        String code = (String) codeMethod.invoke(enumElement);
        String name = (String) valueMethod.invoke(enumElement);
        CategoryElement categoryElement = new CategoryElement();
        String outputPrefix = MessageCodes.CATEGORY_CREATE;
        if (category.getCategoryElementSet() != null) {
            for (CategoryElement element : category.getCategoryElementSet()) {
                if (code.equalsIgnoreCase(element.getCode()) || name.equalsIgnoreCase(element.getValue())) {
                    categoryElement = element;
                    outputPrefix = MessageCodes.CATEGORY_UPDATE;
                }
            }
        }
        categoryElement.setCode(code);
        categoryElement.setValue(name);
        categoryElement.setCategory(category);
        log.error(String.format(outputPrefix, code));
        if (categoryElement.getId() == null) {
            categoryElementList.add(categoryElement);
        }
    }

    private Category loadOrCreateCategory(String categoryCode) {
        Category category = categoryBusiness.findByCode(categoryCode);
        if (category == null) {
            log.error(String.format(MessageCodes.YOU_SHOULD_CREATE_IT_FIRST, categoryCode));
            category = new Category();
            category.setCode(categoryCode);
            category.setValue(categoryCode);
            categoryBusiness.save(category);
        }
        return category;
    }
}