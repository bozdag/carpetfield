package com.carpetfield.server.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by selcukb on 08.03.2017.
 */
@Entity
public class Invitation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String context;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "invitation_time", nullable = false)
    private Date timeOfInvitation;

    @ManyToOne()
    @JoinColumn(name="GAME_ID", nullable=false)
    private Game game;

    @ManyToOne()
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;

    @OneToOne()
    @JoinColumn(name="RESPONSE_TYPE_ID", nullable=false)
    private InvitationResponseType response;

    public Invitation(){
        timeOfInvitation = new Date();
    }


    public Long getId() {
        return id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTimeOfInvitation() {
        return timeOfInvitation;
    }

    public Game getGame() {
        return game;
    }

    public InvitationResponseType getResponse() {
        return response;
    }

    public void setResponse(InvitationResponseType response) {
        this.response = response;
    }
}
