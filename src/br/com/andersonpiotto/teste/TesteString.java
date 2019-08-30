package br.com.andersonpiotto.teste;

import java.util.Date;

public class TesteString {
	
	public static void main(String[] args) {
		
		String s1 = "piotto";
		String s2 = "PIOTTO";
		
		if (s1.toLowerCase().contains(s2.toLowerCase())) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

}
