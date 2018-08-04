package com.java.main;

import java.util.List;

import com.java.http.GetHttp;
import com.java.parser.NHN;
import com.java.util.Msg;
import com.java.parser.*;

public class Main {
	public static String url = "https://finance.naver.com/item/sise_day.nhn?code=015930&page=1";
	
	public static void main(String[] args) {
		GetHttp http = new GetHttp();
		String data = http.readJsoup(url);
		
		NHN nhn = new NHN();
		List<ParserVO> nhnList = nhn.parse(data);
		Msg.printParserVO(nhnList);
	}

}
