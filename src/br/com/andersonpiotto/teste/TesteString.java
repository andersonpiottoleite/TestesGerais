package br.com.andersonpiotto.teste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteString {
	
	public static void main(String[] args) {
		
		/*String s1 = "piotto";
		String s2 = "PIOTTO";
		
		if (s1.toLowerCase().contains(s2.toLowerCase())) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}*/
		
		//StringBuilder sb = new StringBuilder("PIO:[{TTO");
		
		StringBuilder sbJSON = new StringBuilder("{\"beneficiarios\":[{\""
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
				+ "observacao\":\"msg de observação\"}");
		
		System.out.println(sbJSON);
		replaceAll(sbJSON, "  ","");
		replaceAll(sbJSON, "\\:\\[\\{",",");
 		replaceAll(sbJSON, "\\: \\[\\{", ",");
 		replaceAll(sbJSON, "\\\"", "");
 		replaceAll(sbJSON, "\\{", "");
 		replaceAll(sbJSON, "\\}", "");
 		replaceAll(sbJSON, "\\[", "");
 		replaceAll(sbJSON, "\\]", "");
 		replaceAll(sbJSON, "\\:\\[\\{",",");
 		replaceAll(sbJSON, "\\[\\{", "");
 		replaceAll(sbJSON, "\\}\\]", "");
        System.out.println(sbJSON);
        
        String[] JSONSeparadoEmChaveValor = sbJSON.toString().split(",");
        
        System.out.println(JSONSeparadoEmChaveValor);
        
       
        StringBuilder sbXML = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + 
        		"<clienteArcelor>" + 
        		"    <beneficiarios>" + 
        		"        <carteira>00101305960101</carteira>" + 
        		"        <cdPlano>15</cdPlano>" + 
        		"        <cpf>35461848826</cpf>" + 
        		"        <dataNascimento>12/03/1985</dataNascimento>" + 
        		"        <grauParentesco>1</grauParentesco>" + 
        		"        <limite>100</limite>" + 
        		"        <matricula>010130596</matricula>" + 
        		"        <nome>Anderson Piotto</nome>" + 
        		"        <operacao>1</operacao>" + 
        		"        <sexo>M</sexo>" + 
        		"        <tipo>1</tipo>" + 
        		"    </beneficiarios>" + 
        		"    <beneficiarios>" + 
        		"        <carteira>00101305960101</carteira>" + 
        		"        <cdPlano>15</cdPlano>" + 
        		"        <cpf>35461848826</cpf>" + 
        		"        <dataNascimento>12/03/1985</dataNascimento>" + 
        		"        <grauParentesco>1</grauParentesco>" + 
        		"        <limite>100</limite>" + 
        		"        <matricula>010130596</matricula>" + 
        		"        <nome>Anderson Piotto</nome>" + 
        		"        <operacao>1</operacao>" + 
        		"        <sexo>M</sexo>" + 
        		"        <tipo>1</tipo>" + 
        		"    </beneficiarios>" + 
        		"    <observacao>msg de observação</observacao>" + 
        		"    <status>true</status>" + 
        		"</clienteArcelor>");
		
		System.out.println(sbXML);
		replaceAll(sbXML, "  ", "");
		replaceAll(sbXML, "><", ">#<");
		
		String[] tagsXML = sbXML.toString().toLowerCase().split("#");
        
        System.out.println(tagsXML);
        
        
        
        
	}
	
	public static void replaceAll(StringBuilder sb, String find, String replace){
        
        Pattern p = Pattern.compile(find);
        
        Matcher matcher = p.matcher(sb); 
        
        int startIndex = 0;
        
        while( matcher.find(startIndex) ){
            
            sb.replace(matcher.start(), matcher.end(), replace);
            
            startIndex = matcher.start() + replace.length();
        }
    }

}
