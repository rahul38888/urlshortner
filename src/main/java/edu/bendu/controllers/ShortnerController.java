package edu.bendu.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bendu.constants.AppConstants;
import edu.bendu.exceptions.InvalidUrlException;
import edu.bendu.pojo.ShortUrlObject;
import edu.bendu.utils.HashCreationUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

@RestController
@Controller
@RequestMapping("/")
public class ShortnerController {

	private final ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/short", produces="application/json; charset=utf-8")
	public String getShortenedUrl(@RequestParam("url") String url)
			throws JsonProcessingException, MalformedURLException, InvalidUrlException,
			UnsupportedEncodingException, NoSuchAlgorithmException {
		if(!StringUtils.isEmpty(url))
			throw new InvalidUrlException("Url parameter blank");
		url = validateUrl(url);

		ShortUrlObject shortUrl = HashCreationUtil.toShortUrl(url);

		return mapper.writeValueAsString(shortUrl) ;
	}

	private String validateUrl(String url) throws MalformedURLException, InvalidUrlException {
		if(!StringUtils.isEmpty(url) && !url.contains("http"))
			url = "http://" + url;

		URL urlObject = new URL(url);
		if(AppConstants.HOST.equals(urlObject.getAuthority()) &&
				urlObject.getPath().indexOf(AppConstants.SHORT_URL_PATH)==0)
			throw new InvalidUrlException("Url is already shortened");

		return url;
	}

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		System.out.println(HashCreationUtil.toShortUrl("https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html"));
	}

}
