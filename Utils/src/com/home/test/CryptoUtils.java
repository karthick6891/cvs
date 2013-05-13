/**
 * 
 */
package com.home.test;

import java.io.File;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Santhana Rajagopalan S
 * May 03, 2013
 */
public class CryptoUtils {

	public static final String AES = "AES";
	public static void main(String[] args) throws Exception{

		String encrypedPwd = "";
		DESKeySpec keySpec = new DESKeySpec("12345678".getBytes("UTF8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(keySpec);
		encrypedPwd = new Scanner(new File("E:\\1.txt")).useDelimiter("\\Z").next();
		System.out.println("encrypted" + encrypedPwd.length());
		// DECODE encryptedPwd String
		byte[] encrypedPwdBytes = Base64.decodeBase64(encrypedPwd);

		Cipher cipher1 = Cipher.getInstance("DES");// cipher is not thread safe
		cipher1.init(Cipher.DECRYPT_MODE, key);
		byte[] plainTextPwdBytes = (cipher1.doFinal(encrypedPwdBytes));
		System.out.println(new String(plainTextPwdBytes, "UTF-8") + "\n");
	}

	private static void mainLogic() throws Exception{
		DESKeySpec keySpec = new DESKeySpec("12345678".getBytes("UTF8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(keySpec);

		// ENCODE plainTextPassword String
		byte[] cleartext = "Chennai#4".getBytes("UTF8");

		Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
		cipher.init(Cipher.ENCRYPT_MODE, key);
		String encrypedPwd = Base64.encodeBase64String(cipher.doFinal(cleartext));
		System.out.println("encrypted" + encrypedPwd);
		// DECODE encryptedPwd String
		byte[] encrypedPwdBytes = Base64.decodeBase64(encrypedPwd);

		Cipher cipher1 = Cipher.getInstance("DES");// cipher is not thread safe
		cipher1.init(Cipher.DECRYPT_MODE, key);
		byte[] plainTextPwdBytes = (cipher1.doFinal(encrypedPwdBytes));
		System.out.println(new String(plainTextPwdBytes, "UTF-8") + "\n");
	}
}
