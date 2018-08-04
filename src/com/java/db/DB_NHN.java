package com.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java.object.CommonVO;
import com.java.util.Msg;


public class DB_NHN {
	private Database db;
	private Connection conn;
	private Statement s;
	private PreparedStatement ps;
	private ResultSet rs;
	private Mapper mapper;
	
	public DB_NHN() {
		db = new Database("NHN");
		mapper = new Mapper("NHN");
	}
	
	private void start() {
		if (conn == null) {
			db.start();
			this.conn = db.getConn();
		}
	}
	private void end() {
		if(conn != null) {
			db.end();
			try {
				if(s != null)
					s.close();
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean insert(CommonVO entity) {
		boolean returnValue = false;
		String msg = "insert fail";
		
		try {
			if(this.isEntity(entity)) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Msg.print(msg);
		return returnValue;
	}
	
	private boolean isEntity(CommonVO entity) {
		boolean returnValue = true;
		try {
			this.start();
			
			String sql = mapper.getQuery("isTable", entity);
			System.out.println(sql);
			rs = s.executeQuery(sql);
			
			if(rs != null && rs.next() ) {}
			else { returnValue = false; }
				
			this.end();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue;
	}
}
