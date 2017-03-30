package com.carpetfield.server.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by seckink on 3/10/2017.
 */
@Entity
@Table(name = "invitation_response_type")
public class InvitationResponseType implements Serializable {

  @Id
  int id;

  @Column(nullable = false)
  String status;

  public int getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
