package model;

// Generated 25-Nov-2013 20:54:41 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * OrderItem generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "order_item")
public class OrderItem implements java.io.Serializable {

	private Integer orderItemId;
	private UserOrder userOrder;
	private Product product;
	private int orderQuantity;

	public OrderItem() {
	}

	public OrderItem(UserOrder userOrder, Product product, int orderQuantity) {
		this.userOrder = userOrder;
		this.product = product;
		this.orderQuantity = orderQuantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_item_id", unique = true, nullable = false)
	public Integer getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "user_order_id", nullable = false)
	public UserOrder getUserOrder() {
		return this.userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "order_quantity", nullable = false)
	public int getOrderQuantity() {
		return this.orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

}
