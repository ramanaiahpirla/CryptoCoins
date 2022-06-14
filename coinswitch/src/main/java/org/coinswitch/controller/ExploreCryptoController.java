package org.coinswitch.controller;

import java.util.List;
import java.util.Optional;

import org.coinswitch.entities.CryptoCurrency;
import org.coinswitch.repository.CryptoRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/crypto")
public class ExploreCryptoController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExploreCryptoController.class);

	@Autowired
	private CryptoRepository cryptoRepo;

	@PostMapping("/createCrypto")
	public ResponseEntity<CryptoCurrency> createCrypto(
			@ApiParam(value = "Crypto Details", required = true) @RequestBody CryptoCurrency crypto) {
		logger.info(" $$$$$$$$$$$$$$$$$$$$$$         Entered into createCrypto     $$$$$$$$$$$$$$$$$$$$$$$$$$$$ ");

		return new ResponseEntity<CryptoCurrency>(cryptoRepo.save(crypto), HttpStatus.OK);
	}

	@GetMapping("/getAllCryptoCurrency")
	public ResponseEntity<List<CryptoCurrency>> fetchAllCryptoCurrency() {
		return new ResponseEntity<List<CryptoCurrency>>(cryptoRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/findByCurrencyId/{currencyId}")
	public ResponseEntity<CryptoCurrency> getCurrencyDetailsById(
			@ApiParam(value = "Currency Id", required = true) @PathVariable("currencyId") Integer currencyId) {
		Optional<CryptoCurrency> crypto = cryptoRepo.findById(currencyId);
		if(crypto.isPresent()) {
			return new ResponseEntity<CryptoCurrency>(crypto.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getCurrencyByKeyword")
	public ResponseEntity<List<CryptoCurrency>> getCurrencyBycryptoSymbol(@ApiParam(value = "Currency By CryptoSymbol", required = true) @PathVariable("crypto_symbol") String  crypto_symbol){
		
		List<CryptoCurrency> currency = cryptoRepo.findBycryptoSymbol(crypto_symbol);
		
		return new ResponseEntity<List<CryptoCurrency>>(currency, HttpStatus.OK);
		
	}
}
