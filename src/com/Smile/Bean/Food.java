package com.Smile.Bean;
/**
 * ≤À µÃÂ
 * @author æ≈¡˙
 *
 */
public class Food {
	private int FoodId;
	private String FoodName;
	private Float FoodPrice;
	private String FoodDetial;
	private String FoodUrl;
	private int FoodCount;
	public Food(){
		
	};
	public int getFoodId() {
		return FoodId;
	}
	public void setFoodId(int foodId) {
		FoodId = foodId;
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodName) {
		FoodName = foodName;
	}
	public Float getFoodPrice() {
		return FoodPrice;
	}
	public void setFoodPrice(Float foodPrice) {
		FoodPrice = foodPrice;
	}
	public String getFoodDetial() {
		return FoodDetial;
	}
	public void setFoodDetial(String foodDetial) {
		FoodDetial = foodDetial;
	}
	public String getFoodUrl() {
		return FoodUrl;
	}
	public void setFoodUrl(String foodUrl) {
		FoodUrl = foodUrl;
	}
	
	public int getFoodCount() {
		return FoodCount;
	}
	public void setFoodCount(int foodCount) {
		FoodCount = foodCount;
	}
	@Override
	public String toString() {
		return "Food [FoodId=" + FoodId + ", FoodName=" + FoodName
				+ ", FoodPrice=" + FoodPrice + ", FoodDetial=" + FoodDetial
				+ ", FoodUrl=" + FoodUrl + ", FoodCount=" + FoodCount + "]";
	}
	
	
}
	
