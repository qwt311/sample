package blade.sample.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.route.annotation.Path;
import com.blade.route.annotation.Route;
import com.blade.view.template.ModelAndView;
import com.blade.web.http.HttpMethod;
import com.blade.web.http.Request;
import com.blade.web.http.Response;

import blade.kit.logging.Logger;
import blade.kit.logging.LoggerFactory;
import blade.sample.service.UserService;

@Path
public class AnnotationSample {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationSample.class);
	
	@Inject
	UserService userService;
	
	@Route(value = "/post", method = HttpMethod.POST)
	public void post() {
		LOGGER.info("request POST");
	}
	
	@Route(value = "/post", method = HttpMethod.GET)
	public String test() {
		return "test.jsp";
	}
	
	@Route("/rock/:id")
	public void rock2() {
		LOGGER.info("request rock2");
	}
	
	@Route("/users/:name")
	public void users(Request request, Response response) {
		
		LOGGER.info("request users");
		
		String name = request.param("name");
		
		LOGGER.info("param name = {}", name);
		
		request.attribute("name", name);
		response.render("/users.jsp");
	}

	@Route("/index")
	public void index(Request request, Response response) {
		
		userService.sayHello();
		
		ModelAndView modelAndView = new ModelAndView("index.jsp");
		modelAndView.add("name", "jack");
		
		LOGGER.info("param test = {}", request.queryAsInt("test"));
		
		response.render(modelAndView);
	}
	
	
	@Route("/you/:username")
	public void you(Request request, Response response) {
		ModelAndView modelAndView = new ModelAndView("you.html");
		modelAndView.add("username", request.param("username"));
		response.render(modelAndView);
	}
	
}