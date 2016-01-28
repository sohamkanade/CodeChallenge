package com.home.random;

import java.security.Key;

import javax.crypto.Cipher;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Advance Encryption Standard Cipher Utility Class
 * 
 * @author spark
 *
 */
public class CryptoUtils {

	public static final String ALGO = "AES";
//	private static final byte[] KEY_VALUE = "t3$tu5@s3c53tc0d".getBytes();
//	private static final Key CIPHER_KEY = new SecretKeySpec(KEY_VALUE, ALGO); 

	public static String encrypt(String data, Key cipherKey) throws Exception {
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, cipherKey);
		byte[] encrypted = c.doFinal(data.getBytes());
		byte[] encoded = new Base64().encode(encrypted);
		return new String(encoded);
	}

	public static String decrypt(String encryptedData, Key cipherKey) throws Exception {
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, cipherKey);
		byte[] decoded = new Base64().decode(encryptedData.getBytes());
		byte[] decrypted = c.doFinal(decoded);
		return new String(decrypted);
	}
}
