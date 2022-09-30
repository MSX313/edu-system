package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.msx.software.edu.system.model.entity.util.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.COURSE)
@Table(name = TableName.COURSE)
public class Course extends MasterEntity {

    @Column(name = FieldName.NAME, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    /* 1 */
    private String name;
    /* 2 */
    @Column(name = FieldName.DEPARTMENT, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String department;
    /* 3 */
    @Transient
    @GenericGenerator(name = GenericName.UUID, strategy = StrategyName.UUID_2)
    @GeneratedValue(generator = GenericName.UUID)
    @Column(name = FieldName.UUID, unique = true)
    private UUID uuid;
    /* 4 */
    @OneToMany(mappedBy = EntityName.COURSE,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<Enrolment> enrolmentList = new ArrayList<>();

    public Course(String name, String department, UUID uuid) {
        this.name = name;
        this.department = department;
        this.uuid = uuid;
    }
}