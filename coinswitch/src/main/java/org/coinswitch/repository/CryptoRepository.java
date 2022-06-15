package org.coinswitch.repository;

import java.util.List;

import org.coinswitch.entities.CryptoCurrency;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<CryptoCurrency, Integer> {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(CryptoRepository.class);

	
	@Query("SELECT cc FROM CryptoCurrency cc WHERE cc.cryptoSymbol LIKE %:cryptoSymbol%")
	public List<CryptoCurrency> findBycryptoSymbol(@Param("cryptoSymbol") String cryptoSymbol);
	

}
