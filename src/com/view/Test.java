package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class Test {
	public static void main(String[] args) {

		ProductService ps = new ProductServiceImpl();

		Scanner sc = new Scanner(System.in);
		char flag = 'y';

		do {
			Product p = new Product();
			System.out.println("Enter product id");
			p.setId(sc.nextInt());

			System.out.println("Enter product name");
			p.setName(sc.next());

			System.out.println("Enter product catagory");
			p.setCatagories(sc.next());

			System.out.println("Enter produt price");
			p.setPrice(sc.nextInt());

			ps.addProduct(p);

			System.out.println("if you want to add more product then enter [y/n]");
			flag = sc.next().charAt(0);

		} while (flag == 'y');

		List<Product> plist = ps.getAllProdct();
		for(Product pd : plist) {
			System.out.println("ID = "+pd.getId());
			System.out.println("Name = "+pd.getName());
			System.out.println("Price = "+pd.getPrice());
			System.out.println("Catagory = "+pd.getCatagories());
			System.out.println();
			System.out.println("==================================");
			
		}
//		System.out.println("Enter index for delete product");
//		ps.deleteProduct(sc.nextInt());
//		System.out.println("delete scusses");
//		
//		List<Product> plist1 = ps.getAllProdct();
//		for(Product pd : plist) {
//			System.out.println("ID = "+pd.getId());
//			System.out.println("Name = "+pd.getName());
//			System.out.println("Price = "+pd.getPrice());
//			System.out.println("Catagory = "+pd.getCatagories());
//			System.out.println();
//			System.out.println("==================================");
			
//		}
		
//	 ps.getAllProdct();
	}
	

}
