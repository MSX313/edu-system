package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.msx.software.edu.system.model.entity.util.BaseEntity;
import org.msx.software.edu.system.model.entity.util.codes.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.COURSE)
@Table(name = TableName.COURSE)
public class Course extends BaseEntity {

    @Column(name = FieldName.NAME, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String name;

    @Column(name = FieldName.DEPARTMENT, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String department;

    @Column(name = FieldName.COST, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String cost;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = FieldName.CURRENCY_TYPE_COST, nullable = false)
    private CategoryElement currencyTypeCost;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = FieldName.TYPE, nullable = false)
    private CategoryElement type;

    @Transient
    @GenericGenerator(name = GenericName.UUID, strategy = StrategyName.UUID_2)
    @GeneratedValue(generator = GenericName.UUID)
    @Column(name = FieldName.UUID)
    private UUID uuid;

    @OneToMany(mappedBy = EntityName.COURSE, cascade = CascadeType.ALL, orphanRemoval = true,
            targetEntity = Enrolment.class, fetch = FetchType.LAZY)
    private List<Enrolment> enrolmentList = new ArrayList<>();

    public void addEnrolment(Enrolment enrolment) {
        if (Boolean.FALSE.equals(this.enrolmentList.contains(enrolment))) {
            this.enrolmentList.add(enrolment);
            enrolment.setCourse(this);
        }
    }

    public void removeEnrolment(Enrolment enrolment) {
        if (Boolean.TRUE.equals(enrolmentList.contains(enrolment))) {
            this.enrolmentList.remove(enrolment);
            enrolment.setCourse(null);
        }
    }
}