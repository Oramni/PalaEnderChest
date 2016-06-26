package fr.oramni.palaenderchest;

import java.sql.*;

import org.bukkit.entity.Player;

public class MySQL {

	private String url_base, host, name, username, password;
	private String table;
	private static Connection connection;
	
	public MySQL(String url_base, String host, String name, String username, String password, String table){
		
		this.url_base = url_base;
		this.host = host;
		this.name = name;
		this.username = username;
		this.password = password;
		this.table = table;
		
	}
	
	public String getEnderchest(String username) {
		String str = null;
		
		try{
			PreparedStatement sts = getConnection().prepareStatement("SELECT enderchest FROM "+table+" WHERE username = ?");
			sts.setString(1, username);
			ResultSet rs = sts.executeQuery();
			if(!rs.next()){
				return str;
			}
			str = rs.getString("enderchest");
			sts.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return str;
		
	}
	
	public void connection() {
		
		if(!isConnected()){
			try{
				connection = DriverManager.getConnection(url_base + host + "/" + name, username, password);
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void deconnection() {
		
		if(isConnected()){
			try{
				connection.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	private boolean isConnected(){
		try{
			if((connection == null) || (connection.isClosed()) || (!connection.isValid(5))){
				return false;
			}else{
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	private Connection getConnection(){
		
		
		return connection;
	}
	
	public void createAccount(Player p){
		
		try{
			
			PreparedStatement sts = getConnection().prepareStatement("SELECT enderchest FROM "+table+" WHERE username = ?");
			sts.setString(1, p.getName());
			ResultSet rs = sts.executeQuery();
			if(!rs.next()){
				sts.close();
				
				PreparedStatement sts2 = getConnection().prepareStatement("INSERT INTO "+table+" (username) VALUES (?)");
				sts2.setString(1, p.getName());
				sts2.setInt(2, 0);
				sts2.executeUpdate();
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	public void setEnderchest(String username, String base64){
		
		try{
			
			PreparedStatement sts = getConnection().prepareStatement("UPDATE "+table+" SET enderchest = ? WHERE username = ?");
			sts.setString(1, base64);
			sts.setString(2, username);
			sts.executeUpdate();
			sts.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
