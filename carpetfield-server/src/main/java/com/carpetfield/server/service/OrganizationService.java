package com.carpetfield.server.service;

import java.util.List;
import java.util.Optional;

import com.carpetfield.server.domain.Organization;

/**
 * Created by alicana on 09/03/2017.
 */

public interface OrganizationService {

	List<Organization> findAll();

	Optional<Organization> findOne(Long id);

	Optional<Organization> findByName(String organizationName);

	Organization saveAndFlush(Organization organization);
}
