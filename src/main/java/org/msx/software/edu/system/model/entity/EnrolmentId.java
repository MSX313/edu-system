package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.codes.ColumnDefinitionType;
import org.msx.software.edu.system.model.entity.util.codes.FieldName;
import org.msx.software.edu.system.util.Hashable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@RequiredArgsConstructor
@Getter
@Setter

@Embeddable
public class EnrolmentId extends Hashable {


    @Column(name = FieldName.USER_ENTITY_ID, columnDefinition = ColumnDefinitionType.NUMBER, nullable = false)
    private Long userEntityId;

    @Column(name = FieldName.COURSE_ID, columnDefinition = ColumnDefinitionType.NUMBER, nullable = true)
    private Long courseId;
}