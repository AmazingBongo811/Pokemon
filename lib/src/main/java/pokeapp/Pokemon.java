package pokeapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Pokemon {
	
	public int baseHappines;
	public int captureRate;
	public String evlovesFrom;
	public  int weight;
	public  String name;
	public  int id;
	public  int height;
	public String img_url;

	
	
	public Pokemon(String pokeName) throws NullPointerException, IOException, InterruptedException, ExecutionException {
	GetApi api = new GetApi(pokeName);
	name = api.pokemon.name;
	id=api.pokemon.id;
	height = api.pokemon.height;
	weight = api.pokemon.weight;
	img_url = api.getImg();
	
	
	}
	
	public String toolTip()
	{
		return "name: " + name + "\n weight: " + weight + "\n height: " + height + "\n ID: " + id;
		
	}

}
