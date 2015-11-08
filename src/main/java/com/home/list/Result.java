package com.home.list;

public class Result {
	private String url;
	private String info;

	public Result() {}

	public Result(String url, String info) {
		super();
		this.url = url;
		this.info = info;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
