package com.carpetfield.server.repo;

import com.carpetfield.server.domain.Organization;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alicana on 09/03/2017.
 */

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

  Optional<Organization> findByNameIgnoreCase(String name);

}
