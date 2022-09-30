package org.msx.software.edu.system.model.entity.util.master;

import lombok.Getter;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.codes.ColumnDefinitionType;
import org.msx.software.edu.system.model.entity.util.codes.FieldName;
import org.msx.software.edu.system.model.entity.util.codes.SequenceName;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity implements Entity {

    /* 1 */
    @Id
    @SequenceGenerator(
            name = SequenceName.BASIC_ENTITY, sequenceName = SequenceName.BASIC_ENTITY, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SequenceName.BASIC_ENTITY)
    @Column(name = FieldName.ID, columnDefinition = ColumnDefinitionType.NUMBER, nullable = false)
    private Long id;
    /* 2 */
    @CreatedBy
    @Column(name = FieldName.INSERT_USER, columnDefinition = ColumnDefinitionType.VARCHAR_2_50)
    private String insertUser;
    /* 3 */
    @LastModifiedBy
    @Column(name = FieldName.UPDATE_USER, columnDefinition = ColumnDefinitionType.VARCHAR_2_50)
    private String updateUser;
    /* 4 */
    @CreatedDate
    /*@CreationTimestamp*/
    @Column(name = FieldName.INSERT_DATE_TIME)
    private Timestamp insertDateTime;
    /* 5 */
    @LastModifiedDate
    /*@UpdateTimestamp*/
    @Column(name = FieldName.UPDATE_DATE_TIME)
    private Timestamp updateDateTime;
    /* 6 */
    @Version
    @Column(name = FieldName.VERSION)
    private Integer version;
    /* 7 */
    @Column(name = FieldName.IS_ACTIVE, nullable = false)
    private boolean isActive = Boolean.TRUE;
}