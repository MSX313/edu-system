package org.msx.software.edu.system.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.msx.software.edu.system.model.entity.util.*;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter

@Entity(name = EntityName.BOOK)
@Table(name = TableName.BOOK)
public class Book extends MasterEntity {

    /* 1 */
    @Column(name = FieldName.NAME, nullable = false)
    private String name;
    /* 2 */
    @Column(name = FieldName.CREATED_AT, columnDefinition = ColumnDefinitionType.TIME_STAMP)
    private Timestamp createdAt;
    /* 3 */
    @ManyToOne
    @JoinColumn(
            name = FieldName.STUDENT_ID,
            referencedColumnName = FieldName.ID,
            foreignKey = @ForeignKey(name = FieldName.STUDENT_BOOK_ID_FOREIGN_KEY),
            nullable = false)
    private Student student;

    public Book(String name, Timestamp createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }
}