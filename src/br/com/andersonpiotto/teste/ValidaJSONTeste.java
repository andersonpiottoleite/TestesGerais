package br.com.andersonpiotto.teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaJSONTeste {
	
	private static StringBuilder JSONResponse = null;
	private static StringBuilder JSONResponseParaValidacao = null;
	private static String JSON = "";

	public static void main(String[] args) throws IOException {
	
			// URL url = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/cliente");
			URL url = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/beneficiarios");
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
				System.out.println("Não autorizado");

			}else if (conn.getResponseCode() == 200){

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
				String output;
				JSONResponse = new StringBuilder();
				
				while ((output = br.readLine()) != null) {
					JSONResponse.append(output);
				}
				
				JSONResponseParaValidacao = new StringBuilder(JSONResponse.toString());
				
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
		
		JSON  = "{\"beneficiarios\":[{\""
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
		+ "observacao\":\"msg de observaÃ§Ã£o\"}";
		
		// aplicar a partir daqui
		
		String[] objetosJson = getObjetosJSON(JSONResponseParaValidacao);
		
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
		
		try {
			salvaResponseJSONParaIntegracaoDetalhe();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void salvaResponseJSONParaIntegracaoDetalhe() throws Exception {
		
		List<IntegracaoDetalheWebServiceRD> listIntegracaoDetalheWebServiceRD = new ArrayList<IntegracaoDetalheWebServiceRD>();
		
		Long countNumeroDetalhe = 1L;
		
		for (String beneficiario : formataConteudoResponseJSON()) {
			
				if(isBeneficiarioValido(beneficiario)) {
					
					IntegracaoDetalheWebServiceRD integracaoDetalheWebServiceRD = new IntegracaoDetalheWebServiceRD(countNumeroDetalhe+ 2, countNumeroDetalhe);
					
					String[] propriedades = beneficiario.split(",");
					
					for (String propriedade : propriedades) {
						
						String chave = propriedade.split(":")[0];
						String valor = propriedade.replace(chave+":", "");
						
						if(valor != null && !valor.equals("")) {
							
							setValoresNaIntegracaoDetalhe(integracaoDetalheWebServiceRD, chave, valor);	
						}
					}
					
					listIntegracaoDetalheWebServiceRD.add(integracaoDetalheWebServiceRD);
					
					countNumeroDetalhe ++;
				}
		}
	}

	private static String[] formataConteudoResponseJSON() {
		replaceAll(JSONResponse, "  ","");
		replaceAll(JSONResponse, "\\}\\,\\{","#");
		replaceAll(JSONResponse, "\\[\\{", "#");
		replaceAll(JSONResponse, "\\}\\]", "#");
		replaceAll(JSONResponse, "\\{", "");
		replaceAll(JSONResponse, "\"", "");
		replaceAll(JSONResponse, "\\: ", ":");
		
		String[] beneficiarios = JSONResponse.toString().split("#");
		
		return beneficiarios;
	}

	private static boolean isBeneficiarioValido(String beneficiario) {
		return containsIgnoreCase(beneficiario, "nome") && containsIgnoreCase(beneficiario, "plano") && containsIgnoreCase(beneficiario, "cpf");
	}

	private static void setValoresNaIntegracaoDetalhe(IntegracaoDetalheWebServiceRD integracaoDetalheWebServiceRD, String fieldResponse, String valor) throws IllegalAccessException, ParseException {
		
		Object object = (Object) integracaoDetalheWebServiceRD;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		// API Reflection
		
		for (Field fieldClasse : object.getClass().getDeclaredFields()) {
			
			if(containsIgnoreCase(fieldClasse.getName(), fieldResponse)) {
				
				fieldClasse.setAccessible(true);
				
				System.out.println("fieldClasse.getName(): " + fieldClasse.getName());
				
				// tratamento espefícico para field operação
				if(containsIgnoreCase(fieldClasse.getName(),"operacao")) {
					
					String descricaoOperacao= OperacaoIntegracaoDetalheWebServiceEnum.getDescricaoOperacaoPorValor(Integer.parseInt(valor));
					
					fieldClasse.set(integracaoDetalheWebServiceRD, descricaoOperacao);
					
					break;
				}
				
				//String typeName = fieldClasse.getGenericType().getTypeName();
				
				//String typeName = fieldClasse.getType().getTypeName();
				
				String typeName = fieldClasse.getType().getName();	
				
				if(typeName.contains("java.math.BigDecimal")) {
					
					fieldClasse.set(integracaoDetalheWebServiceRD, new BigDecimal(valor));
					
				}else if(typeName.contains("java.lang.String")) {
					
					fieldClasse.set(integracaoDetalheWebServiceRD, valor);
					
				}else if(typeName.contains("java.lang.Boolean")) {
					
					fieldClasse.set(integracaoDetalheWebServiceRD, Boolean.parseBoolean(valor));
					
				}else if(typeName.contains("java.util.Date")) {
					
					fieldClasse.set(integracaoDetalheWebServiceRD, dateFormat.parse(valor));
					
				}else if(typeName.contains("java.lang.Long")) {
					
					fieldClasse.set(integracaoDetalheWebServiceRD, Long.parseLong(valor));
				}
				
				break;
			}
		}
	}
	
	public static String addIndice(String str, String indice, int position) {
	    return indice + str.substring(position);
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
				throw new IllegalArgumentException("*** JSON Fora do Padrão! Objeto do Layout não encontrado no JSON: " + objetoLayout);
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
				
				throw new IllegalArgumentException("*** JSON Fora do Padrão! Existem objetos no JSON que não existem no Layout. Objeto: " + objeto);
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
						
						// verifica valores inválidos
						if(valor.equals("") || valor.equalsIgnoreCase("null") || valor.equalsIgnoreCase("0")) {
							jsonNoPadraoCorreto = false;
							
							throw new IllegalArgumentException("*** JSON Fora do Padrão! Conforme definido no Layout, o valor do Objeto é obrigatório. Objeto: " + objetoJSON);
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
		
		//DateFormat formatData = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		for (int i = 0; i < layout.length; i++) {
			
			objetoLayout = layout[i];
			
			boolean obrigatorio = obrigatoriedade[i];	
			
			for (String objeto : objetosJSON) {
				
				objetoJson = objeto;
				
				if(containsIgnoreCase(objetoJson, objetoLayout)) {
					
					if(obrigatorio) {
						
						String chave= objetoJson.trim().split(":")[0];
						
						String valor = objetoJson.replace(chave+":", "");
						
						try {
								
							if(tiposCampo[i].equals("NUMERO")  && !valor.equalsIgnoreCase("null")) {
								
								Long.parseLong(valor.trim());
							}
							
							if(tiposCampo[i].equals("BOOLEANO")  && !valor.equalsIgnoreCase("null")) {
								
								if((!valor.trim().equalsIgnoreCase("true") && (!valor.trim().equalsIgnoreCase("false")))) {
									throw new IllegalArgumentException("*** JSON Fora do Padrão! Valor do Objeto do JSON esta divergente com o especificado no Layout. Objeto: " + objetoJson + " - Valor: " + valor);
								}
							}
							
							if(tiposCampo[i].equals("DECIMAL")  && !valor.equalsIgnoreCase("null")) {
								
								Double.parseDouble(valor.trim());
							}
							
							if(tiposCampo[i].equals("DATA")) {
								
								dateFormat.parse(valor.trim());
							}
							
						}catch (Exception e) {
							jsonNoPadraoCorreto = false;
							
							throw new IllegalArgumentException("*** JSON Fora do Padrão! Valor do Objeto do JSON esta divergente com o especificado no Layout. Objeto: " + objetoJson + " - Valor: " + valor);
						}
					}
					}
					
				}
			}
		
		return jsonNoPadraoCorreto;
	}

	private static String[] getObjetosJSON(StringBuilder JSON) {
		
		// caso venha formatado em varias linhas, remove os espaços
		//JSON = JSON.replace("  ", "");
		
		//String JSONPreparado = JSON.replace(":[{",",").replace(": [{", ",").replaceAll("\"", "").replace("{", "").replace("}", "").replace("[", "").replace("]", "").replace(":[{",",").replace("[{", "").replace("}]", "");
		
		//String[] JSONSeparadoEmChaveValor = JSONPreparado.split(",");
		
		/*
		// tratamento em caso de data do tipo: DATE Aug 28, 2019 10:45:53 AM
		JSONPreparado = JSONPreparado.replace(", ", "##");
		
		// tratamento em caso de data do tipo: DATE Aug 28, 2019 10:45:53 AM
		for (int i = 0; i < JSONSeparadoEmChaveValor.length; i++) {
			
			if(JSONSeparadoEmChaveValor[i].contains("##")) {
				
				String chaveValorDataFormatada = JSONSeparadoEmChaveValor[i].replace("##", ", ");
				
				JSONSeparadoEmChaveValor[i] = chaveValorDataFormatada;
			}
		}*/
		
		replaceAll(JSON, "  ","");
		replaceAll(JSON, "\\:\\[\\{",",");
 		replaceAll(JSON, "\\: \\[\\{", ",");
 		replaceAll(JSON, "\\\"", "");
 		replaceAll(JSON, "\\{", "");
 		replaceAll(JSON, "\\}", "");
 		replaceAll(JSON, "\\[", "");
 		replaceAll(JSON, "\\]", "");
 		replaceAll(JSON, "\\:\\[\\{",",");
 		replaceAll(JSON, "\\[\\{", "");
 		replaceAll(JSON, "\\}\\]", "");
        
        String[] JSONSeparadoEmChaveValor = JSON.toString().split(",");
		
		return JSONSeparadoEmChaveValor;
	}
	
	public static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }
	
	private static void replaceAll(StringBuilder sb, String find, String replace){
        
        Pattern p = Pattern.compile(find);
        
        Matcher matcher = p.matcher(sb); 
        
        int startIndex = 0;
        
        while( matcher.find(startIndex) ){
            
            sb.replace(matcher.start(), matcher.end(), replace);
            
            startIndex = matcher.start() + replace.length();
        }
    }


}
