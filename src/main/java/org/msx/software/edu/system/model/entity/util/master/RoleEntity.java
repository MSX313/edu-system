package org.msx.software.edu.system.model.entity.util.master;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_SEC_ROLE")
@Getter
@Setter
public class RoleEntity extends BaseEntity {

    @Column(name = "C_ROLE_CODE", nullable = false)
    private String roleCode;
    @Column(name = "C_DESCRIPTION")
    private String description;
}