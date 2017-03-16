package com.carpetfield.server.repo;

import java.util.Collection;
import java.util.Optional;

import com.carpetfield.server.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alicana on 09/03/2017.
 */

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	Optional<Organization> findByNameIgnoreCase(String name);

}
