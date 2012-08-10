package br.com.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "dbo.ps_eletro_guia")
public class EletroGuia {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="seq_eletro_guia", nullable=false )
	private Integer seqEletroGuia;
	@Column(name="dt_guia", nullable=false )
	private Date   dtGuia;
	@Column(name="tipo_doc_profissional", length=5)
	private String   tipoDocProfissional;
	@Column(name="num_doc_profissional", length=20)
	private String   numDocProfissional;
	@Column(name="uf_doc_profissional", length=5)
	private String   ufDocProfissional;
	@Column(name="nome_profissional", length=70)
	private String   nomeProfissional;
	@Column(name="tipo_doc_profissional_solicitante", length=5)
	private String   tipoDocProfissionalSolicitante;
	@Column(name="num_doc_profissional_solicitante", length=20)
	private String   numDocProfissionalSolicitante;
	@Column(name="uf_doc_profissional_solicitante", length=5)
	private String   ufDocProfissionalSolicitante;
	@Column(name="nome_profissional_solicitante", length=70)
	private String   nomeProfissionalSolicitante;
	@Column(name="num_matricula_proser", nullable=false)
	private Integer   numMatriculaProser;
	@Column(name="num_digito_matricula", nullable=false)
	private Integer   numDigitoMatricula;
	@Column(name="nome_beneficiario", nullable=false , length=50)
	private String   nomeBeneficiario;
	@Column(name="cod_internacao")
	private Integer   codInternacao;
	@ManyToOne
	@JoinColumn(name="seq_eletro_fatura", referencedColumnName = "seq_eletro_fatura")
	private EletroFatura   eletroFatura;
	@Column(name="seq_guia")
	private Integer   seqGuia;
	@Column(name="cod_autorizacao_prestador_servico")
	private Integer   codAutorizacaoPrestadorServico;
	@Column(name="desc_senha_autorizacao_prestador_servico", length=256)
	private String   descSenhaAutorizacaoPrestadorServico;

	public EletroGuia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the seqEletroGuia
	 */
	public Integer getSeqEletroGuia() {
		return seqEletroGuia;
	}

	/**
	 * @param seqEletroGuia the seqEletroGuia to set
	 */
	public void setSeqEletroGuia(Integer seqEletroGuia) {
		this.seqEletroGuia = seqEletroGuia;
	}

	/**
	 * @return the dtGuia
	 */
	public Date getDtGuia() {
		return dtGuia;
	}

	/**
	 * @param dtGuia the dtGuia to set
	 */
	public void setDtGuia(Date dtGuia) {
		this.dtGuia = dtGuia;
	}

	/**
	 * @return the tipoDocProfissional
	 */
	public String getTipoDocProfissional() {
		return tipoDocProfissional;
	}

	/**
	 * @param tipoDocProfissional the tipoDocProfissional to set
	 */
	public void setTipoDocProfissional(String tipoDocProfissional) {
		this.tipoDocProfissional = tipoDocProfissional;
	}

	/**
	 * @return the numDocProfissional
	 */
	public String getNumDocProfissional() {
		return numDocProfissional;
	}

	/**
	 * @param numDocProfissional the numDocProfissional to set
	 */
	public void setNumDocProfissional(String numDocProfissional) {
		this.numDocProfissional = numDocProfissional;
	}

	/**
	 * @return the ufDocProfissional
	 */
	public String getUfDocProfissional() {
		return ufDocProfissional;
	}

	/**
	 * @param ufDocProfissional the ufDocProfissional to set
	 */
	public void setUfDocProfissional(String ufDocProfissional) {
		this.ufDocProfissional = ufDocProfissional;
	}

	/**
	 * @return the nomeProfissional
	 */
	public String getNomeProfissional() {
		return nomeProfissional;
	}

	/**
	 * @param nomeProfissional the nomeProfissional to set
	 */
	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	/**
	 * @return the tipoDocProfissionalSolicitante
	 */
	public String getTipoDocProfissionalSolicitante() {
		return tipoDocProfissionalSolicitante;
	}

	/**
	 * @param tipoDocProfissionalSolicitante the tipoDocProfissionalSolicitante to set
	 */
	public void setTipoDocProfissionalSolicitante(
			String tipoDocProfissionalSolicitante) {
		this.tipoDocProfissionalSolicitante = tipoDocProfissionalSolicitante;
	}

	/**
	 * @return the numDocProfissionalSolicitante
	 */
	public String getNumDocProfissionalSolicitante() {
		return numDocProfissionalSolicitante;
	}

	/**
	 * @param numDocProfissionalSolicitante the numDocProfissionalSolicitante to set
	 */
	public void setNumDocProfissionalSolicitante(
			String numDocProfissionalSolicitante) {
		this.numDocProfissionalSolicitante = numDocProfissionalSolicitante;
	}

	/**
	 * @return the ufDocProfissionalSolicitante
	 */
	public String getUfDocProfissionalSolicitante() {
		return ufDocProfissionalSolicitante;
	}

	/**
	 * @param ufDocProfissionalSolicitante the ufDocProfissionalSolicitante to set
	 */
	public void setUfDocProfissionalSolicitante(String ufDocProfissionalSolicitante) {
		this.ufDocProfissionalSolicitante = ufDocProfissionalSolicitante;
	}

	/**
	 * @return the nomeProfissionalSolicitante
	 */
	public String getNomeProfissionalSolicitante() {
		return nomeProfissionalSolicitante;
	}

	/**
	 * @param nomeProfissionalSolicitante the nomeProfissionalSolicitante to set
	 */
	public void setNomeProfissionalSolicitante(String nomeProfissionalSolicitante) {
		this.nomeProfissionalSolicitante = nomeProfissionalSolicitante;
	}

	/**
	 * @return the numMatriculaProser
	 */
	public Integer getNumMatriculaProser() {
		return numMatriculaProser;
	}

	/**
	 * @param numMatriculaProser the numMatriculaProser to set
	 */
	public void setNumMatriculaProser(Integer numMatriculaProser) {
		this.numMatriculaProser = numMatriculaProser;
	}

	/**
	 * @return the numDigitoMatricula
	 */
	public Integer getNumDigitoMatricula() {
		return numDigitoMatricula;
	}

	/**
	 * @param numDigitoMatricula the numDigitoMatricula to set
	 */
	public void setNumDigitoMatricula(Integer numDigitoMatricula) {
		this.numDigitoMatricula = numDigitoMatricula;
	}

	/**
	 * @return the nomeBeneficiario
	 */
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	/**
	 * @param nomeBeneficiario the nomeBeneficiario to set
	 */
	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	/**
	 * @return the codInternacao
	 */
	public Integer getCodInternacao() {
		return codInternacao;
	}

	/**
	 * @param codInternacao the codInternacao to set
	 */
	public void setCodInternacao(Integer codInternacao) {
		this.codInternacao = codInternacao;
	}

	/**
	 * @return the eletroFatura
	 */
	public EletroFatura getEletroFatura() {
		return eletroFatura;
	}

	/**
	 * @param eletroFatura the eletroFatura to set
	 */
	public void setEletroFatura(EletroFatura eletroFatura) {
		this.eletroFatura = eletroFatura;
	}

	/**
	 * @return the seqGuia
	 */
	public Integer getSeqGuia() {
		return seqGuia;
	}

	/**
	 * @param seqGuia the seqGuia to set
	 */
	public void setSeqGuia(Integer seqGuia) {
		this.seqGuia = seqGuia;
	}

	/**
	 * @return the codAutorizacaoPrestadorServico
	 */
	public Integer getCodAutorizacaoPrestadorServico() {
		return codAutorizacaoPrestadorServico;
	}

	/**
	 * @param codAutorizacaoPrestadorServico the codAutorizacaoPrestadorServico to set
	 */
	public void setCodAutorizacaoPrestadorServico(
			Integer codAutorizacaoPrestadorServico) {
		this.codAutorizacaoPrestadorServico = codAutorizacaoPrestadorServico;
	}

	/**
	 * @return the descSenhaAutorizacaoPrestadorServico
	 */
	public String getDescSenhaAutorizacaoPrestadorServico() {
		return descSenhaAutorizacaoPrestadorServico;
	}

	/**
	 * @param descSenhaAutorizacaoPrestadorServico the descSenhaAutorizacaoPrestadorServico to set
	 */
	public void setDescSenhaAutorizacaoPrestadorServico(
			String descSenhaAutorizacaoPrestadorServico) {
		this.descSenhaAutorizacaoPrestadorServico = descSenhaAutorizacaoPrestadorServico;
	}

}
