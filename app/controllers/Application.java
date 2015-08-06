package controllers;

import play.*;
import play.libs.Files;
import play.mvc.*;

import java.io.File;
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

	public static void mybid(){
		List<Item> items = Item.find("bid = ?", true).fetch();
		renderArgs.put("items", items);
		render();
	}
	
	public static void sellList(){
		List<Item> items = Item.find("sell = ?", true).fetch();
		renderArgs.put("items", items);
		render();
	}
	
	public static void upload(File attachment){
		render();
	}
	
	public static void uploading(File attachment){
		if(attachment != null){
			Files.copy(attachment, Play.getFile("public/images/"+attachment.getName())); 
		}
		detailInfo(attachment.getName());
	}
	
	public static void detailInfo(String name){
		renderArgs.put("fileName", name);
		render();
	}
	
	public static void createItem(String name, String tag,String price,String contact,String detail,String fileName){
		Item item = new Item();
		item.name = name;
		item.tag = tag;
		item.price = Float.parseFloat(price);
		item.email = contact;
		item.details = detail;
		item.picture = fileName;
		item.save();
		index();
		
		
	}
}
