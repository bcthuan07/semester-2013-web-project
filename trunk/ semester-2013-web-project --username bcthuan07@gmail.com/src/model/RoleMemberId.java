/**
 * 
 */
package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Thuan
 *
 */
@Embeddable
public class RoleMemberId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer roleId;
	
	/**
	 * 
	 */
	public RoleMemberId() {
		// TODO Auto-generated constructor stub
	}
	
	@Column(name="user", nullable=false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="role",nullable=false)
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleMemberId other = (RoleMemberId) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

	/**
	 * @param userId
	 * @param roleId
	 */
	public RoleMemberId(Integer userId, Integer roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "RoleMemberId [userId=" + userId + ", roleId=" + roleId + "]";
	}
	
	
}
