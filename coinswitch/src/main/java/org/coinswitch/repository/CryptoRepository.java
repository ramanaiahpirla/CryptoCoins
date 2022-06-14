package org.coinswitch.repository;

import java.util.List;

import org.coinswitch.entities.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<CryptoCurrency, Integer> {

	@Query("SELECT crypto_symbol FROM crypto_currency cc WHERE cc.crypto_symbol LIKE %:crypto_symbol%")
	public List<CryptoCurrency> findBycryptoSymbol(String crypto_symbol);
	

}
