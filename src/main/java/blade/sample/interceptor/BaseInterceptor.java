package blade.sample.interceptor;

import com.blade.annotation.After;
import com.blade.annotation.Interceptor;
import com.blade.web.http.Request;

@Interceptor
public class BaseInterceptor {
	
	@After("/.*")
	public void after(Request request){
		// 设置context path
		request.attribute("ctx", request.contextPath());
		
		System.out.println("after...");
	}
}
