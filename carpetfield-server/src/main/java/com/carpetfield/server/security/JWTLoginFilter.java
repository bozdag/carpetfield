package com.carpetfield.server.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by alicana on 28/03/2017.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

  public JWTLoginFilter(String url, AuthenticationManager authManager) {
    super(new AntPathRequestMatcher(url));
    setAuthenticationManager(authManager);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
      throws AuthenticationException, IOException, ServletException {

    AccountCredentials creds = new ObjectMapper()
        .readValue(req.getInputStream(), AccountCredentials.class);

    // retrieve the username and password from the request

    return getAuthenticationManager().authenticate(
        new UsernamePasswordAuthenticationToken(
            creds.getUsername(),
            creds.getPassword(),
            Collections.emptyList()
        )
    );
  }

  // When attemptAuthentication method is successful ...
  // fetch authenticated username and pass it on to TokenAuthenticationService
  @Override
  protected void successfulAuthentication(
      HttpServletRequest req,
      HttpServletResponse res,
      FilterChain chain,
      Authentication auth) throws IOException, ServletException {

    TokenAuthenticationService
        .addAuthentication(res, auth.getName());
  }
}
