package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
		List<Item> items = Item.find("bid = ?", false).fetch();
		renderArgs.put("items", items);
		render();
	}

	public static void detail(long id, boolean bid) {
		Item item = Item.findById(id);
		if(bid) {
			item.bid = bid;
			item.save();
			index();
		}
		renderArgs.put("item", item);
		render();
	}

	public static void createItem(String name){
		Item item = new Item();
		item.name = name;
	}
}