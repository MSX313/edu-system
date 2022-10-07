package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.BaseEntity;
import org.msx.software.edu.system.model.entity.util.codes.*;

import javax.persistence.*;
import javax.persistence.Entity;

@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.CONTACT_INFORMATION)
@Table(name = TableName.CONTACT_INFORMATION,
        uniqueConstraints =
                {@UniqueConstraint(name = ConstraintName.VALUE_UNIQUE, columnNames = FieldName.VALUE)})
public class ContactInformation extends BaseEntity {

    @Column(name = FieldName.VALUE, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String value;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = FieldName.CONTACT_INFORMATION_TYPE, nullable = false)
    private CategoryElement type;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = FieldName.USER, referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.USER_ENTITY_CONTACT_INFORMATION_ID_FOREIGN_KEY))
    private UserEntity userEntity;
}