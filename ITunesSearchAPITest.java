 import org.apache.http.HttpResponse;
 import org.apache.http.client.methods.HttpGet;
 import org.apache.http.impl.client.DefaultHttpClient;
 import org.json.*;
 import org.testng.Assert;
 import org.testng.annotations.Test;
 

 public class ITunesSearchAPITest{
 
 	private String BASE_URL = "https://itunes.apple.com/search?";
 	
 	@Test
 	public void testSearchNullParameter(){
 		String params = null;
 		
 		DefaultHttpClient httpClient = new DefaultHttpClient();
 		HttpGet request = new HttpGet(BASE_URL + params);
 		HttpResponse response = httpClient.execute(request);	
 		String responseContent = response.getEntity().getContent().toString();
		JSONObject object = new JSONObject(responseContent);
 		
 		Assert.assertEquals(0, object.get("resultCount"));
 	}
 	
 	@Test
 	public void testSearchEmptyTerm(){
 		String params = "term=";
 		
 		DefaultHttpClient httpClient = new DefaultHttpClient();
 		HttpGet request = new HttpGet(BASE_URL + params);
 		HttpResponse response = httpClient.execute(request);	
 		String responseContent = response.getEntity().getContent().toString();
		JSONObject object = new JSONObject(responseContent);
 		
 		Assert.assertEquals(0, object.get("resultCount"));
 	}
 	
 	@Test
 	public void testSearchTerm(){
 		String params = "term=jack+johnson";
 		
 		DefaultHttpClient httpClient = new DefaultHttpClient();
 		HttpGet request = new HttpGet(BASE_URL + params);
 		HttpResponse response = httpClient.execute(request);	
 		String responseContent = response.getEntity().getContent().toString();
		JSONObject object = new JSONObject(responseContent);
		
 		Assert.assertEquals(2, object.get("resultCount"));
 	}
 	// Test case which 'term' and 'country ' are valid
 	@Test
 	public void testSearchCountry(){
 		String params = "term=jack+johnson&country=US";
 		
 		DefaultHttpClient httpClient = new DefaultHttpClient();
 		HttpGet request = new HttpGet(BASE_URL + params);
 		HttpResponse response = httpClient.execute(request);	
 		String responseContent = response.getEntity().getContent().toString();
		JSONObject object = new JSONObject(responseContent);
 		
 		Assert.assertEquals(2, object.get("resultCount"));
 	}
 	// Test case which 'term' is valid, 'country' is not valid
 	@Test
 	public void testSearchInvalidCountry(){
 		String params = "term=jack+johnson&country=AB";
 		
 		DefaultHttpClient httpClient = new DefaultHttpClient();
 		HttpGet request = new HttpGet(BASE_URL + params);
 		HttpResponse response = httpClient.execute(request);	
 		assertEquals(400, response.getStatusLine().getStatusCode());
 		
 	}
 	// Test case which 'term', 'country' and 'media' are valid
 	@Test
 	public void testSearchMedia(){
 		String params = "term=jack+johnson&country=US&media=movie";
 		
 		DefaultHttpClient httpClient = new DefaultHttpClient();
 		HttpGet request = new HttpGet(BASE_URL + params);
 		HttpResponse response = httpClient.execute(request);	
 		String responseContent = response.getEntity().getContent().toString();
		JSONObject object = new JSONObject(responseContent);
 		
 		Assert.assertEquals(0, object.get("resultCount"));
 	}
 	
 	// Test case which 'term', 'country' are valid and 'media' is invalid
 	@Test
 	public void testSearchInvalidMedia(){
 		String params = "term=jack+johnson&country=US&media=invalid";
 		
 		DefaultHttpClient httpClient = new DefaultHttpClient();
 		HttpGet request = new HttpGet(BASE_URL + params);
 		HttpResponse response = httpClient.execute(request);	
 		assertEquals(400, response.getStatusLine().getStatusCode());
 		
 	}
 	
 	// Test case which 'limit' is valid
 	@Test
 	public void testSearchLimit(){
 		String params = "term=jack+johnson&country=US&media=movie&k=limit=100";
 		
 		DefaultHttpClient httpClient = new DefaultHttpClient();
 		HttpGet request = new HttpGet(BASE_URL + params);
 		HttpResponse response = httpClient.execute(request);	
 		String responseContent = response.getEntity().getContent().toString();
		JSONObject object = new JSONObject(responseContent);
 		
 		Assert.assertEquals(100, object.get("resultCount"));
 	}
 }
