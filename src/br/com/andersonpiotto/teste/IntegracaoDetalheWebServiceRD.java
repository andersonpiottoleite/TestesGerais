package br.com.andersonpiotto.teste;

import java.math.BigDecimal;
import java.util.Date;

public class IntegracaoDetalheWebServiceRD{

	private static final long serialVersionUID = 1L;

	private IntegracaoWebServicePk pk;

	private BigDecimal cdCartao;

	private BigDecimal cdCentroCusto;

	private String cdCep;

	private BigDecimal cdContrato;

	private BigDecimal cdOperadorAlteracao;

	private BigDecimal cdOperadorCadastro;

	private BigDecimal cdPlano;

	private BigDecimal cdSituacaoCartao;

	private BigDecimal cdTpEndereco;

	//private BigDecimal cdTpParentesco; - MODIFICADO
	private BigDecimal cdGrauParentesco;

	private BigDecimal cdTpTelefone;

	//private BigDecimal cdTpTitularidade;  - MODIFICADO
	private BigDecimal cdTipoTitularidade;

	private String cdUf;

	private String dsBairro;

	private String dsCidade;

	private String dsComplemento;

	private String dsEmail;

	private String dsEndereco;

	private String dsSexo;//- MANTIDO

	private Date dtCadastro;

	private Date dtFimVigenciaCartao;

	private Date dtIniVigenciaCartao;

	//private Date dtNascimento; - MODIFICADO
	private Date dataNascimento;

	private Date dtUltAlteracao;

	private Boolean flCartaoTitular = false;

	private BigDecimal idCliente;

	private BigDecimal idConta;

	private BigDecimal idClienteTitular;

	//private String nmCliente; - MODIFICADO
	private String nomeCliente;

	private String nrCpf; // - MANTIDO

	private BigDecimal nrCrm;

	private String nrEndereco;

	private String nrIdentClienteEmpresa;

	private String nrMatricula;// - MANTIDO

	private BigDecimal nrPrefixo;

	private String nrRg;

	private BigDecimal nrTelefone;

	private BigDecimal nrVia;

	private BigDecimal vlLimite;// - MANTIDO

	private BigDecimal vlSublimite;

	private String dsObservacao;
	
	private String cdsFilialCliente;

	private String cdsCentroCusto;

	private String cdsBeneficio;

	// itau

	private String cdsBanco;

	private String cdsAgencia;

	private String cdsContaCorrente;

	private String cdsCodOrganograma;

	private String cdsDsOrganograma;

	private String cdsCustoLotacao;

	private String subEstipulante;

	private Long cdContratoEspecifico;
	
	private BigDecimal cdTpAcao;
	
	// NEW 
	private String numeroCarteira;
	
	private String dsOperacao;
	
	public IntegracaoDetalheWebServiceRD(long idIntegracao, Long nmIntegracaoDetalhe){
 		this.pk = new IntegracaoWebServicePk();
 		
 		this.pk.setIdIntegracao(idIntegracao);
 		this.pk.setNmIntegracaoDetalhe(nmIntegracaoDetalhe);
 	}
	
	public IntegracaoDetalheWebServiceRD(){}

	public IntegracaoWebServicePk getPk() {
		return pk;
	}

	public void setPk(IntegracaoWebServicePk pk) {
		this.pk = pk;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public BigDecimal getCdCartao() {
		return this.cdCartao;
	}

	public void setCdCartao(BigDecimal cdCartao) {
		this.cdCartao = cdCartao;
	}

	public BigDecimal getCdCentroCusto() {
		return this.cdCentroCusto;
	}

	public void setCdCentroCusto(BigDecimal cdCentroCusto) {
		this.cdCentroCusto = cdCentroCusto;
	}

	public String getCdCep() {
		return this.cdCep;
	}

	public void setCdCep(String cdCep) {
		this.cdCep = cdCep;
	}

	public BigDecimal getCdContrato() {
		return this.cdContrato;
	}

	public void setCdContrato(BigDecimal cdContrato) {
		this.cdContrato = cdContrato;
	}

	public BigDecimal getCdOperadorAlteracao() {
		return this.cdOperadorAlteracao;
	}

	public void setCdOperadorAlteracao(BigDecimal cdOperadorAlteracao) {
		this.cdOperadorAlteracao = cdOperadorAlteracao;
	}

	public BigDecimal getCdOperadorCadastro() {
		return this.cdOperadorCadastro;
	}

	public void setCdOperadorCadastro(BigDecimal cdOperadorCadastro) {
		this.cdOperadorCadastro = cdOperadorCadastro;
	}

	public BigDecimal getCdPlano() {
		return this.cdPlano;
	}

	public void setCdPlano(BigDecimal cdPlano) {
		this.cdPlano = cdPlano;
	}

	public BigDecimal getCdSituacaoCartao() {
		return this.cdSituacaoCartao;
	}

	public void setCdSituacaoCartao(BigDecimal cdSituacaoCartao) {
		this.cdSituacaoCartao = cdSituacaoCartao;
	}

	public BigDecimal getCdTpEndereco() {
		return this.cdTpEndereco;
	}

	public void setCdTpEndereco(BigDecimal cdTpEndereco) {
		this.cdTpEndereco = cdTpEndereco;
	}

	public BigDecimal getCdTpTelefone() {
		return this.cdTpTelefone;
	}

	public void setCdTpTelefone(BigDecimal cdTpTelefone) {
		this.cdTpTelefone = cdTpTelefone;
	}

	public String getCdUf() {
		return this.cdUf;
	}

	public void setCdUf(String cdUf) {
		this.cdUf = cdUf;
	}

	public String getDsBairro() {
		return this.dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsCidade() {
		return this.dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public String getDsComplemento() {
		return this.dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsEndereco() {
		return this.dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}


	public Date getDtCadastro() {
		return this.dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtFimVigenciaCartao() {
		return this.dtFimVigenciaCartao;
	}

	public void setDtFimVigenciaCartao(Date dtFimVigenciaCartao) {
		this.dtFimVigenciaCartao = dtFimVigenciaCartao;
	}

	public Date getDtIniVigenciaCartao() {
		return this.dtIniVigenciaCartao;
	}

	public void setDtIniVigenciaCartao(Date dtIniVigenciaCartao) {
		this.dtIniVigenciaCartao = dtIniVigenciaCartao;
	}

	public Date getDtUltAlteracao() {
		return this.dtUltAlteracao;
	}

	public void setDtUltAlteracao(Date dtUltAlteracao) {
		this.dtUltAlteracao = dtUltAlteracao;
	}

	public Boolean getFlCartaoTitular() {
		return flCartaoTitular;
	}

	public void setFlCartaoTitular(Boolean flCartaoTitular) {
		this.flCartaoTitular = flCartaoTitular;
	}

	public BigDecimal getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(BigDecimal idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getIdClienteTitular() {
		return this.idClienteTitular;
	}

	public void setIdClienteTitular(BigDecimal idClienteTitular) {
		this.idClienteTitular = idClienteTitular;
	}

	public BigDecimal getNrCrm() {
		return this.nrCrm;
	}

	public void setNrCrm(BigDecimal nrCrm) {
		this.nrCrm = nrCrm;
	}

	public String getNrEndereco() {
		return this.nrEndereco;
	}

	public void setNrEndereco(String nrEndereco) {
		this.nrEndereco = nrEndereco;
	}

	public String getNrIdentClienteEmpresa() {
		return this.nrIdentClienteEmpresa;
	}

	public void setNrIdentClienteEmpresa(String nrIdentClienteEmpresa) {
		this.nrIdentClienteEmpresa = nrIdentClienteEmpresa;
	}

	public BigDecimal getNrPrefixo() {
		return this.nrPrefixo;
	}

	public void setNrPrefixo(BigDecimal nrPrefixo) {
		this.nrPrefixo = nrPrefixo;
	}

	public String getNrRg() {
		return this.nrRg;
	}

	public void setNrRg(String nrRg) {
		this.nrRg = nrRg;
	}

	public BigDecimal getNrTelefone() {
		return this.nrTelefone;
	}

	public void setNrTelefone(BigDecimal nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public BigDecimal getNrVia() {
		return this.nrVia;
	}

	public void setNrVia(BigDecimal nrVia) {
		this.nrVia = nrVia;
	}

	public BigDecimal getVlSublimite() {
		return this.vlSublimite;
	}

	public void setVlSublimite(BigDecimal vlSublimite) {
		this.vlSublimite = vlSublimite;
	}

	/*
	public TipoRegistro getTipoRegistro() {
		return this.tipoRegistro;
	}

	public void setTipoRegistro(TipoRegistro tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public ArquivoValidacao getArquivoValidacao() {
		return arquivoValidacao;
	}

	public void setArquivoValidacao(ArquivoValidacao arquivoValidacao) {
		this.arquivoValidacao = arquivoValidacao;
	}
	*/

	public String getDsObservacao() {
		return this.dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	public BigDecimal getIdConta() {
		return this.idConta;
	}

	public void setIdConta(BigDecimal idConta) {
		this.idConta = idConta;
	}

	public String getCdsFilialCliente() {
		return cdsFilialCliente;
	}

	public void setCdsFilialCliente(String cdsFilialCliente) {
		this.cdsFilialCliente = cdsFilialCliente;
	}

	public String getCdsCentroCusto() {
		return cdsCentroCusto;
	}

	public void setCdsCentroCusto(String cdsCentroCusto) {
		this.cdsCentroCusto = cdsCentroCusto;
	}

	public String getCdsBeneficio() {
		return cdsBeneficio;
	}

	public void setCdsBeneficio(String cdsBeneficio) {
		this.cdsBeneficio = cdsBeneficio;
	}

	public String getCdsBanco() {
		return cdsBanco;
	}

	public void setCdsBanco(String cdsBanco) {
		this.cdsBanco = cdsBanco;
	}

	public String getCdsAgencia() {
		return cdsAgencia;
	}

	public void setCdsAgencia(String cdsAgencia) {
		this.cdsAgencia = cdsAgencia;
	}

	public String getCdsContaCorrente() {
		return cdsContaCorrente;
	}

	public void setCdsContaCorrente(String cdsContaCorrente) {
		this.cdsContaCorrente = cdsContaCorrente;
	}

	public String getCdsCodOrganograma() {
		return cdsCodOrganograma;
	}

	public void setCdsCodOrganograma(String cdsCodOrganograma) {
		this.cdsCodOrganograma = cdsCodOrganograma;
	}

	public String getCdsDsOrganograma() {
		return cdsDsOrganograma;
	}

	public void setCdsDsOrganograma(String cdsDsOrganograma) {
		this.cdsDsOrganograma = cdsDsOrganograma;
	}

	public String getCdsCustoLotacao() {
		return cdsCustoLotacao;
	}

	public void setCdsCustoLotacao(String cdsCustoLotacao) {
		this.cdsCustoLotacao = cdsCustoLotacao;
	}

	public long getCdContratoEspecifico() {
		return cdContratoEspecifico;
	}

	public void setCdContratoEspecifico(long cdContratoEspecifico) {
		this.cdContratoEspecifico = cdContratoEspecifico;
	}

    public String getSubEstipulante() {
        return subEstipulante;
    }

    public void setSubEstipulante(String subEstipulante) {
        this.subEstipulante = subEstipulante;
    }

    public BigDecimal getCdTpAcao() {
        return cdTpAcao;
    }

    public void setCdTpAcao(BigDecimal cdTpAcao) {
        this.cdTpAcao = cdTpAcao;
    }

    public BigDecimal getCdGrauParentesco() {
		return cdGrauParentesco;
	}

	public void setCdGrauParentesco(BigDecimal cdGrauParentesco) {
		this.cdGrauParentesco = cdGrauParentesco;
	}

	public BigDecimal getCdTipoTitularidade() {
		return cdTipoTitularidade;
	}

	public void setCdTipoTitularidade(BigDecimal cdTipoTitularidade) {
		this.cdTipoTitularidade = cdTipoTitularidade;
	}

	public String getDsSexo() {
		return dsSexo;
	}

	public void setDsSexo(String dsSexo) {
		this.dsSexo = dsSexo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}

	public String getNrMatricula() {
		return nrMatricula;
	}

	public void setNrMatricula(String nrMatricula) {
		this.nrMatricula = nrMatricula;
	}

	public BigDecimal getVlLimite() {
		return vlLimite;
	}

	public void setVlLimite(BigDecimal vlLimite) {
		this.vlLimite = vlLimite;
	}

	public String getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(String numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getDsOperacao() {
		return dsOperacao;
	}

	public void setDsOperacao(String dsOperacao) {
		this.dsOperacao = dsOperacao;
	}

	public void setCdContratoEspecifico(Long cdContratoEspecifico) {
		this.cdContratoEspecifico = cdContratoEspecifico;
	}

	@Override
	public String toString() {
		return "idIntegracao=" + getPk().getIdIntegracao() +" NmIntegracaoDetalhe=" +  getPk().getNmIntegracaoDetalhe() + " cdContrato=" + cdContrato + " cdPlano=" + cdPlano + " nomeCliente=" + nomeCliente + " nrIdentClienteEmpresa="
				+ nrIdentClienteEmpresa;
	}

}
