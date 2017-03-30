package com.carpetfield.server.dto;

import java.io.Serializable;

/**
 * Created by alicana on 15/03/2017.
 */
public class LoginDTO implements Serializable {

  private String email;

  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
