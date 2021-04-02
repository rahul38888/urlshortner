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

		ShortUrlObject shortUrl1 = (ShortUrlObject) o;

		if (!shortUrl.equals(shortUrl1.shortUrl)) return false;
		if (!url.equals(shortUrl1.url)) return false;
		return Objects.equals(shortUrlKey, shortUrl1.shortUrlKey);
	}

	@Override
	public int hashCode() {
		int result = shortUrl.hashCode();
		result = 31 * result + url.hashCode();
		result = 31 * result + (shortUrlKey != null ? shortUrlKey.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ShortUrlObject{" +
				"shortUrl='" + shortUrl + '\'' +
				", url='" + url + '\'' +
				", shortUrlKey='" + shortUrlKey + '\'' +
				'}';
	}
}
