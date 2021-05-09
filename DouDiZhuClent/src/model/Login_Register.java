package model;
	import java.awt.Color;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;



public class Login_Register extends JFrame{    
		
		 private JLabel unameJLabel;
		 private JLabel passwdJLabel;
//		 private JPanel MainPanel;
		 private JTextField unameJTextField;
		 private JPasswordField passwdJTextField;
		 
		 private JButton btnJButton;
		 
		 private JButton registerJButton;
		 
		Login_Register() {
			
			init();
			 
			}
		public void init()
		 {
			
			 this.setTitle("登录");
			 this.setLayout(null);
			 //设置窗口属性 
		    getContentPane().setBackground(Color.orange);
			unameJLabel=new JLabel("账号:");
			 unameJLabel.setBounds(150, 100, 100, 25);
			unameJTextField=new JTextField();
			 unameJTextField.setBounds(200, 100, 150, 25);
			passwdJLabel=new JLabel("密码:");
			passwdJLabel.setBounds(150, 150, 100, 25);
			passwdJTextField=new JPasswordField();
			 passwdJTextField.setBounds(200, 150, 150, 25);
			
			 btnJButton=new JButton("登录");
			 btnJButton.setBounds(175, 200, 70, 25);
			 btnJButton.setForeground(Color.black);
			 btnJButton.setBackground(new Color(255,228,181));
			 registerJButton=new JButton("注册");
			 registerJButton.setBounds(275, 200, 70, 25);
			 registerJButton.setForeground(Color.black);
			 registerJButton.setBackground(new Color(255,228,181));
			 
			 //添加组件到窗口中
			 this.getContentPane().add(unameJLabel);
			 this.getContentPane().add(unameJTextField);
			 this.getContentPane().add(passwdJLabel);
			 this.getContentPane().add(passwdJTextField);
			 this.getContentPane().add(btnJButton);
			 this.getContentPane().add(registerJButton);
		
			 this.setBounds(100, 300, 500, 340);
			 this.setVisible(true);
			 this.setLocationRelativeTo(null);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			 //创建监听器对象 绑定到按钮上
			 MyEvent1 myEvent=new MyEvent1();
			 this.btnJButton.addActionListener(myEvent);
			 MyEvent2 myEvent2=new MyEvent2();
			 this.registerJButton.addActionListener(myEvent2);
//			 this.setVisible(false);
			 
		 }
		 
		 //创建事件监听器类
		 class MyEvent1 implements ActionListener
		 {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					//点击登录			
					//1.获得用户名
					String uname=unameJTextField.getText();
					String passwd=new String(passwdJTextField.getPassword());
					Admin admin=new Admin();
					admin.setID(uname);
					admin.setPassword(passwd);
					Login login=new Login();
					login.setAdmin(admin);
				    //2.创建一个socket链接服务器端
					try {
						 if(login.JudgeAdmin()==0) {
			                	//弹出账号或密码错误的窗口
			                	JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
			                	//清除密码框中的信息
			                	passwdJTextField.setText("");
			                	//清除账号框中的信息
			                	unameJTextField.setText("");
			                	
			                	//System.out.println("登陆失败");
			                } else {
			                	//弹出登录成功的窗口
			                	JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
			                	//点击确定后会跳转到主窗口
			                	Socket socket=new Socket("127.0.0.1",8888);
//			                	.setVisible(false);
								//3.跳转到主窗口 
								new MainFrame(uname,socket);
								dispose();
			                }
					
						
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				 
			 }
			 class MyEvent2 implements ActionListener
			 {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
						AdminRegister admin=new AdminRegister();
						dispose();
						
				}
				 
			 }
	
}
