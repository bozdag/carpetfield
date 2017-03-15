package com.carpetfield.server.domain;

import java.io.Serializable;

/**
 * Created by alicana on 09/03/2017.
 */
public class OrganizationMembershipId implements Serializable {

	private Long userId;
	private Long organizationId;

	public OrganizationMembershipId() {
	}

	public OrganizationMembershipId(Long userId, Long organizationId) {
		this.userId = userId;
		this.organizationId = organizationId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public Long getUserId() {
		return userId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof OrganizationMembershipId))
			return false;

		OrganizationMembershipId that = (OrganizationMembershipId) o;

		if (!getUserId().equals(that.getUserId()))
			return false;
		return getOrganizationId().equals(that.getOrganizationId());

	}

	@Override
	public int hashCode() {
		int result = getUserId().hashCode();
		result = 31 * result + getOrganizationId().hashCode();
		return result;
	}
}
