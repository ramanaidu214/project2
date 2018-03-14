package com.sanju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sanju.bean.GroupCustomerBean;

public class GroupCustomerDaoImpl {

	public List<GroupCustomerBean> getCustomerData(int customerId) {
		GroupCustomerBean groupCustomerBean = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<GroupCustomerBean> list=null;
		String query = "select group_id,customer_id,group_name,customer_name,credit_amount from claint111.group_customer,claint111.customer_info,claint111.group_info where  customer_id=? and customer_id=customer_id_info and group_id=group_id_info";
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:project 1", "postgres", "root");
			ps = con.prepareStatement(query);
			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			list =new ArrayList<>();
			while (rs.next()) {
				groupCustomerBean = new GroupCustomerBean();
				groupCustomerBean.setGroupId(rs.getInt(1));
				groupCustomerBean.setCustomerId(rs.getInt(2));
				groupCustomerBean.setGroupName(rs.getString(3));
				groupCustomerBean.setCustomerName(rs.getString(4));
				groupCustomerBean.setCreditAmount(rs.getDouble(5));
				System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getDouble(5));
				list.add(groupCustomerBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception >>>>>>>>>>in DAO <<<<<<<<<<<<<<");
		} finally {
			ps = null;
			con = null;
			rs = null;
		}
		return list;

	}

}
