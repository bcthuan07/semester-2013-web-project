package entity;

// Generated 25-Nov-2013 20:54:41 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * UserOrder generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user_order")
public class UserOrder implements java.io.Serializable {

	private Integer userOrderId;
	private User user;
	private OrderStatus orderStatus;
	private Date orderDate;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);

	public UserOrder() {
	}

	public UserOrder(User user, OrderStatus orderStatus, Date orderDate) {
		this.user = user;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	public UserOrder(User user, OrderStatus orderStatus, Date orderDate,
			Set<OrderItem> orderItems) {
		this.user = user;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderItems = orderItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_order_id", unique = true, nullable = false)
	public Integer getUserOrderId() {
		return this.userOrderId;
	}

	public void setUserOrderId(Integer userOrderId) {
		this.userOrderId = userOrderId;
	}

	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "order_status_id", nullable = false)
	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@OneToMany(mappedBy = "userOrder")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
