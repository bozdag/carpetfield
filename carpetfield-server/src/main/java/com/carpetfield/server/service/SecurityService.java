package com.carpetfield.server.service;

/**
 * Created by alicana on 30/03/2017.
 */
public interface SecurityService {

  String findLoggedInUsername();

  void autoLogin(String username, String password);

}
