package com.weichat.message;

/** 
 * <pre>
 * 任务：
 * 描述：附件医院信息的model
 * 作者：屈剑飞
 * 时间：2015年1月20日上午9:40:15
 * 类名: Hospital 
 * </pre>
*/
public class Hospital {
	
	private int hospitalId;
	private int cityId;
	private String HospitalName;
	private String unitCodeUNIT_CODE;
	private String MailingAddress;
	private String zipCode;
	private Double longitude;//经度
	private Double latitude;//纬度
	private String hospitalProperty;
	private String hospitalLevel;
	private String hospitalNumber;
	private String linkMan;
	private String bankDepositAddress;
	private String bankAccount;
	private String termailAdd;
	private String frontAdd;
	private String status;
	private String operatorName;
	private String operatorDate;
	private String description;
	private String logoPhoto;
	



	public Hospital(){
		
	}
	
	public Hospital(int HosptalId,int cityId,String HospitalName,String MailingAddress,double longitude,double latitude,String hospitalLevel){
		this.hospitalId = HosptalId;
		this.cityId = cityId;
		this.HospitalName = HospitalName;
		this.MailingAddress = MailingAddress;
		this.longitude = longitude;
		this.latitude = latitude;
		this.hospitalLevel = hospitalLevel;
	}
	
	public Hospital(int HosptalId,int cityId,String HospitalName,String MailingAddress,double longitude,double latitude,
			String description,String logoPhoto,String hospitalLevel){
		this.hospitalId = HosptalId;
		this.cityId = cityId;
		this.HospitalName = HospitalName;
		this.MailingAddress = MailingAddress;
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
		this.logoPhoto = logoPhoto;
		this.hospitalLevel = hospitalLevel;
	}
	
	public String getLogoPhoto() {
		return logoPhoto;
	}

	public void setLogoPhoto(String logoPhoto) {
		this.logoPhoto = logoPhoto;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getHospitalName() {
		return HospitalName;
	}
	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
	}
	public String getUnitCodeUNIT_CODE() {
		return unitCodeUNIT_CODE;
	}
	public void setUnitCodeUNIT_CODE(String unitCodeUNIT_CODE) {
		this.unitCodeUNIT_CODE = unitCodeUNIT_CODE;
	}
	public String getMailingAddress() {
		return MailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		MailingAddress = mailingAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getHospitalProperty() {
		return hospitalProperty;
	}
	public void setHospitalProperty(String hospitalProperty) {
		this.hospitalProperty = hospitalProperty;
	}
	public String getHospitalLevel() {
		return hospitalLevel;
	}
	public void setHospitalLevel(String hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}
	public String getHospitalNumber() {
		return hospitalNumber;
	}
	public void setHospitalNumber(String hospitalNumber) {
		this.hospitalNumber = hospitalNumber;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getBankDepositAddress() {
		return bankDepositAddress;
	}
	public void setBankDepositAddress(String bankDepositAddress) {
		this.bankDepositAddress = bankDepositAddress;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getTermailAdd() {
		return termailAdd;
	}
	public void setTermailAdd(String termailAdd) {
		this.termailAdd = termailAdd;
	}
	public String getFrontAdd() {
		return frontAdd;
	}
	public void setFrontAdd(String frontAdd) {
		this.frontAdd = frontAdd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getOperatorDate() {
		return operatorDate;
	}
	public void setOperatorDate(String operatorDate) {
		this.operatorDate = operatorDate;
	}
	
}
