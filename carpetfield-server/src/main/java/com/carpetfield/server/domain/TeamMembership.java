package com.carpetfield.server.domain;

import com.carpetfield.server.domain.auth.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by selcukb on 10.03.2017.
 */
@Entity
@Table(name = "CF_TEAM_MEMBERSHIP")
@IdClass(TeamMembershipId.class)
public class TeamMembership
{
    @Id
    @Column(name="USER_ID", insertable=false, updatable=false)
    private long userId;
    @Id
    @Column(name="TEAM_ID", insertable=false, updatable=false)
    private long teamId;

    @Id
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable = false)
    @JsonBackReference
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="TEAM_ID", nullable = false)
    @JsonBackReference
    private Team team;

    @Column(name = "IS_CAPTAIN")
    private boolean captain;

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE", updatable=false)
    private Date startDate;


    public TeamMembership()
    {

    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public long getTeamId()
    {
        return teamId;
    }

    public void setTeamId(long teamId)
    {
        this.teamId = teamId;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public boolean isCaptain()
    {
        return captain;
    }

    public void setCaptain(boolean captain)
    {
        this.captain = captain;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
}
