package com.carpetfield.server;

import java.util.List;

import com.carpetfield.server.controller.OrganizationController;
import com.carpetfield.server.domain.Organization;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by alicana on 10/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.JVM)
public class OrganizationControllerTest {

	@Autowired private OrganizationController organizationController;

	@Test
	public void getAllTest() {

		List<Organization> list = organizationController.list();
		assertNotNull(list);
		assertEquals(2, list.size());
		assertTrue(list.get(0).getName().equals("şentepe"));
	}

	@Test
	public void getByIdTest() {
		Organization organization = organizationController.getOrganization(1l);
		assertTrue(organization.getName().equals("şentepe"));
	}

	@Test
	public void addOrganizationTest() {

		Organization organization = new Organization();
		organization.setName("Test_ORG");
		organization.setDescription("Some descriptive text here ...");

		Organization result = organizationController.addOrganization(organization);
		assertNotNull(result);
	}

}