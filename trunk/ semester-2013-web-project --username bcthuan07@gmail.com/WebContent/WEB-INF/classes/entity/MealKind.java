package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mealkind")
public class MealKind {

	@Id
	@Column(name="idmealkind",unique=true,nullable=false)
	private int idMealKind;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="mealkind", cascade=CascadeType.ALL)
	private List<Meal> lMeal;
	

	public MealKind(int idMealKind, String name) {
		super();
		this.idMealKind = idMealKind;
		this.name = name;
	}
	
	public MealKind(){}

	public int getIdMealKind() {
		return idMealKind;
	}

	public void setIdMealKind(int idMealKind) {
		this.idMealKind = idMealKind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MealKind [idMealKind=" + idMealKind + ", name=" + name
				+ ", lMeal=" + lMeal + "]";
	}

	public List<Meal> getlMeal() {
		return lMeal;
	}

	public void setlMeal(List<Meal> lMeal) {
		this.lMeal = lMeal;
	}
	
	
	
	
}
