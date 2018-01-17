package com.mall.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;

import org.apache.commons.io.FileUtils;

import com.mall.entity.AttendanceSheet;
import com.mall.service.AdminService;
import com.mall.tools.Tools;

@MultipartConfig
public class AdminAction {
	
	private long checking_in_time;
	private long checking_out_time;
	private Integer uid;
	
    private File photo;  
    private String photoFileName;  
	
	private String result;
	private Map<Integer, String> asMap = new HashMap<Integer, String>();
	
	private String getParam;
	
	private AdminService adminService; 
	
	public String checking_in(){
		
		if ( adminService.saveChecking_in_Record(getASObject(uid, checking_in_time)) ) result = "checking-in success";
		
		else result = "checking-in failed";
		
		return "success";
	}
	
	public String checking_out(){
		
		System.out.println("管理员签退-->" + checking_out_time+ " id " + uid);
		
		if ( adminService.saveChecking_out_Record(getASObject(uid, checking_out_time,1)) ) 
			result = "checking-out success";
		
		else result = "checking-out failed";
		
		return "success";
	}
	
	public String checking_sum(){
		
		System.out.println("该管理员该月考勤汇总表生成-->"+ uid);
		
		asMap = adminService.getASTByUID(uid);
		
		if ( asMap.size() == 0 ) result = "没有查询到该月您的考勤记录";
		
		else result = "attendance table have been generated";
		
		return "success";
	}
	
	
	public String upload_HP(){
		System.out.println(photoFileName);
		String filePath="" ;
		try{
			filePath = "D:/upload/ssh";
			File dirFile = new File(filePath);
			if(dirFile.exists() == false ){
				dirFile.mkdir();
			}
			File destFile = new File(filePath+File.separator+photoFileName);
			FileUtils.copyFile(this.getPhoto() , destFile);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			result = "upload failed";
		}
		result = "upload success";
		return "success";

	}
	
	public String testGet(){
		
		//System.out.println("get请求参数:"+getParam);
		
		try {
			
			System.out.println("get请求参数:"+URLDecoder.decode(getParam, "UTF-8"));
			
		} catch (UnsupportedEncodingException e) {
			
			System.out.println(e.getMessage());
		}
		
		result = "test get success";
		
		return "success";
	}
	
/*****************************************************************/
	
	public long getChecking_in_time() {
		return checking_in_time;
	}

	public void setChecking_in_time(long checking_in_time) {
		this.checking_in_time = checking_in_time;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getGetParam() {
		return getParam;
	}

	public void setGetParam(String getParam) {
		this.getParam = getParam;
	}

	public long getChecking_out_time() {
		return checking_out_time;
	}

	public void setChecking_out_time(long checking_out_time) {
		this.checking_out_time = checking_out_time;
	}
	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Map<Integer, String> getAsMap() {
		return asMap;
	}

	public void setAsMap(Map<Integer, String> asMap) {
		this.asMap = asMap;
	}
	
	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

/*****************************************************************/

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
/*****************************************************************/	
	
	public AttendanceSheet getASObject(Integer uid, long time){
		
		AttendanceSheet as = new AttendanceSheet();
		
		//通过uid 去找到 adminName
		as.setAdminName(adminService.getAdminNameByUID(uid));
		as.setCheckingInTime(Tools.getTimestamp(time));
		
		return as;
	}
	
	public AttendanceSheet getASObject(Integer uid, long time, Integer i){
		
		AttendanceSheet as = new AttendanceSheet();
		
		//通过uid 去找到 adminName
		as.setAdminName(adminService.getAdminNameByUID(uid));
		as.setCheckingOutTime(Tools.getTimestamp(time));
		
		return as;
	}
}
