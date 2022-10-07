package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.BaseEntity;
import org.msx.software.edu.system.model.entity.util.codes.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.USER)
@Table(name = TableName.USER,
        uniqueConstraints =
                {@UniqueConstraint(name = ConstraintName.EMAIL_UNIQUE, columnNames = FieldName.EMAIL),
                        @UniqueConstraint(name = ConstraintName.CODE_UNIQUE, columnNames = FieldName.CODE),
                        @UniqueConstraint(name = ConstraintName.USER_NAME_UNIQUE, columnNames = FieldName.USER_NAME)})
@SequenceGenerator(
        name = SequenceName.USER_ENTITY, sequenceName = SequenceName.USER_ENTITY, allocationSize = 1)
public class UserEntity extends BaseEntity {

    @OneToOne(mappedBy = EntityName.USER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserEntityIdCard userEntityIdCard;

    @Column(name = FieldName.CODE, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String code;

    @Column(name = FieldName.USER_NAME, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String userName;

    @Column(name = FieldName.PASSWORD, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String password;

    @Column(name = FieldName.FIRST_NAME, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String firstName;

    @Column(name = FieldName.LAST_NAME, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = false)
    private String lastName;

    @Column(name = FieldName.IMAGE, columnDefinition = ColumnDefinitionType.VARCHAR_2_50, nullable = true)
    private String image;

    @Column(name = FieldName.DATE_OF_BIRTH, columnDefinition = ColumnDefinitionType.TIME_STAMP, nullable = false)
    private Timestamp dateOfBirth;

    @Column(name = FieldName.EMAIL)
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = FieldName.GENDER_TYPE, nullable = false)
    private CategoryElement gender;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = FieldName.TYPE, nullable = false)
    private CategoryElement type;

    @OneToMany(mappedBy = EntityName.USER, cascade = CascadeType.ALL, orphanRemoval = true,
            targetEntity = ContactInformation.class, fetch = FetchType.LAZY)
    private Set<ContactInformation> contactInformationSet = new HashSet<>();

    @OneToMany(mappedBy = EntityName.USER, cascade = CascadeType.ALL, orphanRemoval = true,
            targetEntity = Enrolment.class, fetch = FetchType.LAZY)
    private List<Enrolment> enrolmentList = new ArrayList<>();

    @OneToMany(mappedBy = EntityName.USER, cascade = CascadeType.ALL, orphanRemoval = true,
            targetEntity = Book.class, fetch = FetchType.LAZY)
    private Set<Book> bookSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = TableName.JT_USER_ROLE,
            joinColumns = @JoinColumn(name = FieldName.USER, referencedColumnName = FieldName.ID),
            inverseJoinColumns = @JoinColumn(name = FieldName.ROLE, referencedColumnName = FieldName.ID))
    private Set<RoleEntity> roleSet = new HashSet<>();

    public Integer getAge() {
        return Period.between(this.dateOfBirth.toLocalDateTime().toLocalDate(), LocalDate.now()).getYears();
    }

    public void addContactInformation(ContactInformation contactInformation) {
        if (Boolean.FALSE.equals(this.contactInformationSet.contains(contactInformation))) {
            this.contactInformationSet.add(contactInformation);
            contactInformation.setUserEntity(this);
        }
    }

    public void removeContactInformation(ContactInformation contactInformation) {
        if (Boolean.TRUE.equals(this.contactInformationSet.contains(contactInformation))) {
            this.contactInformationSet.remove(contactInformation);
            contactInformation.setUserEntity(null);
        }
    }

    public void addBook(Book book) {
        if (Boolean.FALSE.equals(this.bookSet.contains(book))) {
            this.bookSet.add(book);
            book.setUserEntity(this);
        }
    }

    public void removeBook(Book book) {
        if (Boolean.TRUE.equals(this.bookSet.contains(book))) {
            this.bookSet.remove(book);
            book.setUserEntity(null);
        }
    }

    public void addEnrolment(Enrolment enrolment) {
        if (Boolean.FALSE.equals(this.enrolmentList.contains(enrolment))) {
            this.enrolmentList.add(enrolment);
            enrolment.setUserEntity(this);
        }
    }

    public void removeEnrolment(Enrolment enrolment) {
        if (Boolean.TRUE.equals(enrolmentList.contains(enrolment))) {
            this.enrolmentList.remove(enrolment);
            enrolment.setUserEntity(null);
        }
    }
}