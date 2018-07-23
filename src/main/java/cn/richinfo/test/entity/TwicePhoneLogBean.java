package cn.richinfo.test.entity;


public class TwicePhoneLogBean {
	
	/*opType|msgId|timestamp|logTime|appId|apId|sign|mobileNumber|
	regTime|phoneStatus|resultCode|resultDesc */
	private Integer opType;
	private String msgId;
	private String timestamp;
	private String logTime;
	private String appId;
	private String apId;
	private String sign;
	private String mobileNumber;
	private String regTime;
	private String phoneStatus;
	private String resultCode;
	private String resultDesc;
	public Integer getOpType() {
		return opType;
	}
	public void setOpType(Integer opType) {
		this.opType = opType;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getApId() {
		return apId;
	}
	public void setApId(String apId) {
		this.apId = apId;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getPhoneStatus() {
		return phoneStatus;
	}
	public void setPhoneStatus(String phoneStatus) {
		this.phoneStatus = phoneStatus;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	@Override
	public String toString() {
		return "TwicePhoneLogBean [opType=" + opType + ", msgId=" + msgId + ", timestamp=" + timestamp + ", logTime="
				+ logTime + ", appId=" + appId + ", apId=" + apId + ", sign=" + sign + ", mobileNumber=" + mobileNumber
				+ ", regTime=" + regTime + ", phoneStatus=" + phoneStatus + ", resultCode=" + resultCode
				+ ", resultDesc=" + resultDesc + "]";
	}
	
}
