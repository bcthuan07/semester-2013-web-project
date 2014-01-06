/**
 * 
 */
package service;

import java.util.Date;
import java.util.List;

import util.MailUtil;
import model.Address;
import model.Role;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import model.UserAddressHistory;
import model.UserAddressHistoryId;
import dao.AddressDAO;
import dao.RoleMemberDAO;
import dao.UserAddressHistoryDAO;
import dao.UserDAO;
import exception.UsernameException;

/**
 * @author Thuan
 * 
 */
public class RegisterService {

	public boolean register(User user, Address address, String emailManageUser,
			String emailAdmin) throws UsernameException {
		try {
			DAOService<User, Integer> userService = new DAOService<>(
					new UserDAO());
			DAOService<Address, Integer> addressService = new DAOService<>(
					new AddressDAO());
			DAOService<UserAddressHistory, UserAddressHistoryId> userAddressService = new DAOService<>(
					new UserAddressHistoryDAO());
			DAOService<RoleMember, RoleMemberId> roleService = new DAOService<>(
					new RoleMemberDAO());
			List<User> listUser = userService.listObject();
			for (User u : listUser) {
				if (u.getUsername() != null)
					if (u.getUsername().equals(user.getUsername())
							|| u.getEmail().equals(user.getEmail())) {
						throw new UsernameException("Username này đã tồn tại!");

					}
			}
			boolean esxit = false;
			List<Address> listAddresses = addressService.listObject();
			for (Address add : listAddresses) {
				if (add.equals(address)) {
					address = add;
					esxit = true;
				}
			}
			if (!esxit) {
				addressService.addObject(address);
			}
			Date date = new Date();
			Role role = new Role();
			role.setRoleId(new Integer(3));
			userService.addObject(user);
			RoleMemberId roleMemberId = new RoleMemberId(user.getUserId(),
					role.getRoleId());
			RoleMember roleMember = new RoleMember();
			roleMember.setId(roleMemberId);
			roleService.addObject(roleMember);
			UserAddressHistoryId addressHistoryId = new UserAddressHistoryId(
					user.getUserId(), address.getAddressId(), date);
			UserAddressHistory addressHistory = new UserAddressHistory();
			addressHistory.setId(addressHistoryId);

			userAddressService.addObject(addressHistory);

			// gui mail thong bao cho khach hang
			String pass = "dfghjhFGHJKL";
			String msgBody = "Username: " + user.getUsername()
					+ "\n\rHọ và tên: " + user.getFullname() + "\n\rĐịa chỉ: "
					+ address.getBuildingNumber() + ", " + address.getCity()
					+ ", \n\r" + "Số ĐT: " + address.getPhonenumber();
			MailUtil.send(emailManageUser, "Quản lý tài khoản", pass,
					user.getEmail(), user.getFullname(),
					"Thông tin đăng ký tài khoản", msgBody);

			MailUtil.send(emailManageUser, "Quản lý tài khoản", pass,
					emailAdmin, "Admin", "Đăng ký tài khoản", msgBody);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
