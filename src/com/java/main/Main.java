package com.java.main;

import java.util.List;

import com.java.db.Database;
import com.java.http.GetHttp;
import com.java.parser.NHN;
import com.java.parser.ParserVO;
import com.java.util.Msg;

public class Main {
	
	// 005930 samsung
	public static String url = "https://finance.naver.com/item/sise_day.nhn?code=005930&page=1";
	
	public static void main(String[] args) {
		Database db = new Database();
		db.start();
		db.end();
	}
	
	private void getDataFromNHN() {
		GetHttp http = new GetHttp();
		String data = http.readJsoup(url);
		System.out.println(data);
		
		NHN nhn = new NHN();
		List<ParserVO> nhnList = nhn.parse(data);
		Msg.printParserVO(nhnList);
	}

}
