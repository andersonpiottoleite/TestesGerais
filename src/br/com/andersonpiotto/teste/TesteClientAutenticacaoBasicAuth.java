package br.com.andersonpiotto.teste;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.DatatypeConverter;

public class TesteClientAutenticacaoBasicAuth {

	public static void main(String[] args) throws Exception {

		String name = "meuUsuario!";
        String password = "minhaSenha!";
        String authString = name + ":" + password;
        
        //String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
        
        //String authStringEnc = DatatypeConverter.printBase64Binary
        //(authString.getBytes(StandardCharsets.UTF_8));
        String authStringEnc = DatatypeConverter.printBase64Binary(authString.getBytes("UTF-8"));
        		
        System.out.println("Base64 encoded auth string: " + authStringEnc);
        
       URL url2 = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/cliente");
        //URL url2 = new URL("http://localhost:7001/comum/rest/webServiceTest/v1/cliente");
		HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
		conn2.setRequestMethod("GET");
		//conn2.setRequestProperty("Accept", "application/json");
		conn2.setRequestProperty("Accept", "application/xml");
		String basicAuth = "Basic " +authStringEnc;
		conn2.setRequestProperty ("Authorization", basicAuth);
		
		

		if (conn2.getResponseCode() == 401) {
			System.out.println("Não autorizado");

		}else if (conn2.getResponseCode() == 200){

			BufferedReader br = new BufferedReader(new InputStreamReader((conn2.getInputStream())));
		
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			
			br.close();
		}
		
		conn2.disconnect();
		
		
		/* POST
		String name = "meuUsuario!";
        String password = "minhaSenha!";
        String authString = name + ":" + password;
        String authStringEnc = DatatypeConverter.printBase64Binary(authString.getBytes("UTF-8"));
        
        URL url2 = new URL("http://localhost:8080/faces-motors/rest/cliente/cliente3");
		HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
		conn2.setUseCaches(false);
		conn2.setDoOutput(true);
		conn2.setRequestMethod("POST");
		conn2.setRequestProperty("Accept", "application/json");
		
		String basicAuth = "Basic " +authStringEnc;
		
		conn2.setRequestProperty ("Authorization", basicAuth);
		conn2.setRequestProperty( "Content-Type", "application/json");
		conn2.setRequestProperty( "charset", "utf-8");
		
		String conteudoCorpo  = "para o corpo";
		byte[] body       = conteudoCorpo.getBytes("utf-8");
		
		int bodyLength = body.length;
		conn2.setRequestProperty("Content-Length", Integer.toString(bodyLength));
		
		DataOutputStream wr = new DataOutputStream (
		conn2.getOutputStream ());
	    wr.writeBytes (conteudoCorpo);
	    wr.flush ();
	    wr.close ();

		if (conn2.getResponseCode() == 401) {
			System.out.println("Não autorizado");

		}else if (conn2.getResponseCode() == 200){

			BufferedReader br = new BufferedReader(new InputStreamReader((conn2.getInputStream())));
		
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		}
		
		conn2.disconnect();*/
	}

}
