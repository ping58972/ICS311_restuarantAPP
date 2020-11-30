/**
 * 
 */
package ReataurantAPP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ReataurantAPP.database.dao.Order;
import ReataurantAPP.database.dao.ConnectionFactory;
import ReataurantAPP.database.dao.Item;
import ReataurantAPP.database.dao.ItemDao;
import ReataurantAPP.database.dao.OrderDao;
import ReataurantAPP.database.dao.OrderItem;
import ReataurantAPP.database.dao.OrderItemDao;
import ReataurantAPP.database.dao.TableQueryDao;
import ReataurantAPP.database.dao.Transaction;
import ReataurantAPP.database.dao.TransactionDao;
import ReataurantAPP.database.dao.User;
import ReataurantAPP.database.dao.UserDao;

/**
 * @author Nalongsone Danddank
 *
 */
public class Test_DB {

	/**
	 * 
	 */
	public Test_DB() {
//		try {
//			Connection con = ConnectionFactory.getConnection();
//			System.out.println("Connection Object Created: " + con + " -> Success!");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("select * from user;");
//			while (rs.next()) {
//				// list.add(rs.getString(2));
//				System.out.println(rs.getString(2));
//			}
//			st.close();
//			con.close();
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		 UserDao userDao = new UserDao();
//		Set<User> users = userDao.selectAll();
//		for(User user : users) {
//			System.out.println(user);
//		}
//		  User user = userDao.selectById(1007);
//		  user.setPhone(89562458);
//		  user.setSalary(0);
//		  userDao.update(user);
//		//User user = userDao.selectByEmail("jimmy.smith@email.usa");
//		//System.out.println(user);
//		Date date = null;
//
//		try {
//			date = new SimpleDateFormat("MM-dd-yyyy").parse("12-14-1990");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		user.setBdate(date);
//		user.setfName("Kum");
//		user.setlName("Lee");
//		user.setEmail("Kum.Lee@email.usa");
//		user.setPhone(892938994);
//		user.setPwd("123456");
//		user.setGender("gay");
//		user.setSalary(0);
//		System.out.println(user);
//		boolean t = userDao.insert(user);
//		System.out.println(t);
//		
		// userDao.deleteById(1015);
		
		// System.out.println(userDao.selectByQuery("select * from user where salary < 4500;"));
		//ItemDao itemDao = new ItemDao();
//		Set<Item> items = itemDao.selectByQuery("select * from item where content = 'No Spicy';");
//		System.out.println(items);
//		Item item = itemDao.selectById(31);
//		item.setContent("Spicy");
//		item.setPrice(11.25);
//		item.setQuantity(70);
//		item.setUserId(1002);
//		itemDao.update(item);
//		System.out.println(item);
//		Set<Item> items = itemDao.selectAll();
////		System.out.println(items);
//		for(Item i : items) {
//			System.out.println(i);
//		}
		//itemDao.deleteById(31);
		
//		OrderDao orderDao = new OrderDao();
//		OrderOld order = orderDao.selectById(111);
//		System.out.println(order);
		// Set<OrderOld> orders = orderDao.selectAll();
		//Set<OrderOld> orders = orderDao.selectByQuery("select * from `order` where status = 'New';");
		//System.out.println(orders);
//		order.setStatus("Old");
//		order.setContent("Old");
//		order.setCreatedAt(new Date());
//		order.setUpdatedAt(new Date());
//		order.setTax(0.1);
//		if(orderDao.deleteById(111)) {
//			System.out.println("success!");
//		}
		//OrderItemDao oid = new OrderItemDao();
//		OrderItem oi = oid.selectById(16);
		//Set<OrderItem> ois = oid.selectByQuery("select * from order_item where orderId = 101;");
		// oi.setItemId(9);
//		oi.setQuantity(1);
//		oi.setUpdatedAt(new Date());
//		if (oid.update(oi)) {
//			System.out.println("success!");
//		}
		//oid.deleteById(16);
//		TransactionDao td = new TransactionDao();
//		Transaction t = td.selectById(12);
//		t.setCode("xxx-55");
//		t.setType("Credit");
//		t.setMode("Offline");
//		t.setUpdatedAt(new Date());
//		if(td.deleteById(12)) {
//			System.out.println("success!");
//		}
		//Set<Transaction> ts = td.selectByQuery("select * from transaction where userId=1008;");
		//System.out.println(ts);
		//TableQueryDao tableDao = new TableQueryDao();
//		List<LinkedHashMap> table = new ArrayList<LinkedHashMap>();
//		table = tableDao.getTableByQuery("select o.id, concat(u.fName,' ', u.lName) name, u.email, o.shippingFee, o.discount, o.grandTotal from `order` o join user u on o.userId = u.id;");
//		for(LinkedHashMap m : table) {
//			
//			System.out.println(m);
//		}
//		
//		if(tableDao.changeTableByQuery("delete from `order` where id=112;")) {
//			System.out.println("jajaj");
//		}
//		if(tableDao.changeTableByQuery("update `order` set status = 'cancled' where id=112;")) {
//			System.out.println("jajaj");
//		}
//		if(tableDao.changeTableByQuery("insert into `order`(userId, status, tax, shippingFee, createdAt ) "
//				+ "value(1008, 'New', 0.06, 7, '2020-11-08');")) {
//			System.out.println("jajaj");
//		}
	
		
		System.out.println(printTotextfile(22));
		
	}
	
	public String printTotextfile(int tranId) {
		// TODO Auto-generated method stub
		Writer          writer = null;
	       String          line;
	       String          fileName;
	       File            newFile;
	       
	       TransactionDao tranDao = new TransactionDao();
        	Transaction tran = tranDao.selectById(tranId);
        	UserDao userDao = new UserDao();
        	OrderDao orderDao = new OrderDao();
        	Order order = orderDao.selectById(tran.getOrderId());
        	User user = userDao.selectById(tran.getUserId());
        	line = String.format("Transaction ID:%5d\nCustomer Name: %-20s\nEmail:%-50s\nOrder "
        			+ "ID:%4d\nTotal Food Cost:$%5.2f\nTax:$%2.2f\nShipping Free:$%2.2f\nDiscount:$%2.2f\nTotal Payment:$%5.2f"
        			+ "\nType:%8s\nCode:%7s\nMode: %10s\nStatus:%15s\nDate:%15s\nCustomer Address:%30s",
        			
        			tranId, user.getfName()+" "+user.getlName(), user.getEmail(), order.getId(), order.getSubTotal(),order.getTax(),order.getShippingFee(),
        			order.getDiscount(),order.getGrandTotal(),tran.getType() ,tran.getCode(),tran.getMode(), tran.getStatus(),tran.getCreatedAt().toString(),user.getLine()+" "+user.getCity());
        	  

	       fileName = "./PaymentRecord/ID_"+tranId+"_payment.txt";
	       newFile = new File(fileName);
	       newFile.getParentFile().mkdirs();
	       try {
	    	  // newFile.createNewFile();
	    	   System.out.println(line);
			writer = new BufferedWriter(new FileWriter(newFile));
			
			writer.write(line);
	           
		} catch (Exception e) {
			
	           newFile.delete();
	           return "Fail";
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
		}
	       
		return fileName;
	}

}
