package com.carpetfield.server.dto;

/**
 * Created by alicana on 16/03/2017.
 */
public class UserOrganizationDTO {

  private Long organizationId;

  private String name;

  private boolean owner;

  public Long getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isOwner() {
    return owner;
  }

  public void setOwner(boolean owner) {
    this.owner = owner;
  }
}
