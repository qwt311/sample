package blade.sample.interceptor;

import com.blade.interceptor.Interceptor;
import com.blade.web.http.Request;
import com.blade.web.http.Response;

import blade.kit.logging.Logger;
import blade.kit.logging.LoggerFactory;

public class BaseInterceptor implements Interceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseInterceptor.class);
	
	@Override
	public boolean before(Request request, Response response) {
		LOGGER.info("beofre ...");
		return true;
	}
	
	@Override
	public boolean after(Request request, Response response) {
		LOGGER.info("after ...");
		return true;
	}
	
}
