package com.suresh.restclient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class RestTest {

	@RequestMapping(value ="/employees", produces = MediaType.APPLICATION_XML_VALUE, method=RequestMethod.GET)
	public String getAllEmployeesXML(Model model)
	{
		model.addAttribute("employees", getEmployeesCollection());
		return "xmlTemplate";
	}
	
	private static void getAllEmployees()
	{
		final String uri = "http://localhost:8080/springrestexample/employees.xml";
		RestTemplate rt =new RestTemplate();
		String result = rt.getForObject(uri, String.class);
		System.out.println(result);
	}
	
	//REST API Code
	@RequestMapping(value="/employees", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public String getAllEmployeesJSON(Model model)
	{
		model.addAttribute("employees", getEmployeesCollection());
		
		return "jsonTemplate";
	}
	
	//REST Client Code
	public static void getEmployees()
	{
		final String uri = "http://localhost:8080/springrestexample/employees.json";
		
		/*RestTemplate rt =new RestTemplate();
		String result = rt.getForObject(uri, String.class);
		System.out.println(result);*/
		
		RestTemplate rt =new RestTemplate();
		HttpHeaders headers =new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<String> result = rt.exchange(uri, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
		 
		EmployeeListVO result1 = rt.getForObject(uri, EmployeeListVO.class);
		 System.out.println(result1);
		
	}
	
	private EmployeeListVO getEmployeesCollection()
    {
        EmployeeListVO employees = new EmployeeListVO();
         
        EmployeeVO empOne = new EmployeeVO(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        EmployeeVO empTwo = new EmployeeVO(2,"Amit","Singhal","asinghal@yahoo.com");
        EmployeeVO empThree = new EmployeeVO(3,"Kirti","Mishra","kmishra@gmail.com");
         
         
        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);
         
        return employees;
    }
	
	//REST API Code
	
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") int id)
	{
		if(id <= 3)
		{
			EmployeeVO employee = new EmployeeVO(1,"Suresh","Gupta","test1@gmail.com");
			return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<EmployeeVO>(HttpStatus.NOT_FOUND);
	}
	//REST Client Code
	private static void getEmployeeById()
	{
		final String uri = "http://localhost:8080/springrestexample/employees/{id}";
		
		Map<String, String> map =new HashMap<String, String>();
		map.put("id", "1");
		
		RestTemplate rt =new RestTemplate();
		EmployeeVO vo = rt.getForObject(uri, EmployeeVO.class, map);
		System.out.println(vo);
		
	}
	
	//REST API Code
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeVO vo)
	{
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	//REST Client Code
	private static void createEmployee()
	{
	    final String uri = "http://localhost:8080/springrestexample/employees";
	    EmployeeVO newEmployee = new EmployeeVO(-1, "Adam", "Gilly", "test@email.com");
		RestTemplate rt =new RestTemplate();
		
		EmployeeVO vo = rt.postForObject(uri, newEmployee, EmployeeVO.class);
		System.out.println(vo);
	}
	
	//REST API Code
	@RequestMapping(value="/employees/{id}", method=RequestMethod.PUT)
	public ResponseEntity<EmployeeVO> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeVO vo)
	{
		return new ResponseEntity<EmployeeVO>(vo, HttpStatus.OK);
	}
	
	//REST Client Code
	private static void updateEmployee()
	{
	    final String uri = "http://localhost:8080/springrestexample/employees/{id}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "2");
	     
	    EmployeeVO updatedEmployee = new EmployeeVO(2, "New Name", "Gilly", "test@email.com");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.put ( uri, updatedEmployee, params);
	}
	
	//REST API Code
	@RequestMapping(value="/employees/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id)
	{
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	//REST Client Code
	
	private static void deleteEmployee()
	{
	    final String uri = "http://localhost:8080/springrestexample/employees/{id}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "2");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete ( uri,  params );
	}
}
