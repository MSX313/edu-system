package org.msx.software.edu.system.service.categoryelement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msx.software.edu.system.exception.CommonException;
import org.msx.software.edu.system.model.entity.util.master.Category;
import org.msx.software.edu.system.model.entity.util.master.CategoryElement;
import org.msx.software.edu.system.repository.util.master.CategoryElementRepository;
import org.msx.software.edu.system.service.category.CategoryBusiness;
import org.msx.software.edu.system.util.GenericUtil;
import org.msx.software.edu.system.util.codes.Constants;
import org.msx.software.edu.system.util.codes.MessageCodes;

import javax.inject.Named;
import java.util.HashSet;
import java.util.Set;

@Named
@RequiredArgsConstructor
@Slf4j
public class CategoryElementBusinessImpl implements CategoryElementBusiness {

    private final CategoryElementRepository categoryElementRepository;
    private final CategoryBusiness categoryBusiness;

    @Override
    public CategoryElement findByCode(String code) {
        return categoryElementRepository.findByCode(code);
    }

    @Override
    public Boolean isCodeExistInEnum(String code, Class<?> enumClass) {
        log.debug(String.format(MessageCodes.INPUT_CODE, code));
        log.debug(String.format(MessageCodes.ENUM_CLASS, enumClass.getSimpleName()));
        boolean isCodeExistInEnum = Boolean.FALSE;
        if (code != null) {
            for (Object enumConstant : enumClass.getEnumConstants()) {
                try {
                    String enumCode = (String) GenericUtil.invokeMethodByClass(
                            enumClass, enumConstant, Constants.ENUM_CODE);
                    log.debug(String.format(MessageCodes.ENUM_CODE, enumCode));
                    if (code.equals(enumCode)) {
                        log.debug(MessageCodes.FOUND_CODE_IN_ENUM);
                        isCodeExistInEnum = Boolean.TRUE;
                        break;
                    }
                } catch (CommonException e) {
                    e.printStackTrace();
                }
            }
        }
        log.debug(String.format(MessageCodes.RESULT, isCodeExistInEnum));
        return isCodeExistInEnum;
    }

    @Override
    public Set<CategoryElement> getByEnumCode(String enumClass) {
        Set<CategoryElement> categoryElementList = new HashSet<>();
        if (enumClass != null) {
            Category category = categoryBusiness.findByCode(enumClass);
            if (category != null) {
                categoryElementList = category.getCategoryElementSet();
            }
        }
        return categoryElementList;
    }
}