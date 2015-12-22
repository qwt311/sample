package blade.sample.service.impl;

import com.blade.annotation.Component;

import blade.sample.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public void sayHello() {
		System.out.println("userserviceimpl say hello");
	}

}
