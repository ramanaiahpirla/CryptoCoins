package org.coinswitch.controller;

import java.util.List;

import org.coinswitch.entities.CryptoCurrency;
import org.coinswitch.repository.CryptoRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		logger.info(" $$$$$$$$$$$$$$$$$$$$$$         Entered into createCrypto $$$$$$$$$$$$$$$$$$$$$$$$$$$$ ");
		
		return new ResponseEntity<CryptoCurrency>(cryptoRepo.save(crypto), HttpStatus.OK);
	}
	
	@GetMapping("/getAllCryptoCurrency")
	public ResponseEntity<List<CryptoCurrency>> fetchAllCryptoCurrency(){
		return new ResponseEntity<List<CryptoCurrency>>(cryptoRepo.findAll(),HttpStatus.OK);
	}
	
	
	
	
	
}
