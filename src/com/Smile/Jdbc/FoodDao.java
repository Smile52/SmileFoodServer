package com.Smile.Jdbc;

import java.util.List;

import com.Smile.Bean.Food;

public interface FoodDao {
	public int addFood(Food food);
	public List<Food> queryFood();
	public int deleteFood(int id);
	public int updateFood(int id,Food food);

}
