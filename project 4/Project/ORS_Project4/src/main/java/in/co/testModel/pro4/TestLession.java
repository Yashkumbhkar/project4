package in.co.testModel.pro4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.pro4.bean.LessionBean;
import in.co.pro4.bean.PaymentBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.model.LessionModel;
import in.co.pro4.model.PaymentModel;

public class TestLession {

	 
	 public static void main(String[] args) throws Exception {
		
		  testSerch();
	}

	private static void testSerch() throws ApplicationException, Exception {
		LessionBean bean = new LessionBean();
		LessionModel model = new LessionModel();
		List list = new ArrayList();
		//bean.setBankName("BOI");
		 list = model.search(bean, 0, 0);
		if (list.size() > 0) {
			System.out.println("Test Serach fail");
		}
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (LessionBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
						}

		
	}
}
