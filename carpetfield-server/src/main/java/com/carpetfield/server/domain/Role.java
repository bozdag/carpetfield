package com.carpetfield.server.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by alicana on 30/03/2017.
 */

@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Enumerated(EnumType.STRING)
  private RoleEnum roleEnum;

  @JsonBackReference
  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RoleEnum getRoleEnum() {
    return roleEnum;
  }

  public void setRoleEnum(RoleEnum roleEnum) {
    this.roleEnum = roleEnum;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }
}
