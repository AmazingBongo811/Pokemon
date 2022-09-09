package pokeapp;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodySubscribers;

import java.util.*;




public class http_client {

	
	
	public static String get_http(String url) throws IOException, InterruptedException, ExecutionException, NullPointerException
	{
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(
		       URI.create(url))
		   .header("accept", "application/json")
		   .build();

		var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		var response = responseFuture.get();
		return response.body();
	}
	

}
