package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.msx.software.edu.system.model.entity.util.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@MappedSuperclass
public class MasterEntity {

    /* 1 */
    @Id
    @SequenceGenerator(
            name = SequenceName.MASTER_ENTITY, sequenceName = SequenceName.MASTER_ENTITY, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SequenceName.MASTER_ENTITY)
    @Column(name = FieldName.ID, columnDefinition = ColumnDefinitionType.NUMBER)
    private Long id;
    /* 2 */
    @CreationTimestamp
    @Column(name = FieldName.INSERT_TIME)
    private Timestamp insertTime;
    /* 3 */
    @UpdateTimestamp
    @Column(name = FieldName.UPDATE_TIME)
    private Timestamp updateTime;
    /* 4 */
    @Version
    @Column(name = FieldName.VERSION)
    private Long version;
}