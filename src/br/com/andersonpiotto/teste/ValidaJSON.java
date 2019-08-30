package br.com.andersonpiotto.teste;

public class ValidaJSON {

	public static void main(String[] args) {

		String[] layout = {"cdContrato", "cdPlano", "nome", "email", "idade", "vivo", "fortuna"};
		String[] tiposCampo = {"NUMERO","NUMERO","STRING", "STRING", "NUMERO","BOOLEANO","DECIMAL"};
		boolean[] obrigatoriedade = {true,true,true,true, true, true,false,true};
		
		//String JSON = "{\"cdContrato\":11603,\"cdPlano\":5388,\"nome\":\"Anderson Piotto 2\",\"idade\":44,\"email\":\"piotto2k10@gmail.com\",\"vivo\":true,\"fortuna\":50.0,\"intrusa\":\"13\"}";
		
		String JSONAcerlor = "{\"beneficiarios\":[{\"cdPlano\":15,\"matricula\":\"010130596\",\"carteira\":\"00101305960101\",\"nome\":\"Anderson Piotto Leite1\",\"cpf\":\"35461848826\",\"tipo\":1,\"grauParentesco\":1,\"dataNascimento\":\"Aug 27, 2019 4:15:46 PM\",\"sexo\":\"M\",\"limite\":100,\"operacao\":1},{\"cdPlano\":15,\"matricula\":\"010130596\",\"carteira\":\"00101305960101\",\"nome\":\"Anderson Piotto Leite1\",\"cpf\":\"35461848826\",\"tipo\":1,\"grauParentesco\":1,\"dataNascimento\":\"Aug 27, 2019 4:15:46 PM\",\"sexo\":\"M\",\"limite\":100,\"operacao\":1},{\"cdPlano\":15,\"matricula\":\"010130596\",\"carteira\":\"00101305960101\",\"nome\":\"Anderson Piotto Leite1\",\"cpf\":\"35461848826\",\"tipo\":1,\"grauParentesco\":1,\"dataNascimento\":\"Aug 27, 2019 4:15:46 PM\",\"sexo\":\"M\",\"limite\":100,\"operacao\":1},{\"cdPlano\":15,\"matricula\":\"010130596\",\"carteira\":\"00101305960101\",\"nome\":\"Anderson Piotto Leite1\",\"cpf\":\"35461848826\",\"tipo\":1,\"grauParentesco\":1,\"dataNascimento\":\"Aug 27, 2019 4:15:46 PM\",\"sexo\":\"M\",\"limite\":100,\"operacao\":1},{\"cdPlano\":15,\"matricula\":\"010130596\",\"carteira\":\"00101305960101\",\"nome\":\"Anderson Piotto Leite1\",\"cpf\":\"35461848826\",\"tipo\":1,\"grauParentesco\":1,\"dataNascimento\":\"Aug 27, 2019 4:15:46 PM\",\"sexo\":\"M\",\"limite\":100,\"operacao\":1},{\"cdPlano\":15,\"matricula\":\"010130596\",\"carteira\":\"00101305960101\",\"nome\":\"Anderson Piotto Leite1\",\"cpf\":\"35461848826\",\"tipo\":1,\"grauParentesco\":1,\"dataNascimento\":\"Aug 27, 2019 4:15:46 PM\",\"sexo\":\"M\",\"limite\":100,\"operacao\":1}],\"status\":true,\"observacao\":\"msg de observa√ß√£o\"}";
		
		String JSON = "{\"cdContrato\":11603,\"cdPlano\":5388,\"nome\":\"Anderson Piotto 2\",\"idade\":44,\"email\":\"piotto2k10@gmail.com\",\"vivo\":true,\"fortuna\":50.0,\"enderecos\":[{\"rua\":\"Teste outra rua!\",\"numero\":\"10\"},{}]}";
		
		// aplicar a partir daqui
		String JSONPreparado = JSON.replaceAll("\"", "").replace("{", "").replace("}", "").toLowerCase();
		
		String[] JSONQuebradoChaveValor = JSONPreparado.split(",");
		
		boolean jsonNoPadraoCorreto = false;
		
		/**
		 * Valida se com campos cadastrados no Layout est„o no JSON
		 */
		
		for (int i = 0; i < layout.length; i++) {
			
			jsonNoPadraoCorreto = false;
			String layoutChaveAbertura = layout[i].toLowerCase();
			
			for (String chaveValor : JSONQuebradoChaveValor) {
				
				if(chaveValor.contains(layoutChaveAbertura)) {
					
					jsonNoPadraoCorreto = true;
					
					String valor = chaveValor.replace(layout[i].toLowerCase()+":", "");
					
					boolean obrigatorio = obrigatoriedade[i];
					
					/**
					 * verifica se os campos obrigatÛrios est„o preenchidos corretamente
					 */
					if(obrigatorio) {
						
						if(valor.equals("") || valor.equalsIgnoreCase("null") || valor.equalsIgnoreCase("0")) {
							throw new IllegalArgumentException("XML Fora do Padr„o! Conforme definido no layout, o valor da tag È obrigatÛrio. Tag: " + layoutChaveAbertura);
						}
					}
					
					/**
					 * verifica se o valor È compativel com o tipo espeficicado no layout
					 */
					try {
					
						if(tiposCampo[i].equals("NUMERO")) {
							
							Long.parseLong(valor);
						}
						
						if(tiposCampo[i].equals("BOOLEANO")) {	
							
							if((!valor.equalsIgnoreCase("true") && (!valor.equalsIgnoreCase("false")))) {
								throw new Exception();
							}
						}
						
						if(tiposCampo[i].equals("DECIMAL")) {
							
							Double.parseDouble(valor);
						}
					
					}catch (Exception e) {
						throw new IllegalArgumentException("JSON Fora do Padr„o! Valor do campo do JSON esta divergente com o especificado no layout. Chave: " + layoutChaveAbertura + " - Valor: " + valor);
					}
					break;
				}
			}
			
			if(!jsonNoPadraoCorreto) {
				throw new IllegalArgumentException("JSON Fora do Padr„o! Campo do Layout n„o encontrado no JSON: " + layoutChaveAbertura);
			}
		}
		
		/**
		 *  verifica se existe objeto a mais no JSON que n„o existe no Layout
		 */
		for (String chave : JSONQuebradoChaveValor) {
			
			jsonNoPadraoCorreto = false;
			
			for (int i = 0; i < layout.length; i++) {
				
				String layoutChaveAbertura = layout[i].toLowerCase();
				
				if(chave.contains(layoutChaveAbertura)) {
					
					jsonNoPadraoCorreto = true;
					break;
				}
			}
			
			if(!jsonNoPadraoCorreto) {
				
				throw new IllegalArgumentException("JSON Fora do Padr„o! Existem Chaves no JSON que n„o existem no Layout. Chave: " + chave);
			}	
			
		}
		
	}

}
