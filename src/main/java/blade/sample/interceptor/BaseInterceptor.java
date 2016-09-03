package blade.sample.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.interceptor.Interceptor;

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
