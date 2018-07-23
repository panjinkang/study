package cn.richinfo.test.entity;

public class UserStatusDetailLogBean {
	private String appId;
	private String mobileNumber;
	private String status;
	private String registerTime;
	private String modifyTime;
	private String createTime;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "UserStatusDetailLogBean [appId=" + appId + ", mobileNumber=" + mobileNumber + ", status=" + status
				+ ", registerTime=" + registerTime + ", modifyTime=" + modifyTime + ", createTime=" + createTime + "]";
	}
	
}
