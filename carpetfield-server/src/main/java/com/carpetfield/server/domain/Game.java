package com.carpetfield.server.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.carpetfield.server.domain.auth.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by selcukb on 08.03.2017.
 */
@Entity
public class Game implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_of_creation", nullable = false)
    private Date timeOfCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_of_start", nullable = false)
    private Date timeOfStart;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORG_ID", nullable=false)
    private Organization organization;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="games_users", joinColumns=@JoinColumn(name="game_id", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
    private Collection<User> userCollection;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Invitation> invitationCollection;

    @JsonBackReference
    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    private Collection<Team> gameTeams;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTimeOfCreation() {
        return timeOfCreation;
    }

    public Date getTimeOfStart() {
        return timeOfStart;
    }

    public void setTimeOfStart(Date timeOfStart) {
        this.timeOfStart = timeOfStart;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> users) {
        this.userCollection = users;
    }

    public Collection<Invitation> getInvitationCollection() {
        return invitationCollection;
    }

    public void setInvitationCollection(Collection<Invitation> invitationCollection) {
        this.invitationCollection = invitationCollection;
    }

    public Collection<Team> getGameTeams() {
        return gameTeams;
    }

    public void setGameTeams(Collection<Team> gameTeams) {
        this.gameTeams = gameTeams;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(":");
        sj.add(name);
        sj.add(description);
        sj.add(address);
        return sj.toString();
    }
}