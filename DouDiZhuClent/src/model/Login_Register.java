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
			
			 this.setTitle("��¼");
			 this.setLayout(null);
			 //���ô������� 
		    getContentPane().setBackground(Color.orange);
			unameJLabel=new JLabel("�˺�:");
			 unameJLabel.setBounds(150, 100, 100, 25);
			unameJTextField=new JTextField();
			 unameJTextField.setBounds(200, 100, 150, 25);
			passwdJLabel=new JLabel("����:");
			passwdJLabel.setBounds(150, 150, 100, 25);
			passwdJTextField=new JPasswordField();
			 passwdJTextField.setBounds(200, 150, 150, 25);
			
			 btnJButton=new JButton("��¼");
			 btnJButton.setBounds(175, 200, 70, 25);
			 btnJButton.setForeground(Color.black);
			 btnJButton.setBackground(new Color(255,228,181));
			 registerJButton=new JButton("ע��");
			 registerJButton.setBounds(275, 200, 70, 25);
			 registerJButton.setForeground(Color.black);
			 registerJButton.setBackground(new Color(255,228,181));
			 
			 //��������������
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
		
			 //�������������� �󶨵���ť��
			 MyEvent1 myEvent=new MyEvent1();
			 this.btnJButton.addActionListener(myEvent);
			 MyEvent2 myEvent2=new MyEvent2();
			 this.registerJButton.addActionListener(myEvent2);
//			 this.setVisible(false);
			 
		 }
		 
		 //�����¼���������
		 class MyEvent1 implements ActionListener
		 {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					//�����¼			
					//1.����û���
					String uname=unameJTextField.getText();
					String passwd=new String(passwdJTextField.getPassword());
					Admin admin=new Admin();
					admin.setID(uname);
					admin.setPassword(passwd);
					Login login=new Login();
					login.setAdmin(admin);
				    //2.����һ��socket���ӷ�������
					try {
						 if(login.JudgeAdmin()==0) {
			                	//�����˺Ż��������Ĵ���
			                	JOptionPane.showMessageDialog(null, "�˺Ż��������", "�˺Ż��������", JOptionPane.WARNING_MESSAGE);
			                	//���������е���Ϣ
			                	passwdJTextField.setText("");
			                	//����˺ſ��е���Ϣ
			                	unameJTextField.setText("");
			                	
			                	//System.out.println("��½ʧ��");
			                } else {
			                	//������¼�ɹ��Ĵ���
			                	JOptionPane.showMessageDialog(null, "��½�ɹ�", "��½�ɹ�", JOptionPane.NO_OPTION);
			                	//���ȷ�������ת��������
			                	Socket socket=new Socket("127.0.0.1",8888);
//			                	.setVisible(false);
								//3.��ת�������� 
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
