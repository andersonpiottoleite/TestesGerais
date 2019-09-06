package br.com.andersonpiotto.teste;

import java.io.Serializable;

/**
 * Classe responsável por mapear a chave composta da tabela TB_BF_WEBSERVICE_INTEG_DETALHE.
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 05/09/2019
 */

public class IntegracaoWebServicePk implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idIntegracao;

	private Long nmIntegracaoDetalhe;

	public IntegracaoWebServicePk() {
	}

	public Long getIdIntegracao() {
		return idIntegracao;
	}

	public void setIdIntegracao(Long idIntegracao) {
		this.idIntegracao = idIntegracao;
	}

	public Long getNmIntegracaoDetalhe() {
		return nmIntegracaoDetalhe;
	}

	public void setNmIntegracaoDetalhe(Long nmIntegracaoDetalhe) {
		this.nmIntegracaoDetalhe = nmIntegracaoDetalhe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idIntegracao ^ (idIntegracao >>> 32));
		result = prime * result + ((nmIntegracaoDetalhe == null) ? 0 : nmIntegracaoDetalhe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegracaoWebServicePk other = (IntegracaoWebServicePk) obj;
		if (idIntegracao != other.idIntegracao)
			return false;
		if (nmIntegracaoDetalhe == null) {
			if (other.nmIntegracaoDetalhe != null)
				return false;
		} else if (!nmIntegracaoDetalhe.equals(other.nmIntegracaoDetalhe))
			return false;
		return true;
	}

}