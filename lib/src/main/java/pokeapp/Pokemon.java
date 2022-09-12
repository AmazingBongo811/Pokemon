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

	
	
	public Pokemon(String poke_name) throws NullPointerException, IOException, InterruptedException, ExecutionException {
	get_api api = new get_api(poke_name);
	name = api.pokemon.name;
	ID=api.pokemon.id;
	height = api.pokemon.height;
	weight = api.pokemon.weight;
	img_url = api.get_img();
	
	
	}
	
	public String ToolTip()
	{
		return "name: " + name + "\n weight: " + weight + "\n height: " + height + "\n ID: " + ID;
		
	}

}
