package blade.sample.route;

import blade.sample.service.UserService;

import com.blade.annotation.Inject;
import com.blade.annotation.Path;
import com.blade.annotation.Route;
import com.blade.render.ModelAndView;
import com.blade.web.http.HttpMethod;
import com.blade.web.http.Request;
import com.blade.web.http.Response;

@Path
public class AnnotationSample {
	
	@Inject
	UserService userService;
	
	@Route(value = "/post", method = HttpMethod.POST)
	public void post() {
		System.out.println("post");
	}
	
	@Route(value = "/post", method = HttpMethod.GET)
	public String test() {
		return "test.jsp";
	}
	
	@Route("/rock/:id")
	public void rock2() {
		System.out.println("rock2");
	}
	
	@Route("/users/:name")
	public void users(Request request, Response response) {
		System.out.println("users");
		String name = request.param("name");
		System.out.println("name = " + name);
		request.attribute("name", name);
		response.render("/users.jsp");
	}

	@Route("/index")
	public void index(Request request, Response response) {
		ModelAndView modelAndView = new ModelAndView("index.jsp");
		modelAndView.add("name", "jack");
		System.out.println(request.queryAsInt("test"));
		response.render(modelAndView);
	}
	
	
	@Route("/you/:username")
	public void you(Request request, Response response) {
		ModelAndView modelAndView = new ModelAndView("you.html");
		modelAndView.add("username", request.param("username"));
		response.render(modelAndView);
	}
	
}