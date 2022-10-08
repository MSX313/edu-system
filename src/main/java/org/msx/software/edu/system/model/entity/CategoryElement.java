package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.BaseEntity;
import org.msx.software.edu.system.model.entity.util.codes.ColumnDefinitionType;
import org.msx.software.edu.system.model.entity.util.codes.EntityName;
import org.msx.software.edu.system.model.entity.util.codes.FieldName;
import org.msx.software.edu.system.model.entity.util.codes.TableName;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.CATEGORY_ELEMENT)
@Table(name = TableName.CATEGORY_ELEMENT)
public class CategoryElement extends BaseEntity {

    @Column(name = FieldName.CODE, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String code;

    @Column(name = FieldName.VALUE, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String value;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = FieldName.CATEGORY, referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.CATEGORY_FOREIGN_KEY), nullable = false)
    private Category category;
}