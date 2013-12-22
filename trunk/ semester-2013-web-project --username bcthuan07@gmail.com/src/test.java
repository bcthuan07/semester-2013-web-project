import java.util.List;

import model.Role;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import service.DAOService;
import dao.RoleDAO;
import dao.RoleMemberDAO;
import dao.UserDAO;

/**
 * 
 */

/**
 * @author Thuan
 *
 */
public class test {

	public static void main(String[] args) {
		List<RoleMember> list = new DAOService<RoleMember, RoleMemberId>(new RoleMemberDAO()).listObject();
		System.out.println(list);
		User user = new DAOService<User,Integer>(new UserDAO()).getObjectById(new Integer(19));
		System.out.println(list.contains(new RoleMember( new RoleMemberId(user.getUserId(), 3))));
	}
}
