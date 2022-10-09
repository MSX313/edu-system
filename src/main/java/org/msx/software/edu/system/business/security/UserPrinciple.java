package org.msx.software.edu.system.business.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.msx.software.edu.system.model.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
@AllArgsConstructor
public class UserPrinciple implements UserDetails {

    private static final long serialVersionUid = 1L;
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String image;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrinciple build(UserEntity userEntity) {
        List<GrantedAuthority> authorities =
                userEntity.getRoleSet().stream().map(
                        role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toList());
        return new UserPrinciple(userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getUserName(),
                userEntity.getImage(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserPrinciple user = (UserPrinciple) obj;
        return id == user.id;
    }
}