/**
 * @author Nalongsone Danddank
 */
package ReataurantAPP.database;

/**
 * @author Nalongsone Danddank
 *
 */

import java.util.*;

import ReataurantAPP.GUI.MenuItem;

public class OrderOld {
	 final public static int ORDER_CLOSED = 1;
	    final public static int ORDER_CANCELED = 2;
	    
	    private int orderID;
	    private int staffID;
	    private String staffName;
	    private String date;
	    private int state;  //0:arrive 1:closed 2:canceled
	    private double total;
	    private ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

	    /**
	     * Constructor for objects of class OrderOld
	     */
	    public OrderOld(int newStaffID, String newStaffName)
	    {
	        this.orderID =-1;
	        this.state = 0;
	        this.staffID = newStaffID;
	        this.staffName = newStaffName;
	        this.total = 0;
	    }
	    /**
	     *Getter
	     */
	    public int getOrderID()
	    {
	        return this.orderID;
	    }
	    public int getStaffID()
	    {
	        return this.staffID;
	    }
	    public String getStaffName()
	    {
	        return this.staffName;
	    }
	    public int getState()
	    {
	        return this.state;
	    }
	    public double getTotal()
	    {
	        return this.total;
	    }
	    public ArrayList<OrderDetail> getOrderDetail()
	    {
	        return this.orderDetailList;
	    }
	    
	     /**
	     * Setter
	     */
	    public void setOrderID(int newID)
	    {
	        this.orderID = newID;
	    }
	    
	    public void setState(int state)
	    {
	        this.state = state;
	    }
	    
	    public void addItem(MenuItem rNewMenuItem, byte quantity)
	    {
	        Iterator<OrderDetail> it = orderDetailList.iterator();
	        OrderDetail re;
	        
	        boolean found = false;
	        
	        while( it.hasNext() && !found)
	        {
	            re = it.next();
	            if( rNewMenuItem.getID() == re.getItemID())
	            {
	                found = true;
	                re.addQuantity(quantity);
	            }
	        }
	        
	        if(!found)
	        {
	            OrderDetail detail = new OrderDetail(rNewMenuItem, quantity);
	            orderDetailList.add(detail);
	            
	        }
	        
	        calculateTotal();
	    }
	    
	    public boolean deleteItem(int index)
	    {
	        try
	        {
	            orderDetailList.remove(index);
	            calculateTotal();
	            return true;
	        }
	        catch(Exception e)
	        {
	            //System.out.println(e.toString()  + ":" + e.getMessage());
	             return false;
	        }
	    }
	    
	    public void  calculateTotal()
	    {
	        total = 0;
	        OrderDetail re;
	         Iterator<OrderDetail> it = orderDetailList.iterator();
	         while (it.hasNext()) {
	            re = it.next();
	            total += re.getTotalPrice();
	        }
	    }
	}
