import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import dao.AddressDAO;
import dao.GeneralDAO;
import dao.ProductTypeDAO;
import dao.UserDAO;
import entity.Address;
import entity.ProductType;
import entity.User;

public class testcsdl {

	public static void main(String[] args) {
		
		GeneralDAO<Address, Integer> dao = new AddressDAO();
		List<Address> list = dao.listObject();
		for(Address p: list){
			System.out.println(p);
		}
	}
}
