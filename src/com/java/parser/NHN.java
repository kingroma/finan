package com.java.parser;

import java.util.ArrayList;
import java.util.List;

import com.java.object.CommonVO;
import com.java.util.CntlProperty;

public class NHN {
//https://finance.naver.com/item/sise_day.nhn?code=005930&page=1
	 
	//2018.07.31 46,250 250 46,200 46,450 46,000 7,591,322 2018.07.30 46,500 400 46,550 46,800 46,350 5,723,035 2018.07.27 46,900 0 46,450 47,000 46,450 4,762,460 2018.07.26 46,900 750 46,100 47,000 46,000 7,374,946 2018.07.25 46,150 0 46,250 46,550 45,900 7,222,471 2018.07.24 46,150 350 46,350 46,600 45,950 8,261,363 2018.07.23 46,500 950 47,100 47,200 46,150 10,823,782 2018.07.20 47,450 550 47,000 47,600 46,700 10,474,547 2018.07.19 46,900 350 47,050 47,200 46,600 9,880,128 2018.07.18 46,550 700 46,700 47,200 46,450 10,952,645 ������ �׺���̼� 1 2 3 4 5 6 7 8 9 10 ���� �ǵ�
	//2018.07.31 46,250 250 46,200 46,450 46,000 7,591,322 2018.07.30 46,500 400 46,550 46,800 46,350 5,723,035 2018.07.27 46,900 0 46,450 47,000 46,450 4,762,460 2018.07.26 46,900 750 46,100 47,000 46,000 7,374,946 2018.07.25 46,150 0 46,250 46,550 45,900 7,222,471 2018.07.24 46,150 350 46,350 46,600 45,950 8,261,363 2018.07.23 46,500 950 47,100 47,200 46,150 10,823,782 2018.07.20 47,450 550 47,000 47,600 46,700 10,474,547 2018.07.19 46,900 350 47,050 47,200 46,600 9,880,128 2018.07.18 46,550 700 46,700 47,200 46,450 10,952,645 
	public List<CommonVO> parse(String str){
		List<CommonVO> list = new ArrayList<CommonVO>();
		try{
			str = str.substring(CntlProperty.msg("NHN.startTxt").length());
			str = str.substring(0,str.indexOf(CntlProperty.msg("NHN.endTxt")));
			String strSplit[] = str.split(" ");
			
			CommonVO vo = null;
			int index = 0;
			
			for(String current : strSplit){
				current = current.replace(",", "");
				switch(index){
				case 0: //  
					vo = new CommonVO();
					vo.setDate(current);
					break;
				case 1: //  
					vo.setEndPrice(current);
					break;
				case 2: // 
					vo.setUpDownPrice(current);
					break;
				case 3: //  
					vo.setStartPrice(current);
					break;
				case 4: // 
					vo.setMaxPrice(current);
					break;
				case 5: // 
					vo.setMinPrice(current);
					break;
				case 6: // 
					vo.setTransaction(current);
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
