/**
 * 
 */
package com.home.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Santhana Rajagopalan S
 * May 13, 2013
 */
public class Base64Util {

	
	public static void main(String[] args) throws Exception {
		Base64Util util = new Base64Util();
		//String encoded = util.encodeFileToBase64Binary("D:\\CacheTestNew.zip");
		String content = new Scanner(new File("E:\\2.txt")).useDelimiter("\\Z").next();
		convertFromStringToBinary("E:\\sample.zip" , content);
	}


	private String encodeFileToBase64Binary(String fileName)
	throws IOException {

		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		String encodedString = new String(encoded);

		return encodedString;
	}

	private static byte[] loadFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}
		byte[] bytes = new byte[(int)length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "+file.getName());
		}

		is.close();
		return bytes;
	}
	private static void convertFromStringToBinary(String path, String data) throws Exception{
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(Base64.decodeBase64(data));
		fos.close();
	}
}
