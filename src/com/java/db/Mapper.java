package com.java.db;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.java.util.CntlProperty;

public class Mapper {
	private String path;
	private String suffix;
	private File file;
	private Document doc;
	public Mapper(String suffix) {
		this.suffix = suffix;
		init();
	}
	
	private void init() {
		this.path = CntlProperty.msg("mapper.path")+suffix+"/mapper.xml";
		this.file = new File(path);
		try {
			DocumentBuilderFactory docBuildFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = docBuildFact.newDocumentBuilder();
			this.doc = docBuild.parse(file);
			this.doc.getDocumentElement().normalize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getQuery(String id , Object obj) {
		String returnValue = null;
		boolean flag = false;
		String[] tagNames = {"select","insert","update","delete"};
		
		for(String tagName : tagNames) {
			NodeList list = doc.getElementsByTagName(tagName);
			for(int i = 0 ; i < list.getLength() ; i ++) {
				Element e = (Element) list.item(i);
				String tagId = e.getAttribute("id");
				String tagNm = e.getTagName();
				String tagTxt = e.getFirstChild().getNodeValue();
				
				if(tagNm.equals(tagName) && tagId.equals(id)) {
					returnValue = tagTxt;
					
					Map<String,String> map = this.getObjectToMap(obj);
					for(String key : map.keySet()) {
						String value = map.get(key);
						returnValue = returnValue.replace("#{"+key+"}", "'"+value+"'");
					}
					
					System.out.println(returnValue);
					
					flag = true;
					break;
				}
			}
			if(flag)
				break;
		}
		
		return returnValue;
	}
	
	private Map<String,String> getObjectToMap(Object obj) {
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			for(Field f : obj.getClass().getDeclaredFields()) {
				String key = f.getName();
				String value = (String) 
					obj.getClass().getMethod("get"+capitalize(key)).invoke(obj);
				if(value == null) {
					value = "";
				}
				//System.out.println(key + '=' + value);
				map.put(key, value);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	private String capitalize(final String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
	
	
}
