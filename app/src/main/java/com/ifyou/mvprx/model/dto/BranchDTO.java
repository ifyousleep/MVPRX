package com.ifyou.mvprx.model.dto;

public class BranchDTO{
	private String name;
	private CommitDTO commit;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCommit(CommitDTO commit){
		this.commit = commit;
	}

	public CommitDTO getCommit(){
		return commit;
	}

	@Override
 	public String toString(){
		return 
			"BranchDTO{" + 
			"name = '" + name + '\'' + 
			",commit = '" + commit + '\'' + 
			"}";
		}
}
