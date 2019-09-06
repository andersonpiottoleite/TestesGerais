package br.com.andersonpiotto.teste;

/** Enum que representa os possíveis status para uma Operacao de uma <code>IntegracaoDetalheWebServiceRD</code> 
 * 
 * @author Anderson Piotto
 * @since 04/09/2019
 * @version 1.0.0
 */

public enum OperacaoIntegracaoDetalheWebServiceEnum{
	
	INCLUSAO(1,"INCLUSÃO"),
	ALTERACAO(2,"ALTERACAO"),
	BLOQUEIO_DEFINITIVO(3,"BLOQUEIO DEFINITIVO"),
	BLOQUEIO_TEMPORARIO(4,"BLOQUEIO TEMPORÁRIO"),
	DESBLOQUEIO_DE_CLIENTES_COM_BLOQUEIO_TEMPORARIO(5,"DESBLOQUEIO DE CLIENTES COM BLOQUEIO TEMPORÁRIO");
	
	public static String getDescricaoOperacaoPorValor(int valor) {
		
		for (OperacaoIntegracaoDetalheWebServiceEnum operacaoIntegracao : OperacaoIntegracaoDetalheWebServiceEnum.values()) {
			if(valor == operacaoIntegracao.getValor()) {
				return operacaoIntegracao.getDescricao();
			}
		}
		
		return null;
	}
	
	private final int valor;
	private final String descricao;
	
	private OperacaoIntegracaoDetalheWebServiceEnum(int valor,String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	

}

