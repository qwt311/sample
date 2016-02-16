package blade.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blade.Blade;
import com.blade.Bootstrap;
import com.blade.route.RouteHandler;
import com.blade.web.http.HttpMethod;
import com.blade.web.http.Request;
import com.blade.web.http.Response;

import blade.sample.controller.NormalSample;

public class App extends Bootstrap{

	Logger logger = LoggerFactory.getLogger(App.class);
	
	@Override
	public void init(Blade blade) {
		
		// 设置路由、拦截器包所在包
//		blade.isDev(true);
		blade.basePackage("blade.sample");
		
		// 函数式路由
		blade.route("/hello", NormalSample.class, "hello");
		blade.route("/save_user", NormalSample.class, "post:saveUser");
		blade.route("/delete_user", NormalSample.class, "deleteUser", HttpMethod.DELETE);
		
		// 回调式路由
		blade.get("/get", new RouteHandler() {
			@Override
			public void handle(Request request, Response response) {
				logger.info("come get!!!");
				logger.info("name = " + request.query("name"));
				request.attribute("base", request.contextPath());
				response.render("get");
			}
		});
		
		// 路由拦截
		blade.before("/.*", new RouteHandler() {
			@Override
			public void handle(Request request, Response response) {
				logger.info("before...");
				logger.info("正在执行：" + request.route().getAction() + "方法");
			}
		});
	}
	
}