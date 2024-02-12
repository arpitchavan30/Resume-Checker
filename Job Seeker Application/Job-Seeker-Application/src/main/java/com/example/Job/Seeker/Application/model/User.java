package com.example.Job.Seeker.Application.model;

import com.example.Job.Seeker.Application.controller.Role;
import com.example.Job.Seeker.Application.token.Token;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue (strategy  = GenerationType.AUTO)
    private Integer id;

    private String firstname;
    private String lastname;

    private String organization;
    private String registrationNumber;
    private String email;
    private String password;
    private boolean active=true;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Client> clients=new ArrayList<>();

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Agent> agents=new ArrayList<>();

    @OneToMany(mappedBy = "users",cascade=CascadeType.ALL)
    private List<UserRole> userRoles =new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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


}
