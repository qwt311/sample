package blade.sample.model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 3075041752586016364L;

	private Integer pid;
	private String user_name;
	private Long allcount;
	private Date birthday;
	
	public Person() {
	}
	
	public Person(Integer pid, String user_name, Long allcount, Date birthday) {
		this.pid = pid;
		this.user_name = user_name;
		this.allcount = allcount;
		this.birthday = birthday;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Long getAllcount() {
		return allcount;
	}

	public void setAllcount(Long allcount) {
		this.allcount = allcount;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", user_name=" + user_name
				+ ", allcount=" + allcount + ", birthday=" + birthday + "]";
	}
	
}
