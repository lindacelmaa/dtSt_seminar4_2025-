package service;

import datastr.MyBST;

public class MainService {
	public static void main(String[] args) {
		MyBST<Integer> bstForInteger = new MyBST<Integer>();
		
		try {
			System.out.println("--------- Pievienosana --------- ");
			
			bstForInteger.add(98);
			bstForInteger.add(54);
			bstForInteger.add(9);
			bstForInteger.add(5);
			bstForInteger.add(48);
			bstForInteger.add(4);
			bstForInteger.print();
			
			System.out.println("--------- Parbaude --------- ");
			System.out.println("9? -> " + bstForInteger.searchElement(9));
			System.out.println("99? -> " + bstForInteger.searchElement(99));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
