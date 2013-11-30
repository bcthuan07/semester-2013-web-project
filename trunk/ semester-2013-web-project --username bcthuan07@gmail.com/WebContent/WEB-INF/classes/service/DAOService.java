/**
 * 
 */
package service;

import java.util.List;

import dao.GeneralDAO;

/**
 * @author Thuan
 * 
 */
public class DAOService<E, T> {

	protected GeneralDAO<E, T> generalDAO;

	/**
	 * @param generalDAO
	 */
	public DAOService(GeneralDAO<E, T> generalDAO) {
		super();
		this.generalDAO = generalDAO;
	}

	public boolean addObject(E object) {
		return this.generalDAO.addObject(object);
	}
	
	public boolean removeObject(T id){
		return this.generalDAO.removeObject(id);
	}
	
	public List<E> listObject(){
		return this.generalDAO.listObject();
	}
	
	public E getObjectById(T id){
		return this.generalDAO.getObject(id);
	}
}
