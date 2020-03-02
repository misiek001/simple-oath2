package com.mbor.domain.security;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Set<Privilege> privileges = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    @NaturalId
    private String name;

    public Role() {
        super();
    }

    public Role(final String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        users.add(user);
        user.getRoles().add(this);
    }

    public void addPrivilege(Privilege privilege){
        privileges.add(privilege);
        privilege.getRoles().add(this);
    }

    public void setPrivileges(final Set<Privilege> privileges) {
        this.privileges = privileges;
    }



}
