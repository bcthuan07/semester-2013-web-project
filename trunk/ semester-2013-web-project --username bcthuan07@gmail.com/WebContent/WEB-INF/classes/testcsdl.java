import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import service.DAOService;
import service.LoginService;
import service.RegisterService;
import sun.org.mozilla.javascript.internal.ast.ArrayLiteral;
import util.PasswordUtil;
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

	public static void main(String[] args) throws NoSuchAlgorithmException,
			InvalidKeySpecException {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(4);

		Set<Integer> set = new HashSet<>();
		set.addAll(list);

		System.out.println(list);
		System.out.println(set);

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int count = 0;
		for (int i : set) {
			count=0;
			for (int j : list) {
				if(j==i){
					count++;
				}
			}
			hashMap.put(i, count);
		}
		
		System.out.println(hashMap);
	}
}
