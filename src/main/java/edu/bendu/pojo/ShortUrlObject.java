package edu.bendu.pojo;

import java.io.Serializable;
import java.util.Objects;

public class ShortUrlObject implements Serializable {

	String shortUrl;
	String url;
	String shortUrlKey;
	String md5Hash;

	public String getMd5Hash() {
		return md5Hash;
	}

	public void setMd5Hash(String md5Hash) {
		this.md5Hash = md5Hash;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortUrlKey() {
		return shortUrlKey;
	}

	public void setShortUrlKey(String shortUrlKey) {
		this.shortUrlKey = shortUrlKey;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ShortUrlObject that = (ShortUrlObject) o;

		if (!shortUrlKey.equals(that.shortUrlKey)) return false;
		return md5Hash.equals(that.md5Hash);
	}

	@Override
	public int hashCode() {
		int result = shortUrlKey.hashCode();
		result = 31 * result + md5Hash.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "ShortUrlObject{" +
				"shortUrl='" + shortUrl + '\'' +
				", url='" + url + '\'' +
				", shortUrlKey='" + shortUrlKey + '\'' +
				", md5Hash='" + md5Hash + '\'' +
				'}';
	}
}
