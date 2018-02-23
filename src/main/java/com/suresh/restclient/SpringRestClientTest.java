package com.suresh.restclient;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class SpringRestClientTest {

	public static final String REST_SERVICE_URI = "<a class=\"vglnk\" href=\"http://localhost:2020/ServletCRUD\" rel=\"nofollow\"><span>http</span><span>://"
			+ "</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>ServletCRUD</span></a>".trim();
	     
	
	URI uri = UriComponentsBuilder.fromUriString(REST_SERVICE_URI + "/api")
			.pathSegment("queues", "{vhost}")
			.buildAndExpand("").encode().toUri();
		//public static final String JSON_STRING="{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";  
	
	//public static final String REST_SERVICE_URI = "<a class="vglnk" href="http://localhost:8080/Spring4MVCCRUDRestService" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>Spring4MVCCRUDRestService</span></a>";
	    /* GET */
	    @SuppressWarnings("unchecked")
	    private static void listAllUsers(){
	        System.out.println("Testing listAllUsers API-----------");
	         
	        RestTemplate restTemplate = new RestTemplate();
	        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject("http://localhost:2020/ServletCRUD"+"/ccc/", List.class);
	         
	        if(usersMap!=null){
	            for(LinkedHashMap<String, Object> map : usersMap){
	                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));;
	            }
	        }else{
	            System.out.println("No user exist----------");
	        }
	    }
	     
	    /* GET */
	    private static void getUser(){
	        System.out.println("Testing getUser API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        User user = restTemplate.getForObject("http://localhost:2020/ServletCRUD"+"/ccc/1", User.class);
	        System.out.println(user);
	    }
	     
	    /* POST */
	    private static void createUser() {
	        System.out.println("Testing create User API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        User user = new User(0,"Sarah",51,134);
	        URI uri = restTemplate.postForLocation("http://localhost:2020/ServletCRUD"+"/ccc/", user, User.class);
	        System.out.println("Location : "+uri.toASCIIString());
	    }
	 
	    /* PUT */
	    private static void updateUser() {
	        System.out.println("Testing update User API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        User user  = new User(1,"Tomy",33, 70000);
	        restTemplate.put("http://localhost:2020/ServletCRUD"+"/ccc/1", user);
	        System.out.println(user);
	    }
	 
	    /* DELETE */
	    private static void deleteUser() {
	        System.out.println("Testing delete User API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.delete("http://localhost:2020/ServletCRUD"+"/ccc/3");
	    }
	 
	 
	    /* DELETE */
	    private static void deleteAllUsers() {
	        System.out.println("Testing all delete Users API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.delete("http://localhost:2020/ServletCRUD"+"/ccc/");
	    }
	 
	    public static void main(String args[]){
	    	
	    		listAllUsers();
		        getUser();
		        createUser();
		        listAllUsers();
		        updateUser();
		        listAllUsers();
		        deleteUser();
		        listAllUsers();
		        deleteAllUsers();
		        listAllUsers();
	        
	    }
}
