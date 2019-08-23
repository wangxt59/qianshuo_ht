package com.qianshuo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * user实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private Long id;//主键


	@Column
	private String openId;//微信openid
	@Column
	private String name;//用户名
	@Column
	private String account;//账号
	@Column
	private String password;//密码
	@Column
	private String email;//邮箱
	@Column
	private String phone;//手机
	@Column
	private Integer sex;//性别: 1:男  2:女  3:不确定
	@Column
	private String address;//送货住址
	@Column
	private String province;//省市县
	@Column
	private String balance;//余额
	@Column
	private Double point;//当前总积分
	@Column
	private Integer state;//状态 0: 正常  1:锁定 2:待激活
	@Column
	private java.util.Date createDate;//创建日期
	@Column
	private java.util.Date updateDate;//更新日期
	@Column
	private java.util.Date lastDate;//last_date
	@Column
	private Integer fanscount;//fanscount
	@Column
	private Integer followcount;//followcount
	@Column
	private Integer online;//online
	@Column
	private String avatar;//avatar
	@Column
	private String nickname;//nickname

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.util.Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(java.util.Date lastDate) {
		this.lastDate = lastDate;
	}

	public Integer getFanscount() {
		return fanscount;
	}
	public void setFanscount(Integer fanscount) {
		this.fanscount = fanscount;
	}

	public Integer getFollowcount() {
		return followcount;
	}
	public void setFollowcount(Integer followcount) {
		this.followcount = followcount;
	}

	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}

	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	
}
