package com.osvaldo.metaphorce;

public class Test {

	public static void main(String[] args) {
		
		
		String name = "My name is Osvaldo";
		
		String[] names=	name.split(" ");
		
		for(int i=0;i<names.length;i++) {
			String[] n= names[i].split("");
			for(int j=n.length-1;j>=0;j--) {
				System.out.println(n[j]);
				
			}
		}
		
		
	}

}
