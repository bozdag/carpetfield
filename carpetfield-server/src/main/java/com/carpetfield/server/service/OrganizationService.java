package com.carpetfield.server.service;

import java.util.Collection;
import java.util.Optional;

import com.carpetfield.server.domain.Organization;

/**
 * Created by alicana on 09/03/2017.
 */

public interface OrganizationService {
	Collection<Organization> findAll();

	Optional<Organization> findOne(Long id);
}
