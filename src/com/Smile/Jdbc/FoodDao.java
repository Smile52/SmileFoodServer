package com.Smile.Jdbc;

import java.util.List;

import com.Smile.Bean.Food;
import com.Smile.Bean.FoodId;

public interface FoodDao {
	public int addFood(Food food);
	public List<Food> queryFood(String ip);
	public int deleteFood(int id);
	public int updateFood(List<FoodId> foodIds);

}
