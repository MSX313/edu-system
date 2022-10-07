package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.BaseEntity;
import org.msx.software.edu.system.model.entity.util.codes.ColumnDefinitionType;
import org.msx.software.edu.system.model.entity.util.codes.EntityName;
import org.msx.software.edu.system.model.entity.util.codes.FieldName;
import org.msx.software.edu.system.model.entity.util.codes.TableName;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Timestamp;

@RequiredArgsConstructor
@Getter

@Setter

@Entity(name = EntityName.BOOK)
@Table(name = TableName.BOOK)
public class Book extends BaseEntity {

    @Column(name = FieldName.NAME, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String name;

    @Column(name = FieldName.CREATED_AT, columnDefinition = ColumnDefinitionType.TIME_STAMP, nullable = false)
    private Timestamp createdAt;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = FieldName.USER, referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.USER_ENTITY_BOOK_ID_FOREIGN_KEY))
    private UserEntity userEntity;
}