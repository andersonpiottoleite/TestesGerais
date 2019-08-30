package br.com.andersonpiotto.teste;

public class ValidaXML {

	public static void main(String[] args) {
		
		//String[] layout = {"clienteComEndereco","cdContrato", "cdPlano", "nome", "email", "idade", "vivo", "fortuna","enderecos","numero","rua"};
		//String[] tiposCampo = {"STRING","NUMERO","NUMERO","STRING", "STRING", "NUMERO","BOOLEANO","DECIMAL","STRING","NUMERO","STRING"};
		//boolean[] obrigatoriedade = {true,false,true,true, true, true,false,true, true,true,false};
		
		//String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><clienteComEndereco><cdContrato></cdContrato><cdPlano>5388</cdPlano><email>piotto2k10@gmail.com</email><enderecos><numero>8</numero><rua>Teste minha rua!</rua></enderecos><enderecos><numero>10</numero><rua>Teste outra rua!</rua></enderecos><fortuna>50.0</fortuna><idade>44</idade><nome>Anderson Piotto 2</nome><vivo>true</vivo></clienteComEndereco>";
		
		String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retornoArcelor><beneficiarios><carteira>00101305960101</carteira><cdPlano>15</cdPlano><cpf>35461848826</cpf><dataNascimento>2019-08-27T16:13:20.443-03:00</dataNascimento><grauParentesco>1</grauParentesco><limite>100</limite><matricula>010130596</matricula><nome>Anderson Piotto Leite1</nome><operacao>1</operacao><sexo>M</sexo><tipo>1</tipo></beneficiarios><beneficiarios><carteira>00101305960101</carteira><cdPlano>15</cdPlano><cpf>35461848826</cpf><dataNascimento>2019-08-27T16:13:20.443-03:00</dataNascimento><grauParentesco>1</grauParentesco><limite>100</limite><matricula>010130596</matricula><nome>Anderson Piotto Leite1</nome><operacao>1</operacao><sexo>M</sexo><tipo>1</tipo></beneficiarios><beneficiarios><carteira>00101305960101</carteira><cdPlano>15</cdPlano><cpf>35461848826</cpf><dataNascimento>2019-08-27T16:13:20.443-03:00</dataNascimento><grauParentesco>1</grauParentesco><limite>100</limite><matricula>010130596</matricula><nome>Anderson Piotto Leite1</nome><operacao>1</operacao><sexo>M</sexo><tipo>1</tipo></beneficiarios><beneficiarios><carteira>00101305960101</carteira><cdPlano>15</cdPlano><cpf>35461848826</cpf><dataNascimento>2019-08-27T16:13:20.443-03:00</dataNascimento><grauParentesco>1</grauParentesco><limite>100</limite><matricula>010130596</matricula><nome>Anderson Piotto Leite1</nome><operacao>1</operacao><sexo>M</sexo><tipo>1</tipo></beneficiarios><beneficiarios><carteira>00101305960101</carteira><cdPlano>15</cdPlano><cpf>35461848826</cpf><dataNascimento>2019-08-27T16:13:20.443-03:00</dataNascimento><grauParentesco>1</grauParentesco><limite>100</limite><matricula>010130596</matricula><nome>Anderson Piotto Leite1</nome><operacao>1</operacao><sexo>M</sexo><tipo>1</tipo></beneficiarios><beneficiarios><carteira>00101305960101</carteira><cdPlano>15</cdPlano><cpf>35461848826</cpf><dataNascimento>2019-08-27T16:13:20.443-03:00</dataNascimento><grauParentesco>1</grauParentesco><limite>100</limite><matricula>010130596</matricula><nome>Anderson Piotto Leite1</nome><operacao>1</operacao><sexo>M</sexo><tipo>1</tipo></beneficiarios><observacao>msg de observaÃ§Ã£o</observacao><status>true</status></retornoArcelor>";

		String[] layout = {"cliente","cdContrato", "cdPlano", "nome", "email", "idade", "vivo", "fortuna"};
		String[] tiposCampo = {"STRING","NUMERO","NUMERO","STRING", "STRING", "NUMERO","BOOLEANO","DECIMAL"};
		boolean[] obrigatoriedade = {true,true,true,true, true, true,false,true};
		
		//String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cliente><cdContrato/><cdPlano/><email>piotto2k10@gmail.com</email><fortuna>50.0</fortuna><idade>34</idade><nome>Anderson Piotto 2</nome><vivo>true</vivo></cliente>";
		 
		// aplicar a partir daqui
		String XMLPreparado = XML.replace("><", ">#<").replace(">#</", "></").toLowerCase();
		
		String[] xmlquebradoEmTags = XMLPreparado.split("#");
		
		boolean xmlNoPadraoCorreto = false;
		
		/**
		 * Valida se com campos cadastrados no Layout estão no XML
		 */
		for (int i = 0; i < layout.length; i++) {
			
			xmlNoPadraoCorreto = false;
			
			String layoutTagAbertura = "<"+layout[i].toLowerCase()+">";
			
			for (String tag : xmlquebradoEmTags) {
				
				// tratando tag vazia
				//tag = tag.replace("/>", ">");// vert aqui
				
				if(tag.contains(layoutTagAbertura)) {
					
					xmlNoPadraoCorreto = true;
					
					boolean obrigatorio = obrigatoriedade[i];
					
					if(obrigatorio) {
						if(tagVazia(tag)) {
							throw new IllegalArgumentException("XML Fora do Padrão! Conforme definido no layout, o valor da tag é obrigatório. Tag: " + layoutTagAbertura);
						}
					}
					
					boolean tagContemValorParaValidar = tag.contains("</");
					
					/**
					 * verifica se os campos obrigatórios estão preenchidos corretamente
					 */
					if(tagContemValorParaValidar){
						
						String layoutTagFechamento = "</"+layout[i].toLowerCase()+">";
						String valor = tag.replace(layoutTagAbertura, "").replace(layoutTagFechamento, "");
						
						// tratando último elemento
						if(valor.contains("</")) {
							
							valor = valor.substring(0,valor.indexOf("</"));
						}
						
						if(obrigatorio) {
							
							if(valor.equals("") || valor.equalsIgnoreCase("null") || valor.equalsIgnoreCase("0")) {
								throw new IllegalArgumentException("XML Fora do Padrão! Conforme definido no layout, o valor da tag é obrigatório. Tag: " + layoutTagAbertura);
							}
						}
						
						/**
						 * verifica se o valor é compativel com o tipo espeficicado no layout
						 */
						try {
						
							if(tiposCampo[i].equals("NUMERO")) {
								
								Long.parseLong(valor);
							}
							
							if(tiposCampo[i].equals("BOOLEANO")) {
								
								if((!valor.equalsIgnoreCase("true") && (!valor.equalsIgnoreCase("false")))) {
									throw new IllegalArgumentException("XML Fora do Padrão! Valor do campo do XML esta divergente com o especificado no layout. Tag: " + layoutTagAbertura + " - Valor: " + valor);
								}
							}
							
							if(tiposCampo[i].equals("DECIMAL")) {
								
								Double.parseDouble(valor);
							}
						
						}catch (Exception e) {
							throw new IllegalArgumentException("XML Fora do Padrão! Valor do campo do XML esta divergente com o especificado no layout. Tag: " + layoutTagAbertura + " - Valor: " + valor);
						}
					}
					break;
				}
			}
			
			if(!xmlNoPadraoCorreto) {
				throw new IllegalArgumentException("XML Fora do Padrão! Campo do Layout não encontrado no XML: " + layoutTagAbertura);
			}
		}
		
		/**
		 *  verifica se existe tag a mais no XML que não existe no Layout
		 */
		
		for (String tag : xmlquebradoEmTags) {
			
			xmlNoPadraoCorreto = false;
			
			for (int i = 0; i < layout.length; i++) {
				
				String layoutTagAbertura = "<"+layout[i].toLowerCase()+">";
				
				// tratando tag vazia
				tag = tag.replace("/>", ">");
				
				if(tag.contains(layoutTagAbertura)) {
					
					xmlNoPadraoCorreto = true;
					break;
				}
			}
			
			if(!tag.contains("?xml")) {
				
				if(!xmlNoPadraoCorreto) {
					
					throw new IllegalArgumentException("XML Fora do Padrão! Existem Tags no XML que não existem no Layout. Tag: " + tag);
				}
			}
			
		}
		System.out.println("PASSOU!");
		
	}
	
	private static boolean tagVazia(String tag) {
		
		System.out.println("Tag validando... " + tag);
		
		if((tag.charAt(0) == '<') && 
				(tag.charAt(tag.length()-2) == '/') && 
				(tag.charAt(tag.length()-1) == '>')) {
			
			return true;
		}
		
		return false;
		
	}

}
