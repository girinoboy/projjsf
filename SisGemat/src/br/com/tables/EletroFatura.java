package br.com.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="dbo.ps_eletro_fatura")
public class EletroFatura {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="seq_eletro_fatura", nullable=false )
	private Integer seqEletroFatura;
	@Column(name="num_digito_eletro_fatura")
	private Integer   numDigitoEletroFatura;
	@Column(name="dt_envio_arquivo", nullable=false )
	private Date   dtEnvioArquivo;
	@Column(name="num_fatura", nullable=false, length=20)
	private String   numFatura;
	@Column(name="dt_fatura")
	private Date   dtFatura;
	@Column(name="vlr_proposto_fatura", nullable=false)
	private Double   vlrPropostoFatura;
	@Column(name="num_nf", length=20)
	private String   numNf;
	@Column(name="vlr_nf")
	private Double   vlrNf;
	@Column(name="dt_emissao_nf")
	private Date   dtEmissaoNf;
	@Column(name="ind_fora_bsb", length=5)
	private String   indForaBsb;
	@Column(name="num_percent_taxa_adm")
	private Double   numPercentTaxaAdm;
	@Column(name="num_cnpj", nullable=false, length=14)
	private Character   numCnpj;
	@Column(name="seq_processo")
	private Integer   seqProcesso;

	public EletroFatura() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the seqEletroFatura
	 */
	public Integer getSeqEletroFatura() {
		return seqEletroFatura;
	}

	/**
	 * @param seqEletroFatura the seqEletroFatura to set
	 */
	public void setSeqEletroFatura(Integer seqEletroFatura) {
		this.seqEletroFatura = seqEletroFatura;
	}

	/**
	 * @return the numDigitoEletroFatura
	 */
	public Integer getNumDigitoEletroFatura() {
		return numDigitoEletroFatura;
	}

	/**
	 * @param numDigitoEletroFatura the numDigitoEletroFatura to set
	 */
	public void setNumDigitoEletroFatura(Integer numDigitoEletroFatura) {
		this.numDigitoEletroFatura = numDigitoEletroFatura;
	}

	/**
	 * @return the dtEnvioArquivo
	 */
	public Date getDtEnvioArquivo() {
		return dtEnvioArquivo;
	}

	/**
	 * @param dtEnvioArquivo the dtEnvioArquivo to set
	 */
	public void setDtEnvioArquivo(Date dtEnvioArquivo) {
		this.dtEnvioArquivo = dtEnvioArquivo;
	}

	/**
	 * @return the numFatura
	 */
	public String getNumFatura() {
		return numFatura;
	}

	/**
	 * @param numFatura the numFatura to set
	 */
	public void setNumFatura(String numFatura) {
		this.numFatura = numFatura;
	}

	/**
	 * @return the dtFatura
	 */
	public Date getDtFatura() {
		return dtFatura;
	}

	/**
	 * @param dtFatura the dtFatura to set
	 */
	public void setDtFatura(Date dtFatura) {
		this.dtFatura = dtFatura;
	}

	/**
	 * @return the vlrPropostoFatura
	 */
	public Double getVlrPropostoFatura() {
		return vlrPropostoFatura;
	}

	/**
	 * @param vlrPropostoFatura the vlrPropostoFatura to set
	 */
	public void setVlrPropostoFatura(Double vlrPropostoFatura) {
		this.vlrPropostoFatura = vlrPropostoFatura;
	}

	/**
	 * @return the numNf
	 */
	public String getNumNf() {
		return numNf;
	}

	/**
	 * @param numNf the numNf to set
	 */
	public void setNumNf(String numNf) {
		this.numNf = numNf;
	}

	/**
	 * @return the vlrNf
	 */
	public Double getVlrNf() {
		return vlrNf;
	}

	/**
	 * @param vlrNf the vlrNf to set
	 */
	public void setVlrNf(Double vlrNf) {
		this.vlrNf = vlrNf;
	}

	/**
	 * @return the dtEmissaoNf
	 */
	public Date getDtEmissaoNf() {
		return dtEmissaoNf;
	}

	/**
	 * @param dtEmissaoNf the dtEmissaoNf to set
	 */
	public void setDtEmissaoNf(Date dtEmissaoNf) {
		this.dtEmissaoNf = dtEmissaoNf;
	}

	/**
	 * @return the indForaBsb
	 */
	public String getIndForaBsb() {
		return indForaBsb;
	}

	/**
	 * @param indForaBsb the indForaBsb to set
	 */
	public void setIndForaBsb(String indForaBsb) {
		this.indForaBsb = indForaBsb;
	}

	/**
	 * @return the numPercentTaxaAdm
	 */
	public Double getNumPercentTaxaAdm() {
		return numPercentTaxaAdm;
	}

	/**
	 * @param numPercentTaxaAdm the numPercentTaxaAdm to set
	 */
	public void setNumPercentTaxaAdm(Double numPercentTaxaAdm) {
		this.numPercentTaxaAdm = numPercentTaxaAdm;
	}

	/**
	 * @return the numCnpj
	 */
	public Character getNumCnpj() {
		return numCnpj;
	}

	/**
	 * @param numCnpj the numCnpj to set
	 */
	public void setNumCnpj(Character numCnpj) {
		this.numCnpj = numCnpj;
	}

	/**
	 * @return the seqProcesso
	 */
	public Integer getSeqProcesso() {
		return seqProcesso;
	}

	/**
	 * @param seqProcesso the seqProcesso to set
	 */
	public void setSeqProcesso(Integer seqProcesso) {
		this.seqProcesso = seqProcesso;
	}

}
