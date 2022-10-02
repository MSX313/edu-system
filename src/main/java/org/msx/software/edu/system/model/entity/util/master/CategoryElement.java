package org.msx.software.edu.system.model.entity.util.master;

import lombok.Getter;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.codes.EntityName;
import org.msx.software.edu.system.model.entity.util.codes.FieldName;
import org.msx.software.edu.system.model.entity.util.codes.TableName;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity(name = EntityName.CATEGORY_ELEMENT)
@Table(name = TableName.CATEGORY_ELEMENT)
@Getter
@Setter
@Cacheable(value = true)
public class CategoryElement extends BaseEntity {

    @Column(name = FieldName.CODE, nullable = false)
    private String code;
    @Column(name = FieldName.VALUE, nullable = false)
    private String value;
    @ManyToOne(
            targetEntity = Category.class,
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = FieldName.CATEGORY,
            referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.CATEGORY_CATEGORY_ELEMENT_ID_FOREIGN_KEY))
    private Category category;
}