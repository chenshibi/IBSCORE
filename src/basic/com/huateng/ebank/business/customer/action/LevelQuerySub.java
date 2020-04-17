package com.huateng.ebank.business.customer.action;

public class LevelQuerySub {
	public String  id;
	public String  name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LevelQuerySub(String id,String name){
		this.id = id;
		this.name = name;
	}
	public String toString(){
		return "levelQueruSub[id = "+id+",name = "+name+"]";
	}
}
