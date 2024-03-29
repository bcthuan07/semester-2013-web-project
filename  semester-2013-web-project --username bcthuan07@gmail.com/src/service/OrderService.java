/**
 * 
 */
package service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.MailUtil;
import model.Address;
import model.OrderItem;
import model.OrderStatus;
import model.Product;
import model.User;
import model.UserAddressHistory;
import model.UserAddressHistoryId;
import model.UserOrder;
import dao.AddressDAO;
import dao.OrderItemDAO;
import dao.OrderStatusDAO;
import dao.UserAddressHistoryDAO;
import dao.UserDAO;
import dao.UserOrderDAO;

/**
 * @author Thuan
 * 
 */
public class OrderService {

	public OrderService() {

	}

	public boolean order(List<Product> listProduct, User user, Date date,
			String emailManageUser, String email, Address address) {
		try {
			DAOService<User, Integer> userdao = new DAOService<>(new UserDAO());
			DAOService<UserOrder, Integer> userorderdao = new DAOService<>(
					new UserOrderDAO());
			DAOService<OrderItem, Integer> orderitemdao = new DAOService<>(
					new OrderItemDAO());
			DAOService<OrderStatus, Integer> orderstatusdao = new DAOService<>(
					new OrderStatusDAO());
			OrderStatus orderStatus = orderstatusdao.getObjectById(new Integer(
					1));
			DAOService<Address, Integer> addressdao = new DAOService<>(
					new AddressDAO());
			DAOService<UserAddressHistory, UserAddressHistoryId> useraddresshistorydao = new DAOService<>(
					new UserAddressHistoryDAO());

			boolean isExists = false;
			for (Address a : addressdao.listObject()) {
				if (a.equals(address)) {
					isExists = true;
					address = a;
				}
			}
			if (!isExists)
				addressdao.addObject(address);
			UserAddressHistory addressHistory = new UserAddressHistory();
			UserAddressHistoryId historyId = new UserAddressHistoryId(
					user.getUserId(), address.getAddressId(), date);
			addressHistory.setId(historyId);
			addressHistory.setUser(user);
			addressHistory.setAddress(address);
			useraddresshistorydao.addObject(addressHistory);

			//
			Double amount = new Double(0);
			for (Product p : listProduct) {
				amount += p.getPrice();
			}
			if (user.getScore() != null) {
				Integer score = user.getScore();
				// cong diem
				if (amount > 20) {
					score += 10;
				} else if (amount > 40) {
					score += 20;
				}

				user.setScore(score);
				userdao.updateObject(user);
				//
				if (user.getScore() > 50)
					amount -= amount * .05;
				else if (user.getScore() > 100)
					amount -= amount * .2;
				else if(user.getScore() > 150)
					amount -= amount * .5;

			}

			Set<Product> set = new HashSet<>(listProduct);
			UserOrder userOrder = new UserOrder();
			userOrder.setOrderDate(date);
			userOrder.setUser(user);
			userOrder.setOrderStatus(orderStatus);
			userOrder.setAmount(amount);
			userorderdao.addObject(userOrder);
			String list = "";
			System.out.println(set);
			for (Product p : set) {
				int count = 0;
				for (Product pd : listProduct) {
					if (pd.equals(p)) {
						count++;
					}
				}
				list += "<tr>" + "<td>" + p.getProductName() + "</td>"
						+ "<td>"+count+"</td>"
						+"<td>"+p.getPrice().toString()+"</td></tr>";
				OrderItem item = new OrderItem(userOrder, p, count);
				orderitemdao.addObject(item);
			}
			// gui mail
			String pass = "dfghjhFGHJKL";
			String msgBody = "<h1>Thông tin đặt hàng</h1><p>Các sản phẩm đã đặt</p><table><tr>"
					+ "<th>Tên sản phẩm</th>"
					+ "<th>Số lượng</th>"
					+ "<th>Đơn giá</th></tr>" + list+"</table>";

			MailUtil.send(emailManageUser, "Nhà hàng", pass, email,
					user.getFullname(), "Thông Tin Đặt Hàng", msgBody,"text/html");
			// userOrder.setOrderItems(setProducts);
			// userorderdao.updateObject(userOrder);
			// userdao.updateObject(user);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
