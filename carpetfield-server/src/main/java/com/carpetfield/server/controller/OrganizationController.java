package com.carpetfield.server.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.carpetfield.server.domain.Organization;
import com.carpetfield.server.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alicana on 09/03/2017.
 */
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Organization> list() {
		return organizationService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable Long id) {
		return organizationService.findOne(id).orElseThrow(() -> new NoSuchElementException("Organization not found!"));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Organization addOrganization(@RequestBody Organization organization){
		return organizationService.saveAndFlush(organization);
	}

}
