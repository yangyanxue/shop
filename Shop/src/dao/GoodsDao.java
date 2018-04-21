package dao;

import java.util.ArrayList;

import model.Goods;

public interface GoodsDao {
	ArrayList serchGoodsByName (String name);
	Goods serchGoodsByID (int id);

}
