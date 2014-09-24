package com.macaxeira.util;

import java.io.Serializable;

import com.google.gson.Gson;
import com.macaxeira.model.Categoria;

public class Main {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		SyncEntitys<Categoria> sync = new SyncEntitys<Categoria>();
		
		Categoria e1 = new Categoria();
		e1.setId(1); e1.setNome("Bebidas");
		
		Categoria e2 = new Categoria();
		e2.setId(1); e2.setNome("Combos");
				
		sync.addEntity(e1);
		sync.addEntity(e2);
		
		
		String json = gson.toJson(sync);
		SyncEntitys<Categoria> sync2 = gson.fromJson(json, SyncEntitys.class);
		
		for(Categoria e : sync2.getEntitys()){
			
			String x = e.getClass().getCanonicalName();
			System.out.println(x);
			
		}
		
		

	}

}
