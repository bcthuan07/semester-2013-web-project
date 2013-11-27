/**
 * 
 */
package dao;

import java.util.List;

/**
 * 
 * @author Thuan
 *
 * @param <E> the type of elements in this list
 * @param <T> the primary key
 */
public interface GeneralDAO<E,T> {

	/**
	 * @return the list of elements in database 
	 */
	public List<E> listObject();
	
	/**
	 * 
	 * @param <E> declare what type of object you want
	 */
	public void addObject(E object);
	
	/**
	 * 
	 * @param object <E> declare what type of object you want
	 */
	public void updateObject(E object);
	
	/**
	 * 
	 * @param object <T> your primary key object
	 */
	public void removeObject(T object);
	
	public E getObject(T key);
}
