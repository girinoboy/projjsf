package br.com.tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.ps_eletro_item_guia")
public class EletroItemGuia {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY) // Gera um id único para cada registro de cliente
	@Column(name="seq_eletro_item_guia", nullable=false ) 
	private Integer seqEletroItemGuia ;
	@Column(name="tipo_item_atendimento", nullable=false,length=5)
	private String  tipoItemAtendimento;
	@Column(name="num_identificador_item", nullable=true,length=20)
	private String  numIdentificadorItem;
	@Column(name="tipo_insumo_cirurgia", nullable=true,length=16)
	private String  tipoInsumoCirurgia;
	@Column(name="cod_autorizacao_pm", nullable=true)
	private Integer codAutorizacaoPm;
	@Column(name="qtd_solicitada", nullable=false)
	private Integer qtdSolicitada;
	@Column(name="vlr_unitario_solicitado", nullable=false)
	private Double  vlrUnitarioSolicitado;
	@Column(name="vlr_filme_unitario_solicitado", nullable=true)
	private Double  vlrFilmeUnitarioSolicitado;
	@Column(name="ind_fracao", nullable=true,length=5)
	private String  indFracao;
	@Column(name="ind_spect", nullable=true,length=5)
	private String  indSpect;
	@Column(name="seq_item_guia", nullable=true)
	private Integer seqItemGuia;
	@ManyToOne(cascade = {CascadeType.REFRESH},  
	           fetch= FetchType.LAZY,  
	           targetEntity=EletroGuia.class) 
	@JoinColumn(name="seq_eletro_guia", referencedColumnName = "seq_eletro_guia")
	private EletroGuia eletroGuia;
	@Column(name="ind_estorno", nullable=true,length=5)
	private String  indEstorno;
	@Column(name="desc_tipo_sh", nullable=true,length=15)
	private String  descTipoSh;
	@Column(name="desc_tabela_preco", nullable=true,length=10)
	private String  descTabelaPreco;
	@Column(name="desc_eletro_item_guia", nullable=true,length=256)
	private String  descEletroItemGuia;
	@Column(name="desc_senha_autorizacao_gamasaude", nullable=true,length=50)
	private String  descSenhaAutorizacaoGamasaude;
	@Column(name="vlr_inss", nullable=true)
	private Double  vlrInss;

	public EletroItemGuia() {}

	/**
	 * @return the seqEletroItemGuia
	 */
	public Integer getSeqEletroItemGuia() {
		return seqEletroItemGuia;
	}

	/**
	 * @param seqEletroItemGuia the seqEletroItemGuia to set
	 */
	public void setSeqEletroItemGuia(Integer seqEletroItemGuia) {
		this.seqEletroItemGuia = seqEletroItemGuia;
	}

	/**
	 * @return the tipoItemAtendimento
	 */
	public String getTipoItemAtendimento() {
		return tipoItemAtendimento;
	}

	/**
	 * @param tipoItemAtendimento the tipoItemAtendimento to set
	 */
	public void setTipoItemAtendimento(String tipoItemAtendimento) {
		this.tipoItemAtendimento = tipoItemAtendimento;
	}

	/**
	 * @return the numIdentificadorItem
	 */
	public String getNumIdentificadorItem() {
		return numIdentificadorItem;
	}

	/**
	 * @param numIdentificadorItem the numIdentificadorItem to set
	 */
	public void setNumIdentificadorItem(String numIdentificadorItem) {
		this.numIdentificadorItem = numIdentificadorItem;
	}

	/**
	 * @return the tipoInsumoCirurgia
	 */
	public String getTipoInsumoCirurgia() {
		return tipoInsumoCirurgia;
	}

	/**
	 * @param tipoInsumoCirurgia the tipoInsumoCirurgia to set
	 */
	public void setTipoInsumoCirurgia(String tipoInsumoCirurgia) {
		this.tipoInsumoCirurgia = tipoInsumoCirurgia;
	}

	/**
	 * @return the codAutorizacaoPm
	 */
	public Integer getCodAutorizacaoPm() {
		return codAutorizacaoPm;
	}

	/**
	 * @param codAutorizacaoPm the codAutorizacaoPm to set
	 */
	public void setCodAutorizacaoPm(Integer codAutorizacaoPm) {
		this.codAutorizacaoPm = codAutorizacaoPm;
	}

	/**
	 * @return the qtdSolicitada
	 */
	public Integer getQtdSolicitada() {
		return qtdSolicitada;
	}

	/**
	 * @param qtdSolicitada the qtdSolicitada to set
	 */
	public void setQtdSolicitada(Integer qtdSolicitada) {
		this.qtdSolicitada = qtdSolicitada;
	}

	/**
	 * @return the vlrUnitarioSolicitado
	 */
	public Double getVlrUnitarioSolicitado() {
		return vlrUnitarioSolicitado;
	}

	/**
	 * @param vlrUnitarioSolicitado the vlrUnitarioSolicitado to set
	 */
	public void setVlrUnitarioSolicitado(Double vlrUnitarioSolicitado) {
		this.vlrUnitarioSolicitado = vlrUnitarioSolicitado;
	}

	/**
	 * @return the vlrFilmeUnitarioSolicitado
	 */
	public Double getVlrFilmeUnitarioSolicitado() {
		return vlrFilmeUnitarioSolicitado;
	}

	/**
	 * @param vlrFilmeUnitarioSolicitado the vlrFilmeUnitarioSolicitado to set
	 */
	public void setVlrFilmeUnitarioSolicitado(Double vlrFilmeUnitarioSolicitado) {
		this.vlrFilmeUnitarioSolicitado = vlrFilmeUnitarioSolicitado;
	}

	/**
	 * @return the indFracao
	 */
	public String getIndFracao() {
		return indFracao;
	}

	/**
	 * @param indFracao the indFracao to set
	 */
	public void setIndFracao(String indFracao) {
		this.indFracao = indFracao;
	}

	/**
	 * @return the indSpect
	 */
	public String getIndSpect() {
		return indSpect;
	}

	/**
	 * @param indSpect the indSpect to set
	 */
	public void setIndSpect(String indSpect) {
		this.indSpect = indSpect;
	}

	/**
	 * @return the seqItemGuia
	 */
	public Integer getSeqItemGuia() {
		return seqItemGuia;
	}

	/**
	 * @param seqItemGuia the seqItemGuia to set
	 */
	public void setSeqItemGuia(Integer seqItemGuia) {
		this.seqItemGuia = seqItemGuia;
	}

	/**
	 * @return the seqEletroGuia
	 */
	public EletroGuia getEletroGuia() {
		return eletroGuia;
	}

	/**
	 * @param eletroGuia the seqEletroGuia to set
	 */
	public void setEletroGuia(EletroGuia eletroGuia) {
		this.eletroGuia = eletroGuia;
	}

	/**
	 * @return the indEstorno
	 */
	public String getIndEstorno() {
		return indEstorno;
	}

	/**
	 * @param indEstorno the indEstorno to set
	 */
	public void setIndEstorno(String indEstorno) {
		this.indEstorno = indEstorno;
	}

	/**
	 * @return the descTipoSh
	 */
	public String getDescTipoSh() {
		return descTipoSh;
	}

	/**
	 * @param descTipoSh the descTipoSh to set
	 */
	public void setDescTipoSh(String descTipoSh) {
		this.descTipoSh = descTipoSh;
	}

	/**
	 * @return the descTabelaPreco
	 */
	public String getDescTabelaPreco() {
		return descTabelaPreco;
	}

	/**
	 * @param descTabelaPreco the descTabelaPreco to set
	 */
	public void setDescTabelaPreco(String descTabelaPreco) {
		this.descTabelaPreco = descTabelaPreco;
	}

	/**
	 * @return the descEletroItemGuia
	 */
	public String getDescEletroItemGuia() {
		return descEletroItemGuia;
	}

	/**
	 * @param descEletroItemGuia the descEletroItemGuia to set
	 */
	public void setDescEletroItemGuia(String descEletroItemGuia) {
		this.descEletroItemGuia = descEletroItemGuia;
	}

	/**
	 * @return the descSenhaAutorizacaoGamasaude
	 */
	public String getDescSenhaAutorizacaoGamasaude() {
		return descSenhaAutorizacaoGamasaude;
	}

	/**
	 * @param descSenhaAutorizacaoGamasaude the descSenhaAutorizacaoGamasaude to set
	 */
	public void setDescSenhaAutorizacaoGamasaude(
			String descSenhaAutorizacaoGamasaude) {
		this.descSenhaAutorizacaoGamasaude = descSenhaAutorizacaoGamasaude;
	}

	/**
	 * @return the vlrInss
	 */
	public Double getVlrInss() {
		return vlrInss;
	}

	/**
	 * @param vlrInss the vlrInss to set
	 */
	public void setVlrInss(Double vlrInss) {
		this.vlrInss = vlrInss;
	}

}
