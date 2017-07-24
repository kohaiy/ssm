package cn.gqxqd.entity;

import java.util.Date;

public class User {
	private Integer uid;
	private String username;
	private String password;
	private String gender;
	private Date birthday;
	private String email;
	private String phone;

	public User(Integer uid, String username, String password, String gender, Date birthday, String email,
			String phone) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
	}

	public User() {
		super();
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", birthday=" + birthday + ", email=" + email + ", phone=" + phone + "]";
	}

}
