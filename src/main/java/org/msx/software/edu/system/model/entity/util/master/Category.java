package org.msx.software.edu.system.model.entity.util.master;

import lombok.Getter;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.codes.EntityName;
import org.msx.software.edu.system.model.entity.util.codes.FieldName;
import org.msx.software.edu.system.model.entity.util.codes.TableName;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = EntityName.CATEGORY)
@Table(name = TableName.CATEGORY)
@Getter
@Setter
public class Category extends BaseEntity {

    @Column(name = FieldName.CODE, nullable = false)
    private String code;
    @Column(name = FieldName.VALUE, nullable = false)
    private String value;
    @OneToMany(
            mappedBy = EntityName.CATEGORY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            targetEntity = CategoryElement.class,
            fetch = FetchType.LAZY)
    private Set<CategoryElement> categoryElementSet = new HashSet<>();
}