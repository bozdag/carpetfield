package com.carpetfield.server.domain;

import java.io.Serializable;

/**
 * Created by selcukb on 10.03.2017.
 */
public class TeamMembershipId implements Serializable {

  private Long userId;
  private Long teamId;

  public TeamMembershipId() {
  }

  public TeamMembershipId(Long uid, Long tid) {
    userId = uid;
    teamId = tid;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TeamMembershipId that = (TeamMembershipId) o;

    if (!userId.equals(that.userId)) {
      return false;
    }
    return teamId.equals(that.teamId);
  }

  @Override
  public int hashCode() {
    int result = userId.hashCode();
    result = 335021 * result + teamId.hashCode();
    return result;
  }
}
