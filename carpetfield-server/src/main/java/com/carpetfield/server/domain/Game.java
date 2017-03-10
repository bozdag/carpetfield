package com.carpetfield.server.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by selcukb on 08.03.2017.
 */
@Entity
public class Game
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(name = "time_of_creation", nullable = false)
    private Date timeOfCreation;

    @Column(name = "time_of_start", nullable = false)
    private Date timeOfStart;

    @ManyToOne
    private Organization organization;

//    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
//    private Collection<OrganizationMembership> members;

    public Game() {
//        members = new ArrayList<>();
        timeOfCreation = new Date();
    }

    public Game(String gameName) {
        name = gameName;
//        members = new ArrayList<>();
        timeOfCreation = new Date();
    }

    public Game(String gameName, String gameDescription) {
        name = gameName;
        description = gameDescription;
//        members = new ArrayList<>();
        timeOfCreation = new Date();
    }

    public Game(String gameName, String gameDescription, String gameAddress) {
        name = gameName;
        description = gameDescription;
        address = gameAddress;
//        members = new ArrayList<>();
        timeOfCreation = new Date();
    }

    public Game(String gameName, String gameDescription, String gameAddress, Date gameTimeOfStart) {
        name = gameName;
        description = gameDescription;
        address = gameAddress;
        timeOfStart = gameTimeOfStart;
//        members = new ArrayList<>();
        timeOfCreation = new Date();
    }

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

//    public Collection<OrganizationMembership> getMembers() {
//        return members;
//    }

//    public void setMembers(Collection<OrganizationMembership> members) {
//        this.members = members;
//    }
}