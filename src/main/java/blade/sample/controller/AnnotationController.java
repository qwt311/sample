package blade.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blade.annotation.Controller;
import com.blade.annotation.PathVariable;
import com.blade.annotation.RequestParam;
import com.blade.annotation.Route;
import com.blade.ioc.annotation.Inject;
import com.blade.view.ModelAndView;
import com.blade.web.http.HttpMethod;
import com.blade.web.http.Request;

import blade.sample.service.UserService;

@Controller
public class AnnotationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationController.class);
	
	@Inject
	UserService userService;
	
	@Route(value = "post", method = HttpMethod.POST)
	public void post() {
		LOGGER.info("request POST");
	}
	
	@Route("users/:name")
	public String users(Request request, @PathVariable String name) {
		LOGGER.info("request users");
		LOGGER.info("param name = {}", name);
		request.attribute("name", name);
		return "/users.jsp";
	}
	
	@Route({"/", "index"})
	public ModelAndView index(ModelAndView mav, @RequestParam int age) {
		
		LOGGER.info("request query age = {}", age);
		
		userService.sayHello();
		
		mav.add("name", "jack");
		mav.setView("index.jsp");
		
		return mav;
	}
	
	@Route("you/:username")
	public ModelAndView you(ModelAndView mav, @PathVariable String username) {
		mav.add("username", username);
		mav.setView("you.html");
		return mav;
	}
	
}