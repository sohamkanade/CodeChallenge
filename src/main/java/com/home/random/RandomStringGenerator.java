package com.home.random;

import java.math.BigInteger;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.spec.SecretKeySpec;

public class RandomStringGenerator {
	public static void main(String[] args) throws Exception {
		SecureRandom random = new SecureRandom();

//		this is generate 130 bits and assign 5bit for each character, so 26 characters total
//		and we want to have only 16 character to build up mask/secretKey, so get substring
//		byte[] keyValue = new BigInteger(130, random).toString(32).substring(0, 16).getBytes();
//		System.out.println( keyValue.toString() );
		
		String keyString = new BigInteger(130, random).toString(32).substring(0, 16);
		System.out.println(keyString);
		Key cipherKey = new SecretKeySpec(keyString.getBytes(), CryptoUtils.ALGO); 
		String encryptedData = CryptoUtils.encrypt("wert66", cipherKey);
		System.out.println("encrypted: ".concat(encryptedData));

		String decyptedData = CryptoUtils.decrypt(encryptedData, cipherKey);
		System.out.println("decrypted: ".concat(decyptedData));
	}
}
