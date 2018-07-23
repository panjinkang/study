/**
 * 
 */
package cn.richinfo.test.entity;

/**
 * @author Administrator
 *
 */
public class PhoneStatusChangeLogBean {
	private Integer opType;
	private String msgId;
	private String timestamp;
	private String version;
	private String logTime;
	private String appId;
	private String numCount;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public String getNumCount() {
		return numCount;
	}
	public void setNumCount(String numCount) {
		this.numCount = numCount;
	}
	@Override
	public String toString() {
		return "PhoneStatusChangeLogBean [opType=" + opType + ", msgId=" + msgId + ", timestamp=" + timestamp
				+ ", version=" + version + ", logTime=" + logTime + ", appId=" + appId + ", numCount=" + numCount + "]";
	}
	
}
