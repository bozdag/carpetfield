package com.carpetfield.server.dto;

import java.io.Serializable;

/**
 * Created by alicana on 15/03/2017.
 */
public class LoginResponse implements Serializable {

  private Long id;
  private String email;
  private boolean valid;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }
}
