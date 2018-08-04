package com.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.java.util.CntlProperty;

public class Database {
	private Connection conn = null;
	private String db_jdbc;
	private String db_url;
	private String db_id;
	private String db_pw;
	
	public Database() {
		init();
	}
	
	public void init() {
		String type = CntlProperty.msg("database.type");
		
		switch(type) {
		case "mysql" :
			db_jdbc = "com.mysql.jdbc.Driver";
			db_url = CntlProperty.msg("mysql.url");
			db_id = CntlProperty.msg("mysql.id");
			db_pw = CntlProperty.msg("mysql.pw");
			break;
		}
	}
	
	public boolean start(){
        try {
            Class.forName(db_jdbc);
            conn = DriverManager.getConnection(db_url,db_id,db_pw);
            System.out.println("db [[ START ]]");

        }catch(Exception e) {
        	e.printStackTrace();
        	return false;
        }
        return true;
    }
	
	public boolean end(){
		try {
            if (conn != null) conn.close();
            conn = null;
            System.out.println("db [[ END ]]");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
