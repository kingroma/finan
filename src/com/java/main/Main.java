package com.java.main;

import java.util.List;

import com.java.db.Mapper;
import com.java.http.GetHttp;
import com.java.object.CommonVO;
import com.java.parser.NHN;
import com.java.util.Msg;

public class Main {
	
	// 005930 samsung
	public static String url = "https://finance.naver.com/item/sise_day.nhn?code=005930&page=1";
	
	public static void main(String[] args) {
		GetHttp http = new GetHttp();
		String data = http.readJsoup(url);
		System.out.println(data);
		
		NHN nhn = new NHN();
		List<CommonVO> nhnList = nhn.parse(data);
		Msg.printCommonVO(nhnList);
		
		/*
		for(CommonVO vo: nhnList) {
			DB_NHN db = new DB_NHN();
			db.insert(vo);
		}
		*?
		*
		*/
		CommonVO vo = new CommonVO();
		vo.setDate("2018-078-90");
		Mapper mapper = new Mapper("NHN");
		mapper.getQuery("isEntity",vo );
		
	}
	
	private void getDataFromNHN() {
		GetHttp http = new GetHttp();
		String data = http.readJsoup(url);
		System.out.println(data);
		
		NHN nhn = new NHN();
		List<CommonVO> nhnList = nhn.parse(data);
		Msg.printCommonVO(nhnList);
	}

}
