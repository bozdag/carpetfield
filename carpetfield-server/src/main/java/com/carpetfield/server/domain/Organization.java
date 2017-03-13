package com.carpetfield.server.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by selcukb on 08.03.2017.
 */
@Entity
public class Organization implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false) private String name;

	@Column(nullable = false) private String description;

	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY) private Collection<OrganizationMembership> members;

	@JsonBackReference
	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
	private Collection<Game> organizationGames;

	public Organization() {
		members = new ArrayList<>();
	}

	public Organization(String orgName) {
		name = orgName;
	}

	public Organization(String orgName, String orgDescription) {
		name = orgName;
		description = orgDescription;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<OrganizationMembership> getMembers() {
		return members;
	}

	public void setMembers(Collection<OrganizationMembership> members) {
		this.members = members;
	}

	public Collection<Game> getOrganizationGames() {
		return organizationGames;
	}

	public void setOrganizationGames(Collection<Game> organizationGames) {
		this.organizationGames = organizationGames;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(":");
		sj.add(name);
		sj.add(description);
		return sj.toString();
	}
}
