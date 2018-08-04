package com.java.parser;

import java.util.ArrayList;
import java.util.List;

public class NHN {
//https://finance.naver.com/item/sise_day.nhn?code=005930&page=1
	//네이버 금융 일별시세 
	//날짜 종가 전일비 시가 고가 저가 거래량 
	//2018.07.31 46,250 250 46,200 46,450 46,000 7,591,322 2018.07.30 46,500 400 46,550 46,800 46,350 5,723,035 2018.07.27 46,900 0 46,450 47,000 46,450 4,762,460 2018.07.26 46,900 750 46,100 47,000 46,000 7,374,946 2018.07.25 46,150 0 46,250 46,550 45,900 7,222,471 2018.07.24 46,150 350 46,350 46,600 45,950 8,261,363 2018.07.23 46,500 950 47,100 47,200 46,150 10,823,782 2018.07.20 47,450 550 47,000 47,600 46,700 10,474,547 2018.07.19 46,900 350 47,050 47,200 46,600 9,880,128 2018.07.18 46,550 700 46,700 47,200 46,450 10,952,645 페이지 네비게이션 1 2 3 4 5 6 7 8 9 10 다음 맨뒤
	//2018.07.31 46,250 250 46,200 46,450 46,000 7,591,322 2018.07.30 46,500 400 46,550 46,800 46,350 5,723,035 2018.07.27 46,900 0 46,450 47,000 46,450 4,762,460 2018.07.26 46,900 750 46,100 47,000 46,000 7,374,946 2018.07.25 46,150 0 46,250 46,550 45,900 7,222,471 2018.07.24 46,150 350 46,350 46,600 45,950 8,261,363 2018.07.23 46,500 950 47,100 47,200 46,150 10,823,782 2018.07.20 47,450 550 47,000 47,600 46,700 10,474,547 2018.07.19 46,900 350 47,050 47,200 46,600 9,880,128 2018.07.18 46,550 700 46,700 47,200 46,450 10,952,645 
	public List<ParserVO> parse(String str){
		List<ParserVO> list = new ArrayList<ParserVO>();
		try{
			str = str.substring("네이버 금융 일별시세 날짜 종가 전일비 시가 고가 저가 거래량 ".length());
			str = str.substring(0,str.indexOf("페이지 네비게이션"));
			String strSplit[] = str.split(" ");
			
			ParserVO vo = null;
			int index = 0;
			
			for(String current : strSplit){
				current = current.replace(",", "");
				switch(index){
				case 0: // 날짜 
					vo = new ParserVO();
					vo.setDate(current);
					break;
				case 1: // 종가  
					vo.setEndPrice(current);
					break;
				case 2: // 전일비 
					vo.setEndPrice(current);
					break;
				case 3: // 시가 
					vo.setStartPrice(current);
					break;
				case 4: // 고가
					vo.setMaxPrice(current);
					break;
				case 5: // 저가 
					vo.setMinPrice(current);
					break;
				case 6: // 거래량
					vo.setTansaction(current);
					list.add(vo);
					index=-1;
					break;
				}
				index++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
