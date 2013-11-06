package entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="meal")
public class Meal {
	@Id
	@Column(name="idmeal", nullable=false)
	private int idMeal;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="datecreated", nullable=false)
	private Timestamp datecreated;
	
	@Column(name="picture", nullable=false)
	private String picture;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idmealtype",nullable=false)
	private MealType mealtype;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idmealkind",nullable=false)
	private MealKind mealkind;
	
	@Column(name="intro")
	private String intro;
	
	@Column(name="price",nullable=false)
	private double price;

	public Meal(int idMeal, String name, Timestamp datecreated, String picture,
			MealType mealtype, MealKind mealkind, String intro, double price) {
		super();
		this.idMeal = idMeal;
		this.name = name;
		this.datecreated = datecreated;
		this.picture = picture;
		this.mealtype = mealtype;
		this.mealkind = mealkind;
		this.intro = intro;
		this.price = price;
	}
	
	public Meal(){}

	public int getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public MealType getMealtype() {
		return mealtype;
	}

	public void setMealtype(MealType mealtype) {
		this.mealtype = mealtype;
	}

	public MealKind getMealkind() {
		return mealkind;
	}

	public void setMealkind(MealKind mealkind) {
		this.mealkind = mealkind;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Meal [idMeal=" + idMeal + ", name=" + name + ", datecreated="
				+ datecreated + ", picture=" + picture +  ", intro=" + intro
				+ ", price=" + price + "]";
	}
	
	
	
	
	
	
}
