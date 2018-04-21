package service;

import java.util.ArrayList;

import model.Goods;

public interface GoodsService {
	ArrayList serchGoodsByName (String name);
	Goods serchGoodsByID (int id);
}
