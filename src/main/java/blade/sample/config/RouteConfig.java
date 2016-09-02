package blade.sample.config;

import static com.blade.Blade.$;

import com.blade.config.ApplicationConfig;
import com.blade.config.BaseConfig;
import com.blade.ioc.annotation.Component;
import com.blade.route.RouteHandler;
import com.blade.view.ViewSettings;
import com.blade.view.template.JspEngine;
import com.blade.web.http.HttpMethod;
import com.blade.web.http.Request;
import com.blade.web.http.Response;

import blade.sample.controller.NormalController;

@Component
public class RouteConfig implements BaseConfig {

	@Override
	public void config(ApplicationConfig applicationConfig) {
		// 配置模板引擎
		ViewSettings.$().templateEngine(new JspEngine());
		
		// 函数式路由
		$().route("/hello", NormalController.class, "hello");
		$().route("/save_user", NormalController.class, "post:saveUser");
		$().route("/delete_user", NormalController.class, "deleteUser", HttpMethod.DELETE);
		
		// 回调式路由
		$().get("/get", new RouteHandler() {
			@Override
			public void handle(Request request, Response response) {
				System.out.println("come get!!!");
				System.out.println("name = " + request.query("name"));
				request.attribute("base", request.contextPath());
				response.render("get.jsp");
			}
		});
	}

}
