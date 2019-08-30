package br.com.andersonpiotto.teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ValidaJSONNEW {

	public static void main(String[] args) throws IOException {
		
		String JSONResponse = "";
		
			// URL url = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/cliente");
			URL url = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/clienteArcelor");
			//URL url = new URL("http://localhost:7001/comum/rest/webServiceTest/v1/cliente");
			//URL url = new URL("http://localhost:7001/comum/rest/webServiceTest/v1/clienteArcelor");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			//conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("KEY", "myKey");
			conn.setRequestProperty("VALUE", "myValue");
			conn.setRequestProperty("TOKEN", "ece40d50-b22b-4b33-a728-343be730d85e");

			if (conn.getResponseCode() == 401) {
				System.out.println("N�o autorizado");

			}else if (conn.getResponseCode() == 200){

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
				String output;
				StringBuilder builder = new StringBuilder();
				
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					builder.append(output);
				}
				
				JSONResponse = builder.toString();
				
				br.close();
			}

			conn.disconnect();
		
		/*
		String[] layout = {"CDCONTRATO", "CDPLANO", "NOME", "EMAIL", "IDADE", "VIVO", "FORTUNA"};
		String[] tiposCampo = {"NUMERO","NUMERO","STRING", "STRING", "NUMERO","BOOLEANO","DECIMAL"};
		boolean[] obrigatoriedade = {true,true,true,true, true, true,true};
		String JSON = "{\"cdContrato\":11603,\""
				+ "cdPlano\":5388,\""
				+ "nome\":\"Anderson Piotto 2\",\""
				+ "idade\":44,\""
				+ "email\":\"piotto2k10@gmail.com\",\""
				+ "vivo\":true,\""
				+ "fortuna\":30}";*/ 
		
		String[] layout = {"BENEFICIARIOS", "STATUS", "OBSERVACAO", "CDPLANO", "MATRICULA", "CARTEIRA", "NOME","CPF","TIPO","GRAUPARENTESCO"
				, "DATANASCIMENTO","SEXO","LIMITE","OPERACAO"};
		String[] tiposCampo = {"STRING","BOOLEANO","STRING","NUMERO", "STRING", "STRING","STRING","STRING","NUMERO","NUMERO","DATA"
				,"STRING","NUMERO","NUMERO"};
		boolean[] obrigatoriedade = {true,true,true, true, true,true,true, true,true,true, true, true, true, true};
		
		String JSON = "{\"beneficiarios\":[{\""
		+ "cdPlano\":15,\""
		+ "matricula\":\"010130596\",\""
		+ "carteira\":\"00101305960101\",\""
		+ "nome\":\"Anderson Piotto Leite1\",\""
		+ "cpf\":\"35461848826\",\""
		+ "tipo\":1,\""
		+ "grauParentesco\":1,\""
		+ "dataNascimento\":\"Aug 28, 2019 10:45:53 AM\",\""
		+ "sexo\":\"M\",\""
		+ "limite\":100,\""
		+ "operacao\":1},{\""
		+ "cdPlano\":15,\""
		+ "matricula\":\"010130596\",\""
		+ "carteira\":\"00101305960101\",\""
		+ "nome\":\"Anderson Piotto Leite1\",\""
		+ "cpf\":\"35461848826\",\""
		+ "tipo\":1,\""
		+ "grauParentesco\":1,\""
		+ "dataNascimento\":\"Aug 28, 2019 10:45:53 AM\",\""
		+ "sexo\":\"M\",\""
		+ "limite\":100,\""
		+ "operacao\":1}],\""
		+ "status\":true,\""
		+ "observacao\":\"msg de observação\"}";
		
		
		
		// aplicar a partir daqui
		
		String[] objetosJson = getObjetosJSON(JSON);
		
		boolean validaSeObjetosDoLayoutEstaoNoJSON = validaSeObjetosDoLayoutEstaoNoJSON(layout, objetosJson);
		
		boolean validaSeExisteObjetosAMaisNoJSONQueNaoExisteNoLayout = validaSeExisteObjetosAMaisNoJSONQueNaoExisteNoLayout(layout, objetosJson);
		
		boolean validaSeObjetosObrigatoriosEstaoPreenchidos = validaSeObjetosObrigatoriosEstaoPreenchidos(layout, obrigatoriedade, objetosJson);
		
		boolean validaSeTiposDeValoresEstaoDeAcordoComLayout = validaSeTiposDeValoresEstaoDeAcordoComLayout(layout, tiposCampo, objetosJson, obrigatoriedade);
		
		if(validaSeObjetosDoLayoutEstaoNoJSON && 
				validaSeExisteObjetosAMaisNoJSONQueNaoExisteNoLayout && 
				validaSeObjetosObrigatoriosEstaoPreenchidos && 
				validaSeTiposDeValoresEstaoDeAcordoComLayout) {
			
			System.out.println("PASSOU NO TESTE");
		}
	}
	
	private static boolean validaSeObjetosDoLayoutEstaoNoJSON(String[] layout, String[] objetosJSON) {
		
		boolean jsonNoPadraoCorreto = false;
		
		
		for (int i = 0; i < layout.length; i++) {
			
			jsonNoPadraoCorreto = false;
			
			String objetoLayout = layout[i].toLowerCase();
			
			for (String objeto : objetosJSON) {
				
				if(containsIgnoreCase(objeto, objetoLayout)) {
					
					jsonNoPadraoCorreto = true;
				}
			}
			
			if(!jsonNoPadraoCorreto) {
				throw new IllegalArgumentException("*** JSON Fora do Padr�o! Objeto do Layout n�o encontrado no JSON: " + objetoLayout);
			}
		}

		return jsonNoPadraoCorreto;
	}
	
	private static boolean validaSeExisteObjetosAMaisNoJSONQueNaoExisteNoLayout(String[] layout, String[] objetosJSON) {
		boolean jsonNoPadraoCorreto = false;
		
		for (String objeto : objetosJSON) {
			
			jsonNoPadraoCorreto = false;
			
			for (int i = 0; i < layout.length; i++) {
				
				String chaveLayout = layout[i].toLowerCase();
				
				if(containsIgnoreCase(objeto, chaveLayout)) {
					
					jsonNoPadraoCorreto = true;
					break;
				}
			}
			
			if(!jsonNoPadraoCorreto) {
				
				throw new IllegalArgumentException("*** JSON Fora do Padr�o! Existem objetos no JSON que n�o existem no Layout. Objeto: " + objeto);
			}	
			
		}
		
		return jsonNoPadraoCorreto;
	}
	
	private static boolean validaSeObjetosObrigatoriosEstaoPreenchidos(String[] layout, boolean[] obrigatoriedade, String[] objetosJSON) {
		boolean jsonNoPadraoCorreto = true;
		
		String objetoJSON = "";
		
		String objetoLayout = "";
		
		for (int i = 0; i < layout.length; i++) {
			
			objetoLayout = layout[i];
			
			boolean obrigatorio = obrigatoriedade[i];	
			
			for (String objeto : objetosJSON) {
				
				objetoJSON = objeto;
				
				if(containsIgnoreCase(objetoJSON, objetoLayout)) {
					
					if(obrigatorio) {
					
						String valor = objetoJSON.replace(layout[i].toLowerCase()+":", "");
						
						// verifica valores inv�lidos
						if(valor.equals("") || valor.equalsIgnoreCase("null") || valor.equalsIgnoreCase("0")) {
							jsonNoPadraoCorreto = false;
							
							throw new IllegalArgumentException("*** JSON Fora do Padr�o! Conforme definido no Layout, o valor do Objeto � obrigat�rio. Objeto: " + objetoJSON);
						}
					}
				}
				
			}
		}
		
		return jsonNoPadraoCorreto;
	}
	
	private static boolean validaSeTiposDeValoresEstaoDeAcordoComLayout(String[] layout, String[] tiposCampo, String[] objetosJSON, boolean[] obrigatoriedade) {
		boolean jsonNoPadraoCorreto = true;
		
		String objetoJson = "";
		
		String objetoLayout = "";
		
		DateFormat formatData = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
			
		for (int i = 0; i < layout.length; i++) {
			
			objetoLayout = layout[i];
			
			boolean obrigatorio = obrigatoriedade[i];	
			
			for (String objeto : objetosJSON) {
				
				objetoJson = objeto;
				
				if(containsIgnoreCase(objetoJson, objetoLayout)) {
					
					if(obrigatorio) {
						
						System.out.println("objetoJson:" + objetoJson);
						
						String chave= objetoJson.trim().split(":")[0];
						
						System.out.println("chave:" + chave);
						
						String valor = objetoJson.replace(chave+":", "");
						
						System.out.println("valor:" + valor);
						
						try {
								
							if(tiposCampo[i].equals("NUMERO")  && !valor.equalsIgnoreCase("null")) {
								
								Long.parseLong(valor.trim());
							}
							
							if(tiposCampo[i].equals("BOOLEANO")  && !valor.equalsIgnoreCase("null")) {
								
								if((!valor.trim().equalsIgnoreCase("true") && (!valor.trim().equalsIgnoreCase("false")))) {
									throw new IllegalArgumentException("*** JSON Fora do Padr�o! Valor do Objeto do JSON esta divergente com o especificado no Layout. Objeto: " + objetoJson + " - Valor: " + valor);
								}
							}
							
							if(tiposCampo[i].equals("DECIMAL")  && !valor.equalsIgnoreCase("null")) {
								
								Double.parseDouble(valor.trim());
							}
							
							if(tiposCampo[i].equals("DATA")) {
								
								formatData.parse(valor.trim());
							}
							
						}catch (Exception e) {
							jsonNoPadraoCorreto = false;
							
							throw new IllegalArgumentException("*** JSON Fora do Padr�o! Valor do Objeto do JSON esta divergente com o especificado no Layout. Objeto: " + objetoJson + " - Valor: " + valor);
						}
					}
					}
					
				}
			}
		
		return jsonNoPadraoCorreto;
	}

	private static String[] getObjetosJSON(String JSON) {
		
		// caso venha formatado em varias linhas, remove os espa�os
		JSON = JSON.replace("  ", "");
		
		String JSONPreparado = JSON.replace(":[{",",").replaceAll("\"", "").replace("{", "").replace("}", "").replace("[", "").replace("]", "").replace(":[{",",").replace("[{", "").replace("}]", "");
		
		// tratamento em caso de data do tipo: DATE Aug 28, 2019 10:45:53 AM
		JSONPreparado = JSONPreparado.replace(", ", "##");
		
		String[] JSONSeparadoEmChaveValor = JSONPreparado.split(",");
		
		// tratamento em caso de data do tipo: DATE Aug 28, 2019 10:45:53 AM
		for (int i = 0; i < JSONSeparadoEmChaveValor.length; i++) {
			
			if(JSONSeparadoEmChaveValor[i].contains("##")) {
				
				String chaveValorDataFormatada = JSONSeparadoEmChaveValor[i].replace("##", ", ");
				
				JSONSeparadoEmChaveValor[i] = chaveValorDataFormatada;
			}
		}
		
		return JSONSeparadoEmChaveValor;
	}
	
	public static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }


}
