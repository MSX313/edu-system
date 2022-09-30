package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.msx.software.edu.system.model.entity.util.ColumnDefinitionType;
import org.msx.software.edu.system.model.entity.util.EntityName;
import org.msx.software.edu.system.model.entity.util.FieldName;
import org.msx.software.edu.system.model.entity.util.TableName;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.ENROLMENT)
@Table(name = TableName.ENROLMENT)
public class Enrolment {

    /* 1 */
    @EmbeddedId
    private EnrolmentId enrolmentId;
    /* 2 */
    @ManyToOne
    @MapsId(value = FieldName.STUDENT_ID)
    @JoinColumn(
            name = FieldName.STUDENT_ID,
            referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.STUDENT_ENROLMENT_ID_FOREIGN_KEY)
    )
    private Student student;
    /* 3 */
    @ManyToOne
    @MapsId(value = FieldName.COURSE_ID)
    @JoinColumn(
            name = FieldName.COURSE_ID,
            referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.COURSE_ID_FOREIGN_KEY))
    private Course course;
    /* 4 */
    @Column(name = FieldName.CREATED_AT, columnDefinition = ColumnDefinitionType.TIME_STAMP)
    private Timestamp createdAt;
    /* 5 */
    @CreationTimestamp
    @Column(name = FieldName.INSERT_TIME)
    private Timestamp insertTime;
    /* 6 */
    @UpdateTimestamp
    @Column(name = FieldName.UPDATE_TIME)
    private Timestamp updateTime;
    /* 7 */
    @Version
    @Column(name = FieldName.VERSION)
    private Long version;

    public Enrolment(EnrolmentId enrolmentId, Student student, Course course, Timestamp createdAt) {
        this.enrolmentId = enrolmentId;
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }
}