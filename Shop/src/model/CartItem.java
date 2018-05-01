package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//购物车条目
public class CartItem implements Serializable {
	@JsonProperty
   	public int id;
    @JsonProperty
    public String name;
    @JsonProperty
    public int now_price;
    @JsonProperty
    public String images;
    @JsonProperty
    public String size;
    @JsonProperty
    public String color;
    @JsonProperty
    public int count;
	
	public CartItem(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNow_price() {
		return now_price;
	}
	public void setNow_price(int nowPrice) {
		now_price = nowPrice;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}
