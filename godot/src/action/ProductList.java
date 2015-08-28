package action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import dao.ProductDao;

public class ProductList extends ActionSupport {
	
	List<String> list = new ArrayList<String>();
	public String execute(){
		ProductDao dao = new ProductDao();
		list =dao.getProduct();
		return SUCCESS;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
