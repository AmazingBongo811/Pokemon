package pokeapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Pokemon {
	
	public int base_happines;
	public int capture_rate;
	public String evloves_from;
	public  int weight;
	public  String name;
	public  int ID;
	public  int height;
	public String img_url;
	private  get_api api;
	
	
	public Pokemon(String poke_name) throws NullPointerException, IOException, InterruptedException, ExecutionException {
	this.api = new get_api(poke_name);
	this.name = api.get_poke().name;
	this.ID=api.get_id();
	this.height = api.get_poke().height;
	this.weight = api.get_poke().weight;
	this.img_url = api.get_img();
	
	
	}

}
