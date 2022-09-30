package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.codes.ColumnDefinitionType;
import org.msx.software.edu.system.model.entity.util.codes.EntityName;
import org.msx.software.edu.system.model.entity.util.codes.FieldName;
import org.msx.software.edu.system.model.entity.util.codes.TableName;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

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
    @CreatedBy
    @Column(name = FieldName.INSERT_USER, columnDefinition = ColumnDefinitionType.VARCHAR_2_50)
    private String insertUser;
    /* 6 */
    @LastModifiedBy
    @Column(name = FieldName.UPDATE_USER, columnDefinition = ColumnDefinitionType.VARCHAR_2_50)
    private String updateUser;
    /* 7 */
    @CreatedDate
    /*@CreationTimestamp*/
    @Column(name = FieldName.INSERT_DATE_TIME)
    private Timestamp insertDateTime;
    /* 8 */
    @LastModifiedDate
    /*@UpdateTimestamp*/
    @Column(name = FieldName.UPDATE_DATE_TIME)
    private Timestamp updateDateTime;
    /* 9 */
    @Version
    @Column(name = FieldName.VERSION)
    private Integer version;
    /* 10 */
    @Column(name = FieldName.IS_ACTIVE, nullable = false)
    private boolean activeState = true;

    public Enrolment(EnrolmentId enrolmentId, Student student, Course course, Timestamp createdAt) {
        this.enrolmentId = enrolmentId;
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }
}