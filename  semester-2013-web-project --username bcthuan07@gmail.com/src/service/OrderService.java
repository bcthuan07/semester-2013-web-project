/**
 * 
 */
package service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Address;
import model.OrderItem;
import model.OrderStatus;
import model.Product;
import model.User;
import model.UserOrder;
import dao.OrderItemDAO;
import dao.OrderStatusDAO;
import dao.UserOrderDAO;

/**
 * @author Thuan
 * 
 */
public class OrderService {

	public OrderService() {

	}

	public boolean order(List<Product> listProduct, User user, Date date) {
		try {
//			DAOService<User, Integer> userdao = new DAOService<>(new UserDAO());
			DAOService<UserOrder, Integer> userorderdao = new DAOService<>(
					new UserOrderDAO());
			DAOService<OrderItem, Integer> orderitemdao = new DAOService<>(
					new OrderItemDAO());
			DAOService<OrderStatus, Integer> orderstatusdao = new DAOService<>(new OrderStatusDAO());
			OrderStatus orderStatus = orderstatusdao.getObjectById(new Integer(1));
			Set<Product> set = new HashSet<>(listProduct);
			Set<OrderItem> setProducts = new HashSet<>();
			UserOrder userOrder = new UserOrder();
			userOrder.setOrderDate(date);
			userOrder.setUser(user);
			userOrder.setOrderStatus(orderStatus);
			userorderdao.addObject(userOrder);
			System.out.println(set);
			for (Product p : set) {
				int count = 0;
				for (Product pd : listProduct) {
					if (pd.equals(p)) {
						count++;
					}
				}
				OrderItem item = new OrderItem(userOrder, p, count);
				orderitemdao.addObject(item);
				setProducts.add(item);
			}
//			userOrder.setOrderItems(setProducts);
//			userorderdao.updateObject(userOrder);
//			userdao.updateObject(user);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public boolean order(List<Product> listProduct, User user, Address address,
			Date date) {
		try {
//			DAOService<Address, Integer> addressdao = new DAOService<>(
//					new AddressDAO());
//			DAOService<UserAddressHistory, UserAddressHistoryId> useraddresshistorydao = new DAOService<>(
//					new UserAddressHistoryDAO());
//			DAOService<User, Integer> userdao = new DAOService<>(new UserDAO());

//			addressdao.addObject(address);
//			userdao.addObject(user);
//			UserAddressHistory addressHistory = new UserAddressHistory();
//			UserAddressHistoryId historyId = new UserAddressHistoryId(user.getUserId(),address.getAddressId(),date);
//			addressHistory.setId(historyId);
//			addressHistory.setUser(user);
//			addressHistory.setAddress(address);
//			useraddresshistorydao.addObject(addressHistory);
			RegisterService rs = new RegisterService();
			rs.register(user, address);
			return order(listProduct, user, date);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
