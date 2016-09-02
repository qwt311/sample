package blade.sample.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blade.annotation.RestController;
import com.blade.annotation.Route;
import com.blade.web.http.HttpMethod;

import blade.sample.model.Person;

@RestController(value = "/api", suffix = ".json")
public class ApiController {
	
	@Route(value = "person", method = HttpMethod.GET)
	public List<Person> persons(){
		List<Person> persons = new ArrayList<Person>(2);
		persons.add(new Person(1, "jack", 20L, new Date()));
		persons.add(new Person(2, "rose", 25L, new Date()));
		return persons;
	}
	
}