package in.co.testModel.pro4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.pro4.bean.PaymentBean;
import in.co.pro4.bean.UserBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.RecordNotFoundException;
import in.co.pro4.model.PaymentModel;

public class TestPayment {
	 
	 public static void main(String[] args) throws Exception , RecordNotFoundException{
		 testsearch();
	}

	private static void testsearch() throws Exception {
		PaymentBean bean = new PaymentBean();
		PaymentModel model = new PaymentModel();
		List list = new ArrayList();
		//bean.setBankName("BOI");
		 list = model.search(bean, 0, 0);
		if (list.size() > 0) {
			System.out.println("Test Serach fail");
		}
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (PaymentBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getBankName());
			System.out.println(bean.getAmount());
			System.out.println(bean.getCustomerName());
			System.out.println(bean.getPaymentType());
			System.out.println(bean.getTransactionId());
				}

	
	}
		
	}


