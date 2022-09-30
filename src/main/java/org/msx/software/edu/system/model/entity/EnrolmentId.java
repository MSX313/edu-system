package org.msx.software.edu.system.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.ColumnDefinitionType;
import org.msx.software.edu.system.model.entity.util.FieldName;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Embeddable
public class EnrolmentId implements Serializable {

    /* 1 */
    @Column(name = FieldName.STUDENT_ID, columnDefinition = ColumnDefinitionType.NUMBER, nullable = false)
private Long studentId;
    /* 2 */
    @Column(name = FieldName.COURSE_ID, columnDefinition = ColumnDefinitionType.NUMBER, nullable = false)
    private Long courseId;
}