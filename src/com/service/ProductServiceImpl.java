package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService{
	List<Product> plist = new ArrayList<>();

	@Override
	public void addProduct(Product product) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "");
			String sql = "insert into product(name,catagory,price) values('"+product.getName()+"',"
					+ "'"+product.getCatagories()+"','"+product.getPrice()+"')";
			Statement stm =  con.createStatement();
			stm.execute(sql);
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteProduct(int index) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","");
			String sql = "delete from product where id = '"+index+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Product> getAllProdct() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","");
			String sql ="select * from product";
			Statement stm = con.createStatement();
			ResultSet rs =stm.executeQuery(sql);
			while(rs.next()) {
				System.out.println("===========================");
				System.out.println("ID = "+rs.getInt("id"));
				System.out.println("Name = "+rs.getString("name"));
				System.out.println("Catagory = "+rs.getString("catagory"));
				System.out.println("Price = "+rs.getInt("price"));
			}
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}

}
