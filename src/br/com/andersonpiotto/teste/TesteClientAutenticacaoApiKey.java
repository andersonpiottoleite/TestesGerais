package br.com.andersonpiotto.teste;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TesteClientAutenticacaoApiKey {

	public static void main(String[] args) throws Exception {

       // URL url = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/cliente");
       //URL url = new URL("http://localhost:7001/comum/rest/webServiceTest/v1/cliente");
		//URL url = new URL("http://localhost:7001/comum/rest/webServiceTest/v1/clienteArcelor");
		URL url = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/clienteArcelor");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		//conn.setRequestProperty("Accept", "application/xml");
		conn.setRequestProperty("KEY", "myKey");
		conn.setRequestProperty("VALUE", "myValue");
		conn.setRequestProperty("TOKEN", "ece40d50-b22b-4b33-a728-343be730d85e");

		if (conn.getResponseCode() == 401) {
			System.out.println("Não autorizado");

		}else if (conn.getResponseCode() == 200){

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			
			br.close();
		}

		conn.disconnect();
	}

}
