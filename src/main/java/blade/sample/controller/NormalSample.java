package blade.sample.controller;

import com.blade.web.http.Request;
import com.blade.web.http.Response;
import com.blade.web.multipart.FileItem;

import blade.kit.json.JSONObject;
import blade.sample.model.Person;

public class NormalSample {
	
	public String hello(Response response, Request request){
		System.out.println("进入hello~");
		request.attribute("name", "rose baby");
		return "hi";
	}
	
	public void saveUser(Request request, Response response){
		System.out.println("进入saveUser~");
		
		// test request.model()
		Person person = request.model("person", Person.class);
		System.out.println(person);
				
		// save操作
		JSONObject res = new JSONObject();
		res.put("status", 200);
		response.json(res.toString());
		
	}
	
	public void deleteUser(Request request, Response response){
		System.out.println("进入deleteUser~");
		// delete操作
		JSONObject res = new JSONObject();
		res.put("status", 200);
		response.json(res.toString());
	}
	
	public void saveImg(Request request, Response response){
		System.out.println("进入saveImg~");
		FileItem[] fileItems = request.files();
		if(null != fileItems && fileItems.length > 0){
			FileItem fileItem = fileItems[0];
			System.out.println(fileItem.getFileName());
			System.out.println(fileItem.getName());
			System.out.println(fileItem.getFile());
		}
		
	}
}