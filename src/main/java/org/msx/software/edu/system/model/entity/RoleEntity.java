package org.msx.software.edu.system.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.ROLE)
@Table(name = TableName.ROLE)
public class RoleEntity extends BaseEntity {

    @Column(name = FieldName.CODE, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String code;
    @Column(name = FieldName.DESCRIPTION, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String description;
    @ManyToMany(mappedBy = FieldName.ROLE_SET, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<UserEntity> userSet = new HashSet<>();
}