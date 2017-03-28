package com.ifyou.mvprx.model.dto;

public class CommitDTO {
	private String sha;
	private String url;

	public void setSha(String sha){
		this.sha = sha;
	}

	public String getSha(){
		return sha;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"CommitDTO{" +
			"sha = '" + sha + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
