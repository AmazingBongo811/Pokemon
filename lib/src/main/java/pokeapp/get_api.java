package pokeapp;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.*;

public class get_api {
	
	public poke pokemon;
	private String poke_name;
	
	public get_api(String poke_name) throws NullPointerException, IOException, InterruptedException, ExecutionException
	{

		this.poke_name=poke_name;
		pokemon = get_poke();

	}
	

	public poke get_poke() throws NullPointerException, IOException, InterruptedException, ExecutionException
	{
		
		String url = "https://pokeapi.co/api/v2/pokemon/";
		String get_pokemon = http_client.get_http(url + poke_name);
		
		ObjectMapper mapper = new ObjectMapper();
		poke pokemon1 = mapper.readValue(get_pokemon, poke.class);

		 return pokemon1;
		 
	}
	

	
	public void get_abilities(String ablility_name) throws NullPointerException, IOException, InterruptedException, ExecutionException
	{
	
	}
	

	
	public String get_img() throws NullPointerException, IOException, InterruptedException, ExecutionException
	{
		
		return pokemon.sprites.findValue("front_default").toString().replace('"',' ');
	}
	

	

}
