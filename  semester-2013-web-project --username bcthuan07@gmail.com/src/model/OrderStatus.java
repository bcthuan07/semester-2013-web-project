package model;

// Generated 25-Nov-2013 20:54:41 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * OrderStatus generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "order_status")
public class OrderStatus implements java.io.Serializable {

	private Integer orderStatusId;
	private String description;
	private Set<UserOrder> userOrders = new HashSet<UserOrder>(0);

	public OrderStatus() {
	}

	public OrderStatus(String description) {
		this.description = description;
	}

	public OrderStatus(String description, Set<UserOrder> userOrders) {
		this.description = description;
		this.userOrders = userOrders;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_status_id", unique = true, nullable = false)
	public Integer getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "orderStatus")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}
	
}
