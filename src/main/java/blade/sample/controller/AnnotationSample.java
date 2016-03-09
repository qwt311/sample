package blade.sample.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.route.annotation.Path;
import com.blade.route.annotation.Route;
import com.blade.view.ModelAndView;
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
	
	@Route("/users/:name")
	public String users(Request request, Response response) {
		
		String name = request.param("name");
		
		LOGGER.info("request users");
		LOGGER.info("param name = {}", name);
		request.attribute("name", name);
		return "/users.jsp";
	}
	
	@Route("/index")
	public ModelAndView index(Request request, Response response) {
		
		userService.sayHello();
		
		ModelAndView modelAndView = new ModelAndView("index.jsp");
		modelAndView.add("name", "jack");
		LOGGER.info("param test = {}", request.queryAsInt("test"));
		
		return modelAndView;
	}
	
	@Route("/you/:username")
	public ModelAndView you(Request request, Response response) {
		ModelAndView modelAndView = new ModelAndView("you.html");
		modelAndView.add("username", request.param("username"));
		return modelAndView;
	}
	
}