package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.STUDENT)
@Table(name = TableName.STUDENT,
        uniqueConstraints =
                {@UniqueConstraint(name = ConstraintName.EMAIL_UNIQUE, columnNames = FieldName.EMAIL),
                        @UniqueConstraint(name = ConstraintName.CODE_UNIQUE, columnNames = FieldName.CODE)})
public class Student extends MasterEntity {

    /* 1 */
    @Column(name = FieldName.CODE, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String code;
    /* 2 */
    @Column(name = FieldName.FIRST_NAME, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String firstName;
    /* 3 */
    @Column(name = FieldName.LAST_NAME, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String lastName;
    /* 4 */
    @Column(name = FieldName.EMAIL, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String email;
    /* 5 */
    @Column(name = FieldName.DATE_OF_BIRTH, columnDefinition = ColumnDefinitionType.TIME_STAMP, nullable = false)
    private Timestamp dateOfBirth;
    /* 6 */
    @OneToOne(
            mappedBy = EntityName.STUDENT,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private StudentIdCard studentIdCard;
    /* 7 */
    @OneToMany(mappedBy = EntityName.STUDENT,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Book> bookList = new ArrayList<>();
    /* 8 */
    @OneToMany(
            mappedBy = EntityName.STUDENT,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Enrolment> enrolmentList = new ArrayList<>();

    public Integer getAge() {
        return Period.between(this.dateOfBirth.toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
    }

    public Student(String code, String firstName, String lastName, String email, Timestamp dateOfBirth) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public void addBook(Book book) {
        if (Boolean.FALSE.equals(this.bookList.contains(book))) {
            this.bookList.add(book);
            book.setStudent(this);
        }
    }

    public void removeBook(Book book) {
        if (Boolean.TRUE.equals(this.bookList.contains(book))) {
            this.bookList.remove(book);
            book.setStudent(null);
        }
    }

    public void addEnrolment(Enrolment enrolment) {
        if (Boolean.FALSE.equals(this.enrolmentList.contains(enrolment))) {
            this.enrolmentList.add(enrolment);
            enrolment.setStudent(this);
        }
    }

    public void removeEnrolment(Enrolment enrolment) {
        if (Boolean.TRUE.equals(enrolmentList.contains(enrolment))) {
            this.enrolmentList.remove(enrolment);
            enrolment.setStudent(null);
        }
    }
}