package org.msx.software.edu.system.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.ENROLMENT)
@Table(name = TableName.ENROLMENT)
public class Enrolment {

    @EmbeddedId
    private EnrolmentId enrolmentId;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @MapsId(value = FieldName.USER)
    @JoinColumn(name = FieldName.USER, referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.USER_ENTITY_FOREIGN_KEY), nullable = false)
    @JsonIgnore
    private UserEntity userEntity;

    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    @MapsId(value = FieldName.COURSE)
    @JoinColumn(name = FieldName.COURSE, referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.COURSE_FOREIGN_KEY))
    @JsonIgnore
    private Course course;

    @Column(name = FieldName.CREATED_AT, columnDefinition = ColumnDefinitionType.TIME_STAMP)
    private Timestamp createdAt;

    @CreatedBy
    @Column(name = FieldName.INSERT_USER, columnDefinition = ColumnDefinitionType.VARCHAR_2_50)
    private String insertUser;

    @LastModifiedBy
    @Column(name = FieldName.UPDATE_USER, columnDefinition = ColumnDefinitionType.VARCHAR_2_50)
    private String updateUser;

    @CreatedDate
    @Column(name = FieldName.INSERT_DATE_TIME)
    private Timestamp insertDateTime;

    @LastModifiedDate
    @Column(name = FieldName.UPDATE_DATE_TIME)
    private Timestamp updateDateTime;

    @Version
    @Column(name = FieldName.VERSION)
    private Integer version;

    @Column(name = FieldName.IS_ACTIVE, nullable = false)
    private boolean isActive = Boolean.TRUE;
}