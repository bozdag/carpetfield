package com.carpetfield.server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by alicana on 09/03/2017.
 */

@Entity
@Table(name = "CF_MEMBERSHIP")
@IdClass(OrganizationMembershipId.class)
public class OrganizationMembership {

	@Id
	@Column(name="USER_ID", insertable=false, updatable=false)
	private long userId;
	@Id
	@Column(name="ORG_ID", insertable=false, updatable=false)
	private long organizationId;

	@Id
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable = false)
	@JsonBackReference
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name="ORG_ID", nullable = false)
	@JsonBackReference
	private Organization organization;

	@Column(name = "IS_OWNER")
	private boolean owner;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_DATE", updatable=false)
	private Date startDate;

	public Organization getOrganization() {
		return organization;
	}

	public User getUser() {
		return user;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public long getUserId() {
		return userId;
	}

	public boolean isOwner() {
		return owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
