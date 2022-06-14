package org.coinswitch.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CRYPTO_CURRENCY")
public class CryptoCurrency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4793657457523267061L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CRYPTO_ID")
	private Integer cryptoId;
	
	@Column(name = "CRYPTO_NAME")
	private String cryptoName;
	
	@Column(name = "CRYPTO_SYMBOL")
	private String cryptoSymbol;
	
	
	public Integer getCryptoId() {
		return cryptoId;
	}
	public void setCryptoId(Integer cryptoId) {
		this.cryptoId = cryptoId;
	}
	public String getCryptoName() {
		return cryptoName;
	}
	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}
	public String getCryptoSymbol() {
		return cryptoSymbol;
	}
	public void setCryptoSymbol(String cryptoSymbol) {
		this.cryptoSymbol = cryptoSymbol;
	}
	public CryptoCurrency(Integer cryptoId, String cryptoName, String cryptoSymbol) {
		super();
		this.cryptoId = cryptoId;
		this.cryptoName = cryptoName;
		this.cryptoSymbol = cryptoSymbol;
	}
	public CryptoCurrency() {
		super();
	}
	
	
	
	

}
