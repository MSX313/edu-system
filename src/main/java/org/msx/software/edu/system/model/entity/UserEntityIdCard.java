package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.BaseEntity;
import org.msx.software.edu.system.model.entity.util.codes.*;

import javax.persistence.Entity;
import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.USER_ENTITY_ID_CARD)
@Table(name = TableName.USER_ENTITY_ID_CARD,
        uniqueConstraints =
                {@UniqueConstraint(name = ConstraintName.CARD_NUMBER_UNIQUE, columnNames = FieldName.CARD_NUMBER)})
public class UserEntityIdCard extends BaseEntity {


    @Column(name = FieldName.CARD_NUMBER, columnDefinition = ColumnDefinitionType.VARCHAR_2_25)
    private String cardNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = FieldName.USER, referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.USER_ENTITY_FOREIGN_KEY), nullable = false)
    private UserEntity userEntity;
}