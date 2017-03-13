package com.carpetfield.server.domain.auth;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.carpetfield.server.domain.Game;
import com.carpetfield.server.domain.Invitation;
import com.carpetfield.server.domain.OrganizationMembership;
import com.carpetfield.server.domain.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by selcukb on 09.03.2017.
 */
@Entity
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<OrganizationMembership> memberships;

    @JsonBackReference
    @ManyToMany(mappedBy = "userCollection", fetch = FetchType.LAZY)
    private Collection<Game> gameCollection;

    @JsonBackReference
    @ManyToMany(mappedBy = "userCollection", fetch = FetchType.LAZY)
    private Collection<Team> teamCollection;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Invitation> invitationCollection;

    public User()
    {
        this.memberships = new ArrayList<>();
    }

    public User(String userEmail, String userPasswordHashed, Role userRole)
    {
        email = userEmail;
        passwordHash = userPasswordHashed;
        role =  userRole;
    }

    public Long getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public Collection<OrganizationMembership> getMemberships() {
        return memberships;
    }

    public void setMemberships(Collection<OrganizationMembership> memberships) {
        this.memberships = memberships;
    }

    public Collection<Game> getGameCollection() {
        return gameCollection;
    }

    public void setGameCollection(Collection<Game> gameCollection) {
        this.gameCollection = gameCollection;
    }

    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }
}
