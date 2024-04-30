package in.co.testModel.pro4;

import in.co.pro4.bean.OrderBean;
import in.co.pro4.bean.UserBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.model.OrderModel;

public class TestOrder {
	
	 public static void main(String[] args) throws Exception {
		 //testAdd();
		 //testDelete();
		 testpk();
	}

	private static void testpk() throws Exception {
	
		
		 OrderModel model = new OrderModel();
		OrderBean bean =  model.findByPK(3);
		if (bean == null) {
			System.out.println("Test Find By PK fail");
		}
		System.out.println(bean.getId());
		System.out.println(bean.getShop());
		System.out.println(bean.getType());
		System.out.println(bean.getPrice());
		}

	private static void testDelete() throws Exception {
	OrderBean bean = new OrderBean();
	 bean.setId(1);
	  
	  OrderModel model = new OrderModel();
	   model.delete(bean);
	}

	private static void testAdd() throws Exception, DuplicateRecordException  {
		 
		 OrderBean bean = new OrderBean();
		// bean.setId(2);
		bean.setShop("Sharma");
		bean.setType("Online");
		bean.setPrice(20000);
		
		 OrderModel model = new OrderModel();
		  model.add(bean);
		  
	}

}
