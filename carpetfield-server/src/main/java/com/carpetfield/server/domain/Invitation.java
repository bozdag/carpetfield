package com.carpetfield.server.domain;

import javax.jws.Oneway;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import com.carpetfield.server.domain.auth.User;

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

    public Invitation(String context, Game game, User user){
        timeOfInvitation = new Date();
        this.context = context;
        this.game = game;
        this.user = user;
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
