package com.sanju.test;

import java.util.List;

import com.sanju.bean.GroupCustomerBean;
import com.sanju.dao.GroupCustomerDaoImpl;

public class Test1 {

	public static void main(String[] args) {
		GroupCustomerDaoImpl dao=new GroupCustomerDaoImpl();
		List<GroupCustomerBean>  list=dao.getCustomerData(1);
		System.out.println("groupid \tgroupname\tcustomerid\tcustomername\tcreditamount");
		for(GroupCustomerBean bean:list){
			System.out.println(bean.getCustomerName());
		}
	
	}

}
