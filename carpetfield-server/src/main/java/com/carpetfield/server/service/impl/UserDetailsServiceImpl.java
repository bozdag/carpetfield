package com.carpetfield.server.service.impl;

import com.carpetfield.server.domain.Role;
import com.carpetfield.server.repo.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alicana on 30/03/2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    com.carpetfield.server.domain.User user = userRepository.findOneByEmail(email).get();

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    for (Role role : user.getRoles()) {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleEnum().toString()));
    }

    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(), grantedAuthorities);
  }


}
