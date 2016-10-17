package com.orine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="member")
@Entity
public class Member {
	private int id;
	private String username;			//用户名
	private String password;			//密码
	private int gender = 0;					//性别，默认0未知，1男性，2女性
	private int type = 0;					//会员等级，1-9，9代表超级会员
	private long create_time = 0;			//创建时间
	private long edit_time = 0;				//编辑时间
	private int phone = 0;					//联系电话
	private String e_mail;				//邮箱
	private String city;				//所在城市
	private String province;    		//所在省份
	private String district; 			//所在行政区
	private String address;				//联系地址
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false, length=9)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="username",nullable=false,length=50)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password",nullable=false,length=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="gender",nullable=true,length=1)
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	@Column(name="type",nullable=true,length=1)
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Column(name="create_time",nullable=true,length=9)
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	
	@Column(name="edit_time",nullable=true,length=9)
	public long getEdit_time() {
		return edit_time;
	}
	public void setEdit_time(long edit_time) {
		this.edit_time = edit_time;
	}
	
	@Column(name="phone",nullable=true,length=9)
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	@Column(name="e_mail",nullable=true,length=50)
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	@Column(name="city",nullable=true,length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="province",nullable=true,length=20)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Column(name="district",nullable=true,length=20)
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Column(name="address",nullable=true,length=50)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender
				+ ", type=" + type + ", create_time=" + create_time + ", edit_time=" + edit_time + ", phone=" + phone
				+ ", e_mail=" + e_mail + ", city=" + city + ", province=" + province + ", district=" + district
				+ ", address=" + address + "]";
	}
	
}
