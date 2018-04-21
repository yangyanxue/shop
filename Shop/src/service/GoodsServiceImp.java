package service;

import java.util.ArrayList;

import dao.GoodsDaoImp;

import model.Goods;

public class GoodsServiceImp implements GoodsService {

	public Goods serchGoodsByID(int id) {
		// TODO Auto-generated method stub
		GoodsDaoImp g = new GoodsDaoImp();
		return g.serchGoodsByID(id);
	}

	public ArrayList serchGoodsByName(String name) {
		// TODO Auto-generated method stub
		GoodsDaoImp g = new GoodsDaoImp();
		return g.serchGoodsByName(name);
	}

}
