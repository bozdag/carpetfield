package com.carpetfield.server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_DATE", updatable=false)
    private Date startDate;

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
