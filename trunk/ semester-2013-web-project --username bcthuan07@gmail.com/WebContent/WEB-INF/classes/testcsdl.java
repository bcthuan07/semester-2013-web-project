import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.RegisterService;
import sun.org.mozilla.javascript.internal.ast.ArrayLiteral;
import model.Address;
import model.PaymentMethod;
import model.ProductType;
import model.User;
import dao.AddressDAO;
import dao.GeneralDAO;
import dao.PaymentMethodDAO;
import dao.ProductTypeDAO;
import dao.UserDAO;

public class testcsdl {

	public static void main(String[] args) {
		
		GeneralDAO<Address, Integer> dao = new AddressDAO();
//		Address pt = dao.getObject(new Integer(1));
//		System.out.println(pt);
//		List<Address> l = dao.listObject();
//		dao.removeObject(new Integer(4));
		System.out.println(dao.getObject(new Integer(1)));
//		for(Address a: l){
//			System.out.println(a);
//			System.out.println(a.getProducts());
//		}
	}
}
