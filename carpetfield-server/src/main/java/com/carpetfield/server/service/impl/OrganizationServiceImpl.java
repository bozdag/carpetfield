package com.carpetfield.server.service.impl;

import java.util.Collection;
import java.util.Optional;

import com.carpetfield.server.domain.Organization;
import com.carpetfield.server.repo.OrganizationRepository;
import com.carpetfield.server.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alicana on 09/03/2017.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public Collection<Organization> findAll(){
		return organizationRepository.findAll();
	}

	@Override
	public Optional<Organization> findOne(Long id) {
		return Optional.ofNullable(organizationRepository.findOne(id));

	}

}
