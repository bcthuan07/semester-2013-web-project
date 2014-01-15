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
 * ProductType generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "product_type")
public class ProductType implements java.io.Serializable {

	private Integer productTypeId;
	private String description;
	private Set<Product> products = new HashSet<Product>(0);

	public ProductType() {
	}

	public ProductType(String description) {
		this.description = description;
	}

	public ProductType(String description, Set<Product> products) {
		this.description = description;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_type_id", unique = true, nullable = false)
	public Integer getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "productType")
	@LazyCollection(LazyCollectionOption.FALSE)
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductType [productTypeId=" + productTypeId + ", description="
				+ description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
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
		ProductType other = (ProductType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

}
