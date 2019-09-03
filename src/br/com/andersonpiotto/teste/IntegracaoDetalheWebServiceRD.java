package br.com.andersonpiotto.teste;

import java.math.BigDecimal;
import java.util.Date;

public class IntegracaoDetalheWebServiceRD{

	private static final long serialVersionUID = 1L;

	private Long idIntegracao;

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
	private BigDecimal grauParentesco;

	private BigDecimal cdTpTelefone;

	private BigDecimal cdTpTitularidade;

	private String cdUf;

	private String dsBairro;

	private String dsCidade;

	private String dsComplemento;

	private String dsEmail;

	private String dsEndereco;

	//private String dsSexo; - MODIFICADO
	private String sexo;

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
	private String nome;

	//private String nrCpf;  - MODIFICADO
	private String cpf;

	private BigDecimal nrCrm;

	private String nrEndereco;

	private String nrIdentClienteEmpresa;

	//private String nrMatricula; - MODIFICADO
	private String matricula;

	private BigDecimal nrPrefixo;

	private String nrRg;

	private BigDecimal nrTelefone;

	private BigDecimal nrVia;

	//private BigDecimal vlLimite; - MODIFICADO
	private BigDecimal limite;

	private BigDecimal vlSublimite;

	private String dsObservacao;

	
	/* TODO, ver como vai ficar esas tabelas
	@ManyToOne
	@JoinColumn(name = "CD_TP_REGISTRO")
	private TipoRegistro tipoRegistro; - MODIFICADO
	*/
	private Long tipo;

	/*@ManyToOne
	@JoinColumn(name = "CD_VALIDACAO")
	private ArquivoValidacao arquivoValidacao; - 
	*/
	
	//new 
	private Long operacao;

	
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
	
	// NEW 
	private Long carteira;

    public BigDecimal getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(BigDecimal grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getOperacao() {
		return operacao;
	}

	public void setOperacao(Long operacao) {
		this.operacao = operacao;
	}

	public long getCarteira() {
		return carteira;
	}

	public void setCarteira(long carteira) {
		this.carteira = carteira;
	}

	public long getTipo() {
		return tipo;
	}

	public void setTipo(long tipo) {
		this.tipo = tipo;
	}

	private BigDecimal cdTpAcao;

	public IntegracaoDetalheWebServiceRD() {}
	
	public long getIdIntegracao() {
		return idIntegracao;
	}
	
	public void setIdIntegracao(long idIntegracao) {
		this.idIntegracao = idIntegracao;
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

	public BigDecimal getCdTpTitularidade() {
		return this.cdTpTitularidade;
	}

	public void setCdTpTitularidade(BigDecimal cdTpTitularidade) {
		this.cdTpTitularidade = cdTpTitularidade;
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

    @Override
	public String toString() {
		return "idIntegracao=" + idIntegracao +" cdContrato=" + cdContrato + " cdPlano=" + cdPlano + " nome=" + nome + " nrIdentClienteEmpresa="
				+ nrIdentClienteEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carteira == null) ? 0 : carteira.hashCode());
		result = prime * result + ((cdCartao == null) ? 0 : cdCartao.hashCode());
		result = prime * result + ((cdCentroCusto == null) ? 0 : cdCentroCusto.hashCode());
		result = prime * result + ((cdCep == null) ? 0 : cdCep.hashCode());
		result = prime * result + ((cdContrato == null) ? 0 : cdContrato.hashCode());
		result = prime * result + ((cdContratoEspecifico == null) ? 0 : cdContratoEspecifico.hashCode());
		result = prime * result + ((cdOperadorAlteracao == null) ? 0 : cdOperadorAlteracao.hashCode());
		result = prime * result + ((cdOperadorCadastro == null) ? 0 : cdOperadorCadastro.hashCode());
		result = prime * result + ((cdPlano == null) ? 0 : cdPlano.hashCode());
		result = prime * result + ((cdSituacaoCartao == null) ? 0 : cdSituacaoCartao.hashCode());
		result = prime * result + ((cdTpAcao == null) ? 0 : cdTpAcao.hashCode());
		result = prime * result + ((cdTpEndereco == null) ? 0 : cdTpEndereco.hashCode());
		result = prime * result + ((cdTpTelefone == null) ? 0 : cdTpTelefone.hashCode());
		result = prime * result + ((cdTpTitularidade == null) ? 0 : cdTpTitularidade.hashCode());
		result = prime * result + ((cdUf == null) ? 0 : cdUf.hashCode());
		result = prime * result + ((cdsAgencia == null) ? 0 : cdsAgencia.hashCode());
		result = prime * result + ((cdsBanco == null) ? 0 : cdsBanco.hashCode());
		result = prime * result + ((cdsBeneficio == null) ? 0 : cdsBeneficio.hashCode());
		result = prime * result + ((cdsCentroCusto == null) ? 0 : cdsCentroCusto.hashCode());
		result = prime * result + ((cdsCodOrganograma == null) ? 0 : cdsCodOrganograma.hashCode());
		result = prime * result + ((cdsContaCorrente == null) ? 0 : cdsContaCorrente.hashCode());
		result = prime * result + ((cdsCustoLotacao == null) ? 0 : cdsCustoLotacao.hashCode());
		result = prime * result + ((cdsDsOrganograma == null) ? 0 : cdsDsOrganograma.hashCode());
		result = prime * result + ((cdsFilialCliente == null) ? 0 : cdsFilialCliente.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((dsBairro == null) ? 0 : dsBairro.hashCode());
		result = prime * result + ((dsCidade == null) ? 0 : dsCidade.hashCode());
		result = prime * result + ((dsComplemento == null) ? 0 : dsComplemento.hashCode());
		result = prime * result + ((dsEmail == null) ? 0 : dsEmail.hashCode());
		result = prime * result + ((dsEndereco == null) ? 0 : dsEndereco.hashCode());
		result = prime * result + ((dsObservacao == null) ? 0 : dsObservacao.hashCode());
		result = prime * result + ((dtCadastro == null) ? 0 : dtCadastro.hashCode());
		result = prime * result + ((dtFimVigenciaCartao == null) ? 0 : dtFimVigenciaCartao.hashCode());
		result = prime * result + ((dtIniVigenciaCartao == null) ? 0 : dtIniVigenciaCartao.hashCode());
		result = prime * result + ((dtUltAlteracao == null) ? 0 : dtUltAlteracao.hashCode());
		result = prime * result + ((flCartaoTitular == null) ? 0 : flCartaoTitular.hashCode());
		result = prime * result + ((grauParentesco == null) ? 0 : grauParentesco.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idClienteTitular == null) ? 0 : idClienteTitular.hashCode());
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		result = prime * result + ((idIntegracao == null) ? 0 : idIntegracao.hashCode());
		result = prime * result + ((limite == null) ? 0 : limite.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nrCrm == null) ? 0 : nrCrm.hashCode());
		result = prime * result + ((nrEndereco == null) ? 0 : nrEndereco.hashCode());
		result = prime * result + ((nrIdentClienteEmpresa == null) ? 0 : nrIdentClienteEmpresa.hashCode());
		result = prime * result + ((nrPrefixo == null) ? 0 : nrPrefixo.hashCode());
		result = prime * result + ((nrRg == null) ? 0 : nrRg.hashCode());
		result = prime * result + ((nrTelefone == null) ? 0 : nrTelefone.hashCode());
		result = prime * result + ((nrVia == null) ? 0 : nrVia.hashCode());
		result = prime * result + ((operacao == null) ? 0 : operacao.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((subEstipulante == null) ? 0 : subEstipulante.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((vlSublimite == null) ? 0 : vlSublimite.hashCode());
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
		IntegracaoDetalheWebServiceRD other = (IntegracaoDetalheWebServiceRD) obj;
		if (carteira == null) {
			if (other.carteira != null)
				return false;
		} else if (!carteira.equals(other.carteira))
			return false;
		if (cdCartao == null) {
			if (other.cdCartao != null)
				return false;
		} else if (!cdCartao.equals(other.cdCartao))
			return false;
		if (cdCentroCusto == null) {
			if (other.cdCentroCusto != null)
				return false;
		} else if (!cdCentroCusto.equals(other.cdCentroCusto))
			return false;
		if (cdCep == null) {
			if (other.cdCep != null)
				return false;
		} else if (!cdCep.equals(other.cdCep))
			return false;
		if (cdContrato == null) {
			if (other.cdContrato != null)
				return false;
		} else if (!cdContrato.equals(other.cdContrato))
			return false;
		if (cdContratoEspecifico == null) {
			if (other.cdContratoEspecifico != null)
				return false;
		} else if (!cdContratoEspecifico.equals(other.cdContratoEspecifico))
			return false;
		if (cdOperadorAlteracao == null) {
			if (other.cdOperadorAlteracao != null)
				return false;
		} else if (!cdOperadorAlteracao.equals(other.cdOperadorAlteracao))
			return false;
		if (cdOperadorCadastro == null) {
			if (other.cdOperadorCadastro != null)
				return false;
		} else if (!cdOperadorCadastro.equals(other.cdOperadorCadastro))
			return false;
		if (cdPlano == null) {
			if (other.cdPlano != null)
				return false;
		} else if (!cdPlano.equals(other.cdPlano))
			return false;
		if (cdSituacaoCartao == null) {
			if (other.cdSituacaoCartao != null)
				return false;
		} else if (!cdSituacaoCartao.equals(other.cdSituacaoCartao))
			return false;
		if (cdTpAcao == null) {
			if (other.cdTpAcao != null)
				return false;
		} else if (!cdTpAcao.equals(other.cdTpAcao))
			return false;
		if (cdTpEndereco == null) {
			if (other.cdTpEndereco != null)
				return false;
		} else if (!cdTpEndereco.equals(other.cdTpEndereco))
			return false;
		if (cdTpTelefone == null) {
			if (other.cdTpTelefone != null)
				return false;
		} else if (!cdTpTelefone.equals(other.cdTpTelefone))
			return false;
		if (cdTpTitularidade == null) {
			if (other.cdTpTitularidade != null)
				return false;
		} else if (!cdTpTitularidade.equals(other.cdTpTitularidade))
			return false;
		if (cdUf == null) {
			if (other.cdUf != null)
				return false;
		} else if (!cdUf.equals(other.cdUf))
			return false;
		if (cdsAgencia == null) {
			if (other.cdsAgencia != null)
				return false;
		} else if (!cdsAgencia.equals(other.cdsAgencia))
			return false;
		if (cdsBanco == null) {
			if (other.cdsBanco != null)
				return false;
		} else if (!cdsBanco.equals(other.cdsBanco))
			return false;
		if (cdsBeneficio == null) {
			if (other.cdsBeneficio != null)
				return false;
		} else if (!cdsBeneficio.equals(other.cdsBeneficio))
			return false;
		if (cdsCentroCusto == null) {
			if (other.cdsCentroCusto != null)
				return false;
		} else if (!cdsCentroCusto.equals(other.cdsCentroCusto))
			return false;
		if (cdsCodOrganograma == null) {
			if (other.cdsCodOrganograma != null)
				return false;
		} else if (!cdsCodOrganograma.equals(other.cdsCodOrganograma))
			return false;
		if (cdsContaCorrente == null) {
			if (other.cdsContaCorrente != null)
				return false;
		} else if (!cdsContaCorrente.equals(other.cdsContaCorrente))
			return false;
		if (cdsCustoLotacao == null) {
			if (other.cdsCustoLotacao != null)
				return false;
		} else if (!cdsCustoLotacao.equals(other.cdsCustoLotacao))
			return false;
		if (cdsDsOrganograma == null) {
			if (other.cdsDsOrganograma != null)
				return false;
		} else if (!cdsDsOrganograma.equals(other.cdsDsOrganograma))
			return false;
		if (cdsFilialCliente == null) {
			if (other.cdsFilialCliente != null)
				return false;
		} else if (!cdsFilialCliente.equals(other.cdsFilialCliente))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (dsBairro == null) {
			if (other.dsBairro != null)
				return false;
		} else if (!dsBairro.equals(other.dsBairro))
			return false;
		if (dsCidade == null) {
			if (other.dsCidade != null)
				return false;
		} else if (!dsCidade.equals(other.dsCidade))
			return false;
		if (dsComplemento == null) {
			if (other.dsComplemento != null)
				return false;
		} else if (!dsComplemento.equals(other.dsComplemento))
			return false;
		if (dsEmail == null) {
			if (other.dsEmail != null)
				return false;
		} else if (!dsEmail.equals(other.dsEmail))
			return false;
		if (dsEndereco == null) {
			if (other.dsEndereco != null)
				return false;
		} else if (!dsEndereco.equals(other.dsEndereco))
			return false;
		if (dsObservacao == null) {
			if (other.dsObservacao != null)
				return false;
		} else if (!dsObservacao.equals(other.dsObservacao))
			return false;
		if (dtCadastro == null) {
			if (other.dtCadastro != null)
				return false;
		} else if (!dtCadastro.equals(other.dtCadastro))
			return false;
		if (dtFimVigenciaCartao == null) {
			if (other.dtFimVigenciaCartao != null)
				return false;
		} else if (!dtFimVigenciaCartao.equals(other.dtFimVigenciaCartao))
			return false;
		if (dtIniVigenciaCartao == null) {
			if (other.dtIniVigenciaCartao != null)
				return false;
		} else if (!dtIniVigenciaCartao.equals(other.dtIniVigenciaCartao))
			return false;
		if (dtUltAlteracao == null) {
			if (other.dtUltAlteracao != null)
				return false;
		} else if (!dtUltAlteracao.equals(other.dtUltAlteracao))
			return false;
		if (flCartaoTitular == null) {
			if (other.flCartaoTitular != null)
				return false;
		} else if (!flCartaoTitular.equals(other.flCartaoTitular))
			return false;
		if (grauParentesco == null) {
			if (other.grauParentesco != null)
				return false;
		} else if (!grauParentesco.equals(other.grauParentesco))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idClienteTitular == null) {
			if (other.idClienteTitular != null)
				return false;
		} else if (!idClienteTitular.equals(other.idClienteTitular))
			return false;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		if (idIntegracao == null) {
			if (other.idIntegracao != null)
				return false;
		} else if (!idIntegracao.equals(other.idIntegracao))
			return false;
		if (limite == null) {
			if (other.limite != null)
				return false;
		} else if (!limite.equals(other.limite))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nrCrm == null) {
			if (other.nrCrm != null)
				return false;
		} else if (!nrCrm.equals(other.nrCrm))
			return false;
		if (nrEndereco == null) {
			if (other.nrEndereco != null)
				return false;
		} else if (!nrEndereco.equals(other.nrEndereco))
			return false;
		if (nrIdentClienteEmpresa == null) {
			if (other.nrIdentClienteEmpresa != null)
				return false;
		} else if (!nrIdentClienteEmpresa.equals(other.nrIdentClienteEmpresa))
			return false;
		if (nrPrefixo == null) {
			if (other.nrPrefixo != null)
				return false;
		} else if (!nrPrefixo.equals(other.nrPrefixo))
			return false;
		if (nrRg == null) {
			if (other.nrRg != null)
				return false;
		} else if (!nrRg.equals(other.nrRg))
			return false;
		if (nrTelefone == null) {
			if (other.nrTelefone != null)
				return false;
		} else if (!nrTelefone.equals(other.nrTelefone))
			return false;
		if (nrVia == null) {
			if (other.nrVia != null)
				return false;
		} else if (!nrVia.equals(other.nrVia))
			return false;
		if (operacao == null) {
			if (other.operacao != null)
				return false;
		} else if (!operacao.equals(other.operacao))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (subEstipulante == null) {
			if (other.subEstipulante != null)
				return false;
		} else if (!subEstipulante.equals(other.subEstipulante))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (vlSublimite == null) {
			if (other.vlSublimite != null)
				return false;
		} else if (!vlSublimite.equals(other.vlSublimite))
			return false;
		return true;
	}

	

}
