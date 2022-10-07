package org.msx.software.edu.system.service.categoryelement;

import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.common.enums.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
class CategoryCreator {

    private final CategoryElementCreator categoryElementCreator;

    @EventListener(ApplicationReadyEvent.class)
    public void createAllCategories() {
        categoryElementCreator.saveOrUpdateByEnum(EDUContactInformationType.class);
        categoryElementCreator.saveOrUpdateByEnum(EDUCourseType.class);
        categoryElementCreator.saveOrUpdateByEnum(EDUCurrencyType.class);
        categoryElementCreator.saveOrUpdateByEnum(EDUGenderType.class);
        categoryElementCreator.saveOrUpdateByEnum(EDUUserType.class);
    }
}