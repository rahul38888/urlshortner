package edu.bendu.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bendu.pojo.ShortUrlObject;
import edu.bendu.utils.HashCreationUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@Controller
@RequestMapping("/")
public class ShortnerController {

	private final ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "short", produces="application/json; charset=utf-8")
	public String getShortenedUrl(@RequestParam("url") String url) throws JsonProcessingException {

		if(!StringUtils.isEmpty(url) && !url.contains("http"))
			url = "http://" + url;

		ShortUrlObject shortUrl = null;
		try {
			shortUrl = HashCreationUtil.toShortUrl(url);

			return mapper.writeValueAsString(shortUrl) ;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			return mapper.writeValueAsString(e);
		}
	}

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		System.out.println(HashCreationUtil.toShortUrl("https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html"));
	}

}
