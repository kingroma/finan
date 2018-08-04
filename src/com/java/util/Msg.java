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
	
	//��¥	����	���Ϻ�	�ð�	��	����	�ŷ���
	public static void printParserVO(List<ParserVO> list){
		int index = 1;
		for(ParserVO vo : list){
			System.out.println("[[ "+index+" ]]");
			System.out.println("��¥ : "+vo.getDate());
			System.out.println("���� : "+vo.getEndPrice());
			System.out.println("���Ϻ� : "+vo.getUpDownSize());
			System.out.println("�ð� : "+vo.getStartPrice());
			System.out.println("�� : "+vo.getMaxPrice());
			System.out.println("���� : "+vo.getMinPrice());
			System.out.println("�ŷ��� : "+vo.getTansaction());
			index++;
		}
	}
	
	private static String getCurrentData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return sdf.format(new Date());
	}
}
