package br.com.andersonpiotto.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteData {
	
	public static void main(String[] args) throws ParseException {
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //SimpleDateFormat
		 * sdf = new SimpleDateFormat("yyyy/MM/dd"); String date =
		 * sdf.format("20/50/1980"); System.out.println(date);
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "31/11/a";
		Date date = sdf.parse(dateInString);
		System.out.println(date);
	}

}
