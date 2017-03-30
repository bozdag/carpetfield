package com.carpetfield.server.controller;

import com.carpetfield.server.domain.User;
import com.carpetfield.server.dto.LoginDTO;
import com.carpetfield.server.dto.LoginResponse;
import com.carpetfield.server.service.UserService;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alicana on 15/03/2017.
 */
@RestController
@RequestMapping("/login")
@EnableAutoConfiguration
public class LoginController {

  @Autowired
  private UserService userService;

  @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
  public
  @ResponseBody
  LoginResponse tryLogin(@RequestBody LoginDTO loginDTO) {

    User user = this.userService.getUserByEmail(loginDTO.getEmail())
        .orElseThrow(() -> new NoSuchElementException("User could not be found!"));
    LoginResponse response = new LoginResponse();

    response.setId(user.getId());
    response.setEmail(user.getEmail());
    response.setValid(true);

    return response;
  }

}
