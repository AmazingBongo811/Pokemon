package pokeapp;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.*;

public class GetApi {
	
	public Poke pokemon;
	private String pokeName;
	
	public GetApi(String pokeName) throws NullPointerException, IOException, InterruptedException, ExecutionException
	{

		this.pokeName=pokeName;
		pokemon = getPoke();

	}
	

	public Poke getPoke() throws NullPointerException, IOException, InterruptedException, ExecutionException
	{
		
		String url = "https://pokeapi.co/api/v2/pokemon/";
		String getPokemon = HTTPClient.getHttp(url + pokeName);
		
		ObjectMapper mapper = new ObjectMapper();
		Poke pokemon1 = mapper.readValue(getPokemon, Poke.class);

		 return pokemon1;
		 
	}
	

	
	public void getAbilities(String ablility_name) throws NullPointerException, IOException, InterruptedException, ExecutionException
	{
	
	}
	

	
	public String getImg() throws NullPointerException, IOException, InterruptedException, ExecutionException
	{
		
		return pokemon.sprites.findValue("front_default").toString().replace('"',' ');
	}
	

	

}
