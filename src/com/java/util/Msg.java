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
	
	public static void printParserVO(List<ParserVO> list){
		int index = 1;
		for(ParserVO vo : list){
			System.out.println("[[ "+index+" ]]");
			System.out.println(CntlProperty.msg("NHN.date")+" : "+vo.getDate());
			System.out.println(CntlProperty.msg("NHN.endPrice")+" : "+vo.getEndPrice());
			System.out.println(CntlProperty.msg("NHN.upDownSize")+" : "+vo.getUpDownSize());
			System.out.println(CntlProperty.msg("NHN.startPrice")+" : "+vo.getStartPrice());
			System.out.println(CntlProperty.msg("NHN.maxPrice")+" : "+vo.getMaxPrice());
			System.out.println(CntlProperty.msg("NHN.minPrice")+" : "+vo.getMinPrice());
			System.out.println(CntlProperty.msg("NHN.transaction")+" : "+vo.getTransaction());
			index++;
		}
	}
	
	private static String getCurrentData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return sdf.format(new Date());
	}
}
