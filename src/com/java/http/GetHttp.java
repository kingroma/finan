package com.java.http;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.nio.charset.Charset;

import java.text.SimpleDateFormat;

import java.util.Date;



import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;

import org.apache.http.impl.client.HttpClientBuilder;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import com.java.util.Msg;





public class GetHttp {
	public String readJsoup(String url){
		Msg.print("[[GetHttp.readJsoup]] url : connect"+url);
		try{
			Document doc = Jsoup.connect(url).get();
		    return doc.text();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String readOriginal(String url){
		try{
			// 2. ������ HTTP �ּ� ����
		    HttpPost http = new HttpPost(url);
	
		    // 3. �������⸦ ������ Ŭ���̾�Ʈ ��ü ����
		    HttpClient httpClient = HttpClientBuilder.create().build();
	
		    // 4. ���� �� ���� �����͸� Response ��ü�� ����
		    HttpResponse response = httpClient.execute(http);
	
		    // 5. Response ���� ������ ��, DOM �����͸� ������ Entity�� ����
		    HttpEntity entity = response.getEntity();
	
		    // 6. Charset�� �˾Ƴ��� ���� DOM�� ����Ʈ Ÿ���� ������ ��� Charset�� ������ 
		    ContentType contentType = ContentType.getOrDefault(entity);
	        Charset charset = contentType.getCharset();
	
	        // 7. DOM �����͸� �� �پ� �б� ���� Reader�� ���� (InputStream / Buffered �� ������ ��������) 
		    BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
	
		    // 8. ������ DOM �����͸� ������� �׸�
		    StringBuffer sb = new StringBuffer();
		    
		    // 9. DOM ������ ��������
		    String line = "";
		    while((line=br.readLine()) != null){
		    	sb.append(line+"\n");
		    }
		    
		    return sb.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	
	public static String getCurrentData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return sdf.format(new Date());
	}
}
