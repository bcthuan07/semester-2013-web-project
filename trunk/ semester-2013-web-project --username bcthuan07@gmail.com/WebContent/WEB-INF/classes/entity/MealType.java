package entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="mealtype")
public class MealType {

	@Id
	@Column(name="idmealtype",unique=true, nullable=false)
	private int idMealType;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="decription")
	private String decription;
	
	@Column(name = "datecreated")
	private Timestamp datecreated;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="mealtype",cascade=CascadeType.ALL)
	private List<Meal> lMeal;

	public int getIdMealType() {
		return idMealType;
	}

	public void setIdMealType(int idMealType) {
		this.idMealType = idMealType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Timestamp getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public List<Meal> getlMeal() {
		return lMeal;
	}

	public void setlMeal(List<Meal> lMeal) {
		this.lMeal = lMeal;
	}

	public MealType(int idMealType, String name, String decription,
			Timestamp datecreated, List<Meal> lMeal) {
		super();
		this.idMealType = idMealType;
		this.name = name;
		this.decription = decription;
		this.datecreated = datecreated;
		this.lMeal = lMeal;
	}
	
	public MealType(){}
}
