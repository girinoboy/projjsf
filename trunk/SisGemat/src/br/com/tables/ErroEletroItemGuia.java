package br.com.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.ps_erro_eletro_item_guia")
public class ErroEletroItemGuia {

	@Id //Define que a variavel abaixo será nosso ID no banco
	@GeneratedValue(strategy= GenerationType.IDENTITY) // Gera um id único para cada registro de cliente
	@Column(name="seq_erro_eletro_item_guia", nullable=false ) // define que o nome da coluna, e se o campo sera nulo
	private Integer seqErroEletroItemGuia ;
	@Column(name="desc_erro_eletro_item_guia", nullable=false,length=256)  // define que o nome da coluna, e o tamanho que terá no banco
	private String  descErroEletroItemGuia ;
	@ManyToOne
	@JoinColumn(name="seq_eletro_item_guia", referencedColumnName = "seq_eletro_item_guia")
	private EletroItemGuia  eletroItemGuia;

	public ErroEletroItemGuia() {}

	/**
	 * @return the seqErroEletroItemGuia
	 */
	public Integer getSeqErroEletroItemGuia() {
		return seqErroEletroItemGuia;
	}

	/**
	 * @param seqErroEletroItemGuia the seqErroEletroItemGuia to set
	 */
	public void setSeqErroEletroItemGuia(Integer seqErroEletroItemGuia) {
		this.seqErroEletroItemGuia = seqErroEletroItemGuia;
	}

	/**
	 * @return the descErroEletroItemGuia
	 */
	public String getDescErroEletroItemGuia() {
		return descErroEletroItemGuia;
	}

	/**
	 * @param descErroEletroItemGuia the descErroEletroItemGuia to set
	 */
	public void setDescErroEletroItemGuia(String descErroEletroItemGuia) {
		this.descErroEletroItemGuia = descErroEletroItemGuia;
	}

	/**
	 * @return the seqEletroItemGuia
	 */
	public EletroItemGuia getEletroItemGuia() {
		return eletroItemGuia;
	}

	/**
	 * @param eletroItemGuia the seqEletroItemGuia to set
	 */
	public void setEletroItemGuia(EletroItemGuia eletroItemGuia) {
		this.eletroItemGuia = eletroItemGuia;
	}

}
