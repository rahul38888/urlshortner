package edu.bendu.utils;

import edu.bendu.pojo.ShortUrlObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HashCreationUtil {

	private static final char[] keyCharList =
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	private static final int defaultkeySize = 6;

	public static ShortUrlObject toShortUrl(String url)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		ShortUrlObject shortUrl =  new ShortUrlObject();
		shortUrl.setUrl(url);

		byte[] urlMd5Hash = md5Hash(url);
		shortUrl.setMd5Hash(convertToHex(urlMd5Hash));

		shortUrl.setShortUrlKey(randomKeyGen(defaultkeySize));

		return shortUrl;
	}

	private static byte[] md5Hash(String input) throws NoSuchAlgorithmException {
		byte[] urlBytes = input.getBytes(StandardCharsets.ISO_8859_1);

		MessageDigest instance = MessageDigest.getInstance("MD5");
		return instance.digest(urlBytes);
	}

	private static String convertToHex(byte[] data)
	{
		StringBuilder builder = new StringBuilder();
		for (byte datum : data) {
			int halfbyte = datum >>> 4 & 0xF;
			int parts = 0;
			do {
				if (halfbyte <= 9)
					builder.append((char) (48 + halfbyte));
				else
					builder.append((char) (97 + (halfbyte - 10)));
				halfbyte = datum & 0xF;
			} while (parts++ < 1);
		}
		return builder.toString();
	}

	public static String randomKeyGen(Integer keyLength){
		StringBuilder keyBuffer = new StringBuilder(keyLength);
		Random randomGen = new Random();

		for(int i=0;i<keyLength;i++)
			keyBuffer.append(keyCharList[randomGen.nextInt()]);

		return keyBuffer.toString();
	}

}
