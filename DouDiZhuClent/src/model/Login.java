package model;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	Admin admin;
	void setAdmin(Admin admin) {
		this.admin=admin;
	}
	
	private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "123456";
    
    public boolean login(Admin admin) throws SQLException, ClassNotFoundException {
    	String sql="select * from admin where id=? and password=?";
    	Class.forName(driver);
    	Connection conn = DriverManager.getConnection(url, user, password);
    	PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, admin.getID());
        ps.setString(2, admin.getPassword());
        ResultSet rs = ps.executeQuery();
        int ans = 0;
        if(rs.next()) {
        	ans = 1;
        }  
        rs.close();
        ps.close();
        conn.close();
        if(ans == 1) {
        	return true;
        }
        else return false;
    }
public int JudgeAdmin() {

	    try {
	        if(login(this.admin)) {
	        	System.out.println("µÇÂ¼³É¹¦");
	        	return 1;
	        }else {
	            return 0;
	        }
	    }catch(Exception e) {
	       
	    }
	return 0;
	
}	
}

	 
	
	 

