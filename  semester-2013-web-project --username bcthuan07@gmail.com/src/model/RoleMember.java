/**
 * 
 */
package model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Thuan
 * 
 */
@Entity
@Table(name = "role_member")
public class RoleMember implements java.io.Serializable {

	private User user;
	private Role role;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RoleMemberId id;

	/**
	 * 
	 */
	public RoleMember() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param user
	 * @param role
	 */
	public RoleMember(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "user", nullable = false)),
			@AttributeOverride(name = "roleId", column = @Column(name = "role", nullable = false)) })
	public RoleMemberId getId() {
		return this.id;
	}

	public void setId(RoleMemberId id) {
		this.id = id;
	}

	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "user", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "role", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		RoleMember other = (RoleMember) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @param user
	 * @param role
	 * @param id
	 */
	public RoleMember(User user, Role role, RoleMemberId id) {
		super();
		this.user = user;
		this.role = role;
		this.id = id;
	}

	/**
	 * @param id
	 */
	public RoleMember(RoleMemberId id) {
		super();
		this.id = id;
	}
	
	

}
