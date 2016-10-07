package com.life.baymax;


public class ListItem {
	private String name;
	private int imageId;
	
	public  ListItem(String name, int imageId){
		this.name = name;
		this.imageId = imageId;
	}

	public int getImageId(){
		return imageId;
	}
	
	public String getName(){
		return name;
	}
}
