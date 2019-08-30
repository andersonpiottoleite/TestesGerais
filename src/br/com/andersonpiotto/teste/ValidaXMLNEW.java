package br.com.andersonpiotto.teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

public class ValidaXMLNEW {

	public static void main(String[] args) throws IOException {
		
			String XMLResponse = "";
		
			// URL url = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/cliente");
			URL url = new URL("http://localhost:8080/faces-motors/rest/webServiceTest/v1/clienteArcelor");
		    //URL url = new URL("http://localhost:7001/comum/rest/webServiceTest/v1/cliente");
			//URL url = new URL("http://localhost:7001/comum/rest/webServiceTest/v1/clienteArcelor");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			//conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("KEY", "myKey");
			conn.setRequestProperty("VALUE", "myValue");
			conn.setRequestProperty("TOKEN", "ece40d50-b22b-4b33-a728-343be730d85e");

			if (conn.getResponseCode() == 401) {
				System.out.println("Não autorizado");

			}else if (conn.getResponseCode() == 200){

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
				String output;
				StringBuilder builder = new StringBuilder();
				
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					builder.append(output);
				}
				
				XMLResponse = builder.toString();
				
				br.close();
			}
			
			System.out.println(XMLResponse);

			conn.disconnect();
			
		
		/*String[] layout = {"CLIENTE","CDCONTRATO", "CDPLANO", "NOME", "EMAIL", "IDADE", "VIVO", "FORTUNA"};
		String[] tiposCampo = {"STRING","NUMERO","NUMERO","STRING", "STRING", "NUMERO","BOOLEANO","DECIMAL"};
		boolean[] obrigatoriedade = {true,true,true,true, true, true,false,true};
				
		String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<cliente>"
				+ "<cdContrato>4</cdContrato>"
				+ "<cdPlano>2</cdPlano>"
				+ "<fortuna>50.0</fortuna>"
				+ "<email>piotto2k10@gmail.com</email>"
				+ "<idade>34</idade>"
				+ "<nome>Anderson Piotto 2</nome>"
				+ "<vivo>true</vivo>"
				+ "</cliente>";*/
		
		
		
		
		String[] layout = {"CLIENTEARCELOR","BENEFICIARIOS", "STATUS", "OBSERVACAO", "CDPLANO", "MATRICULA", "CARTEIRA", "NOME","CPF","TIPO","GRAUPARENTESCO"
				, "DATANASCIMENTO","SEXO","LIMITE","OPERACAO"};
		String[] tiposCampo = {"STRING","STRING","BOOLEANO","STRING","NUMERO", "STRING", "STRING","STRING","STRING","NUMERO","NUMERO","DATA"
				,"STRING","NUMERO","NUMERO"};
		boolean[] obrigatoriedade = {true,true,true,true, true, true,true,true, true,true,true, true, true, true, true};
		
		String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<retornoArcelor>"
				+ "<beneficiarios>"
				+ "<carteira>00101305960101</carteira>"
				+ "<cdPlano>15</cdPlano>"
				+ "<cpf>35461848826</cpf>"
				+ "<dataNascimento>2019-08-28T09:05:50.467-03:00</dataNascimento>"
				+ "<grauParentesco>1</grauParentesco>"
				+ "<limite>100</limite>"
				+ "<matricula>010130596</matricula>"
				+ "<nome>Anderson Piotto Leite1</nome>"
				+ "<operacao>1</operacao>"
				+ "<sexo>M</sexo>"
				+ "<tipo>1</tipo>"
				+ "</beneficiarios>"
				+ "<beneficiarios>"
				+ "<carteira>00101305960101</carteira>"
				+ "<cdPlano>15</cdPlano>"
				+ "<cpf>35461848826</cpf>"
				+ "<dataNascimento>2019-08-28T09:05:50.467-03:00</dataNascimento>"
				+ "<grauParentesco>1</grauParentesco>"
				+ "<limite>100</limite>"
				+ "<matricula>010130596</matricula>"
				+ "<nome>Anderson Piotto Leite1</nome>"
				+ "<operacao>1</operacao>"
				+ "<sexo>M</sexo>"
				+ "<tipo>1</tipo>"
				+ "</beneficiarios>"
				+ "<observacao>msg de observaÃ§Ã£o</observacao>"
				+ "</retornoArcelor>";
		

		
		
		String[] tagsXML = getTagsXML(XMLResponse);
		
		String[]  tagsXMLParaValidacaoDeValores = getTagsXMLParaValidacaoDeValores(XML);
		
		boolean validaSeCamposDoLayoutEstaoNoXML = validaSeCamposDoLayoutEstaoNoXML(layout, tagsXML);
		
		boolean validaSeExisteCampoAMaisNoXMLQueNaoExisteNoLayout = validaSeExisteCampoAMaisNoXMLQueNaoExisteNoLayout(layout, tagsXML);
		
		boolean validaSeCamposObrigatoriosEstaoPreenchidos = validaSeCamposObrigatoriosEstaoPreenchidos(layout, obrigatoriedade, tagsXMLParaValidacaoDeValores);
		
		boolean validaSeTiposDeCamposEstaoDeAcordoComLayout = validaSeTiposDeCamposEstaoDeAcordoComLayout(layout, tiposCampo, tagsXML, obrigatoriedade);
		
		if(validaSeCamposDoLayoutEstaoNoXML && 
				validaSeExisteCampoAMaisNoXMLQueNaoExisteNoLayout && 
				validaSeCamposObrigatoriosEstaoPreenchidos && 
				validaSeTiposDeCamposEstaoDeAcordoComLayout) {
			
			System.out.println("PASSOU NO TESTE");
		}
		
		
	}
	
	private static String[] getTagsXML(String XML) {
		
		// caso venha formatado em varias linhas, remove os espaços
		XML = XML.replace("  ", "");
		
		String XMLPreparadoParaSplit = XML.replace("><", ">#<").toLowerCase();
		
		String[] tagsXML = XMLPreparadoParaSplit.split("#");
		
		return tagsXML;
		
	}
	
	private static String[] getTagsXMLParaValidacaoDeValores(String XML) {
		
		String XMLPreparadoParaValidacaoDeValores= XML.replace("><", ">#<").replace(">#</", "></").toLowerCase();
		
		String[] tagsXMLParaValidacaoDeValores =  XMLPreparadoParaValidacaoDeValores.split("#");
		
		return tagsXMLParaValidacaoDeValores;
		
	}
	
	private static boolean validaSeCamposDoLayoutEstaoNoXML(String[] layout, String[] tagsXML) {
		
		boolean xmlNoPadraoCorreto = false;
		String tagLayout = "";
		String tagXML = "";
		
		// percorre as tags de layout
		for (int i = 0; i < layout.length; i++) {
			
			xmlNoPadraoCorreto = false;
		
			tagLayout = "<"+layout[i].toLowerCase()+">";
			
			// percorre as tags do XML verifica se a tag do layout esta lá
				for (String tag : tagsXML) {
					
					tagXML = tag;
					
					// se for uma tag vazia, como <tag/>, realiza a formatação para validação
					tagXML = formataTagVaziaParaValidacao(tagXML);
					
					boolean existeNoXML = tagXML.contains(tagLayout);
					
					if(existeNoXML) {
						xmlNoPadraoCorreto = true;
						break;
					}
				}
				

				if(!xmlNoPadraoCorreto) {
					throw new IllegalArgumentException("*** XML Fora do Padrão! Existem Tags no Layout que não existem no XML. Tag: " + tagLayout);
				}
			
		}
		
		return xmlNoPadraoCorreto;
		
	}
	
	private static boolean validaSeExisteCampoAMaisNoXMLQueNaoExisteNoLayout(String[] layout, String[] tagsXML) {
		
		boolean xmlNoPadraoCorreto = false;
		
		String tagLayout = "";
		String tagXML = "";
		
		// percorre as tags XML
		for (String tag : tagsXML) {
			
			// caso seja tag de versionamento ou de fechamento, como </tag>, é desconsiderado na comparação  com o layout
			if(! isTagXMLDeVersionamento(tag) && !isTagXMLDeFechamento(tag)) {
				
				xmlNoPadraoCorreto = false;
				
				tagXML = tag;
			
				//percorre as tags do Layout vendo se alguma tag do XML nao existe .
				for (int i = 0; i < layout.length; i++) {
					
					tagLayout = "<"+layout[i].toLowerCase()+">";
					
					// se for uma tag vazia, como <tag/>, realiza a formatação para validação
					tagXML = formataTagVaziaParaValidacao(tagXML);
						
						if(tagXML.contains(tagLayout)) {
							
							xmlNoPadraoCorreto = true;
							
							break;
						}
					
				}
					
				if(!xmlNoPadraoCorreto) {
					
					throw new IllegalArgumentException("*** XML Fora do Padrão! Existem Tags no XML que não existem no Layout. Tag: " + tag);
				}
			}
			
		}
		
		return xmlNoPadraoCorreto;
		
	}
	
	private static boolean validaSeCamposObrigatoriosEstaoPreenchidos(String[] layout, boolean [] obrigatoriedade, String[] tagsXML) {
		
		boolean xmlNoPadraoCorreto = true;
		
		String tagXML = "";
		
		String tagLayout = "";
		
		for (int i = 0; i < layout.length; i++) {
			
			tagLayout = layout[i];
			
			boolean obrigatorio = obrigatoriedade[i];	
			
			for (String tag : tagsXML) {
				
				tagXML = tag;
				
				if(tagXML.contains(tagLayout.toLowerCase())) {
					
					// verifica se é obrigatório e se não se trata somente de uma tag de abertura
					if(obrigatorio && !isTagXMLSomenteDeAbertura(tagXML)) {
						
						// se a tag estiver vazia e for obrigatório o preenchimento do valor
						if(isTagXMLVazia(tagXML)) {
							xmlNoPadraoCorreto = false;
							throw new IllegalArgumentException("*** XML Fora do Padrão! Conforme definido no layout, o valor da tag é obrigatório. Tag: " + tagXML);
						}
						
						String tagLayoutAbertura = "<"+layout[i].toLowerCase()+">";
						String tagLayoutFechamento = "</"+layout[i].toLowerCase()+">";
						
						String valor = tagXML.replace(tagLayoutAbertura, "").replace(tagLayoutFechamento, "");
						
						// verifica valores inválidos
						if(valor.equals("") || valor.equalsIgnoreCase("null") || valor.equalsIgnoreCase("0")) {
							xmlNoPadraoCorreto = false;
							
							throw new IllegalArgumentException("*** XML Fora do Padrão! Conforme definido no layout, o valor da tag é obrigatório. Tag: " + tagXML);
						}
						
					}
					
					//alteração break;
					
				}
				
			}
		}
		
		return xmlNoPadraoCorreto;
	}
	
	
	private static boolean validaSeTiposDeCamposEstaoDeAcordoComLayout(String[] layout, String[] tiposCampo, String[] tagsXML, boolean [] obrigatoriedade) {
		
	boolean xmlNoPadraoCorreto = true;
	
	String tagXML = "";
	
	String tagLayout = "";
	
	SimpleDateFormat formatData = new SimpleDateFormat("dd-MM-yyyy");
		
	for (int i = 0; i < layout.length; i++) {
		
		tagLayout = layout[i];
		
		boolean obrigatorio = obrigatoriedade[i];	
		
		for (String tag : tagsXML) {
			
			tagXML = tag;
			
			if(tagXML.contains(tagLayout.toLowerCase())) {
				
				// verifica se é um campo obrigatório e se não trata somente de uma tag de abertura
				if(obrigatorio && !isTagXMLSomenteDeAbertura(tagXML)) {
					
					String tagLayoutAbertura = "<"+layout[i].toLowerCase()+">";
					String tagLayoutFechamento = "</"+layout[i].toLowerCase()+">";
					
					String valor = tagXML.replace(tagLayoutAbertura, "").replace(tagLayoutFechamento, "");
					
					try {
							
						if(tiposCampo[i].equals("NUMERO")) {
							
							Long.parseLong(valor);
						}
						
						if(tiposCampo[i].equals("BOOLEANO")) {
							
							if((!valor.equalsIgnoreCase("true") && (!valor.equalsIgnoreCase("false")))) {
								throw new IllegalArgumentException("*** XML Fora do Padrão! Valor do campo do XML esta divergente com o especificado no layout. Tag: " + tagXML + " - Valor: " + valor);
							}
						}
						
						if(tiposCampo[i].equals("DECIMAL")) {
							
							Double.parseDouble(valor);
						}
						
						if(tiposCampo[i].equals("DATA")) {
							
							formatData.parse(valor);
						}
						
						}catch (Exception e) {
							xmlNoPadraoCorreto = false;
							throw new IllegalArgumentException("*** XML Fora do Padrão! Valor do campo do XML esta divergente com o especificado no layout. Tag: " + tagXML + " - Valor: " + valor);
						}
						
					}
					
				//alteração break;
					
				}
				
			}
		}
		
		return xmlNoPadraoCorreto;
		
	}
	
	private static String formataTagVaziaParaValidacao(String tagXML) {
		return isTagXMLVazia(tagXML) ? tagXML.replace("/>", ">"): tagXML;
	}
	
	
	private static boolean isTagXMLVazia(String tag) {
		// exemplo: <cdPlano/>
		if((tag.charAt(0) == '<') && 
				(tag.charAt(tag.length()-2) == '/') && 
				(tag.charAt(tag.length()-1) == '>')) {
			
			return true;
		}
		
		return false;
		
	}
	
	private static boolean isTagXMLDeVersionamento(String tag) {
		// exemplo: <?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>
		if(tag.contains("?xml")) {
			
			return true;
		}
		
		return false;
		
	}
	
	private static boolean isTagXMLSomenteDeAbertura(String tag) {
		// exemplo: <cliente>
		if(! tag.contains("/")) {
			
			return true;
		}
		
		return false;
		
	}
	
	private static boolean isTagXMLDeFechamento(String tag) {
		
		// exemplo: </cliente>
		if((tag.charAt(0) == '<') && 
				(tag.charAt(1) == '/' && 
				(tag.charAt(tag.length()-1) == '>'))) {
			
			return true;
		}
		
		return false;
		
	}

}
