package com.mnq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Processor {
	
	private static final Map<String, Double> conversionMap=new HashMap<>();
	static{
		conversionMap.put("INR", 69.23D);
		conversionMap.put("USD", 1D);
		conversionMap.put("AUD", 1.41D);
	}
	
	
	private static List<ClientInfo> getClintInfo(){
		
		ClientInfo [] clients = {new ClientInfo("INDIA", "New Delhi", "M",  "INR", 454365D),
								new ClientInfo("INDIA", "New Delhi", "F",  "INR", 98877D),
								new ClientInfo("INDIA", "Mumbai", "F",  "INR", 77077D),
								new ClientInfo("INDIA", "Mumbai", "M",  "INR", 78077D),
								new ClientInfo("INDIA", "Delhi", "F",  "INR", 99077D),
								new ClientInfo("", "Luckhnow", "F",  "INR", 99077D),
								new ClientInfo("", "Luckhnow", "M",  "INR", 999077D),
								new ClientInfo("USA", "New York", "F",  "USD", 99077D),
								new ClientInfo("USA", "New York", "F",  "USD", 999077D),
								new ClientInfo("USA", "Wahington", "F",  "USD", 97677D),
								new ClientInfo("USA", "Wahington", "M",  "USD", 989077D),
								new ClientInfo("USA", "Wahington", "M",  "USD", 983077D),
								new ClientInfo("AUS", "Sydney", "M",  "AUD", 803077D),
								new ClientInfo("AUS", "Perth", "F",  "AUD", 863077D),
		};
		return Arrays.asList(clients);
	} 
	
	private  static Map<String,List<ClientInfo>> getResultMap(String key, List<ClientInfo> clientList, 
			ClientInfo male, ClientInfo female){
		
		Map<String, List<ClientInfo>> clintInfoResultMap=new TreeMap<>();
		List<ClientInfo> clientResultList = new ArrayList<>();
		Double avgIncomeMale=0D;
		Double avgIncomeFemale=0D;
		int femaleCounter =0;
		int maleCounter =0;
		
		for (ClientInfo clientInfo : clientList) {
			
			if (clientInfo.getCountry().equals("")) {
				
				if (key.equals(clientInfo.getCity())) {

					
					if (clientInfo.getGender().equals("M")) {
						
						male.setCity(clientInfo.getCity());
						male.setCountry(key);
						male.setCurrency(clientInfo.getCurrency());
						avgIncomeMale = avgIncomeMale+clientInfo.getAverageIncome();
						maleCounter++;
						
					} else {
						female.setCity(clientInfo.getCity());
						female.setCountry(key);
						female.setCurrency(clientInfo.getCurrency());
						avgIncomeFemale = avgIncomeFemale+clientInfo.getAverageIncome();
						femaleCounter++;
					}
					
				
				}	
				
			}else {
				
				if (key.equals(clientInfo.getCountry())) {
					
					if (clientInfo.getGender().equals("M")) {
						
						male.setCity(clientInfo.getCity());
						male.setCountry(key);
						male.setCurrency(clientInfo.getCurrency());
						avgIncomeMale = avgIncomeMale+clientInfo.getAverageIncome();
						maleCounter++;
						
					} else {
						female.setCity(clientInfo.getCity());
						female.setCountry(key);
						female.setCurrency(clientInfo.getCurrency());
						avgIncomeFemale = avgIncomeFemale+clientInfo.getAverageIncome();
						femaleCounter++;
					}
					
				}
				
			}
			
		}
		female.setAverageIncome(avgIncomeFemale/(femaleCounter*conversionMap.get(female.getCurrency())));
		male.setAverageIncome(avgIncomeMale/(maleCounter*conversionMap.get(male.getCurrency())));
		
		clientResultList.add(male);
		clientResultList.add(female);
		clintInfoResultMap.put(key, clientResultList);
		
		
		return clintInfoResultMap;
	}
	
	public static void main(String[] args) {
		
		List<ClientInfo> clintInfo = getClintInfo();
		Map<String, ClientInfo> clintInfoMap=new TreeMap<>();
		
		
		for (ClientInfo clientInfo : clintInfo) {
			if (clientInfo.getCountry().equals("")) {
				clintInfoMap.put(clientInfo.getCity(), clientInfo);
			} else {
				clintInfoMap.put(clientInfo.getCountry(), clientInfo);
			}
			
		}
		
		//System.out.println(clintInfoMap);
		
		
		Set<String> keySet = clintInfoMap.keySet();
		for (String string : keySet) {
			
			ClientInfo male =new ClientInfo();
			male.setGender("M");
			ClientInfo female =new ClientInfo();
			female.setGender("F");
			
			
			Map<String, List<ClientInfo>> resultMap = getResultMap(string, getClintInfo(), male, female);
			System.out.println(resultMap);
			
		}
	}
}
