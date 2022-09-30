package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.master.BaseEntity;
import org.msx.software.edu.system.model.entity.util.codes.*;

import javax.persistence.Entity;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = EntityName.STUDENT_ID_CARD)
@Table(name = TableName.STUDENT_ID_CARD,
        uniqueConstraints =
                {@UniqueConstraint(name = ConstraintName.CARD_NUMBER_UNIQUE, columnNames = FieldName.CARD_NUMBER)})
public class StudentIdCard extends BaseEntity {

    /* 1 */
    @Column(name = FieldName.CARD_NUMBER, columnDefinition = ColumnDefinitionType.VARCHAR_2_15)
    private String cardNumber;
    /* 2 */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = FieldName.STUDENT_ID,
            referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.STUDENT_CARD_ID_FOREIGN_KEY),
            nullable = false)
    private Student student;

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }
}