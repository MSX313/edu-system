package org.msx.software.edu.system.model.entity.util.master;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_SEC_USER")
@SequenceGenerator(name = "ent_id_generator", sequenceName = "SQ_USER_ID", allocationSize = 1)
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Column(name = "C_USER_NAME", nullable = false)
    private String userName;
    @Column(name = "C_PASSWORD", nullable = false)
    private String password;
    @Column(name = "C_FIRST_NAME")
    private String firstName;
    @Column(name = "C_LAST_NAME")
    private String lastName;
    @Column(name = "C_EMAIL")
    private String email;
    @Column(name = "C_IMAGE")
    private String image;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "T_SEC_USER_ROLE",
            joinColumns = @JoinColumn(name = "F_USER", referencedColumnName = "C_ID"),
            inverseJoinColumns = @JoinColumn(name = "F_ROLE", referencedColumnName = "C_ID"))
    private Set<RoleEntity> roleSet;
}