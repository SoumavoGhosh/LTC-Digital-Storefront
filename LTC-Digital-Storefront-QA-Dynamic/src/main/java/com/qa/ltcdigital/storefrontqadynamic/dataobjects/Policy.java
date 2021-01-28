package com.qa.ltcdigital.storefrontqadynamic.dataobjects;

import com.qa.ltcdigital.storefrontqadynamic.util.TestUtil;
import com.qa.ltcdigital.storefrontqadynamic.util.XcelReader;

import java.util.ArrayList;

public class Policy {
	
	TestUtil util=null;
	XcelReader xclrdr=null;
	public String Policy_Number=null;
	public String Policy_Type=null;
	public String Policy_Status=null;
	public String Product_Name=null;
	public String Client_Name=null;
	
	public Policy(){
		util = new TestUtil();
		xclrdr = new XcelReader();
	}
	
	public void getPolicyData(String policy_num) throws Exception{
		String path = "C:\\Eclipse Workspace\\Workspace007\\LTC-Digital-Storefront-QA-Dynamic\\src\\test\\resources\\data-excel\\Policy_Data.xlsx";
		ArrayList<String> arlist = xclrdr.readXcelData(path, policy_num,"Policy_Number");
		
		Policy_Number=arlist.get(0);
		Policy_Type=arlist.get(1);
		Policy_Status=arlist.get(2);
		Product_Name=arlist.get(3);
		Client_Name=arlist.get(4);
	}
	
	public String verifyPolicyNumber(String policy_num) throws Exception{
		getPolicyData(policy_num);
		/*if(Policy_Type.equalsIgnoreCase("retail")){
			Policy_Number = "Policy:"+policy_num;
			return Policy_Number;
		}else if(Policy_Type.equalsIgnoreCase("group")){
			Policy_Number = "Coverage ID: "+policy_num;
			return Policy_Number;
		}*/
		return Policy_Number;
	}
	
	public String verifyProductName(){
		/*ArrayList<String> arr = new ArrayList<String>();
		arr.add("Product");
		arr.add(Product_Name);*/
		return Product_Name;
	}
	
	public /*ArrayList<String>*/ String verifyPolicyStatus(){
		//ArrayList<String> arr = new ArrayList<String>();
		if(Policy_Type.equalsIgnoreCase("retail")){
			
		}else if(Policy_Type.equalsIgnoreCase("group")){
			/*arr.add("Certificate status");
			arr.add(Policy_Status);
			return arr;*/
			return Policy_Status;
		}
		return null;
	}
	
	public /*ArrayList<String>*/ String verifyClientName(){
		/*ArrayList<String> arr = new ArrayList<String>();
		if(Policy_Type.equalsIgnoreCase("group")){
			arr.add("Client name");
			arr.add(Client_Name);
			return arr
		}
		return null;*/
		return Client_Name;
	}
}
