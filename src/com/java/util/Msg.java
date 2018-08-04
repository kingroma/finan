package com.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.java.parser.ParserVO;

public class Msg {
	public static void print(String str){
		if(str!=null){
			System.out.println();
			System.out.print(getCurrentData()+" ");
			System.out.print(str);
			System.out.println();
		}
	}
	
	//날짜	종가	전일비	시가	고가	저가	거래량
	public static void printParserVO(List<ParserVO> list){
		int index = 1;
		for(ParserVO vo : list){
			System.out.println("[[ "+index+" ]]");
			System.out.println("날짜 : "+vo.getDate());
			System.out.println("종가 : "+vo.getEndPrice());
			System.out.println("전일비 : "+vo.getUpDownSize());
			System.out.println("시가 : "+vo.getStartPrice());
			System.out.println("고가 : "+vo.getMaxPrice());
			System.out.println("저가 : "+vo.getMinPrice());
			System.out.println("거래량 : "+vo.getTansaction());
			index++;
		}
	}
	
	private static String getCurrentData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return sdf.format(new Date());
	}
}
