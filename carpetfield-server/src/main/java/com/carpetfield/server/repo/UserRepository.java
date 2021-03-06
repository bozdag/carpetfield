package com.carpetfield.server.repo;

import com.carpetfield.server.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by selcukb on 09.03.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findOneByEmail(String email);
}
