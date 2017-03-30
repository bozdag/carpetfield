package com.carpetfield.server.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by selcukb on 09.03.2017.
 */
@Entity
@Table(name = "user")
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<OrganizationMembership> memberships= new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "userCollection", fetch = FetchType.LAZY)
    private Collection<Game> gameCollection;

    @JsonBackReference
    @ManyToMany(mappedBy = "userCollection", fetch = FetchType.LAZY)
    private Collection<Team> teamCollection;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Invitation> invitationCollection;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Collection<OrganizationMembership> getMemberships() {
        return memberships;
    }

    public void setMemberships(
        Collection<OrganizationMembership> memberships) {
        this.memberships = memberships;
    }

    public Collection<Game> getGameCollection() {
        return gameCollection;
    }

    public void setGameCollection(
        Collection<Game> gameCollection) {
        this.gameCollection = gameCollection;
    }

    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    public void setTeamCollection(
        Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }

    public Collection<Invitation> getInvitationCollection() {
        return invitationCollection;
    }

    public void setInvitationCollection(
        Collection<Invitation> invitationCollection) {
        this.invitationCollection = invitationCollection;
    }
}
