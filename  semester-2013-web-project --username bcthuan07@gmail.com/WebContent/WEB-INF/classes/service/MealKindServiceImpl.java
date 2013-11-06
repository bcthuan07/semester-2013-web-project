package service;

import java.util.List;

import dao.MealKindDAO;
import entity.MealKind;

public class MealKindServiceImpl implements MealKindService{

	private MealKindDAO mealkindDAO;

	public MealKindServiceImpl(MealKindDAO mealkindDAO) {
		super();
		this.mealkindDAO = mealkindDAO;
	}

	@Override
	public void addMealKind(MealKind mealkind) {
		// TODO Auto-generated method stub
		mealkindDAO.addMealKind(mealkind);
	}

	@Override
	public List<MealKind> listMealKind() {
		// TODO Auto-generated method stub
		return mealkindDAO.listMealKind();
	}

	@Override
	public void removeMealKind(Integer id) {
		// TODO Auto-generated method stub
		mealkindDAO.removeMealKind(id);
	}

	@Override
	public void updateMealKind(MealKind mealkind) {
		// TODO Auto-generated method stub
		mealkindDAO.updateMealKind(mealkind);
	}

	
}
