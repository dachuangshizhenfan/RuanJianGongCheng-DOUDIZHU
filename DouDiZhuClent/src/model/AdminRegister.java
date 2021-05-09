package model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class AdminRegister extends JFrame{
	 JLabel nameStr ;
	 JLabel IDStr ;
	  JLabel passwordStr;
	  JLabel confrimStr;
	  JTextField userName;
	  JTextField userID;
	  JPasswordField password;
	  JPasswordField confrimPassword;
	  JButton buttonregister;
	AdminRegister () {
		init();
	}
	void init() {
           this.setTitle("ע�����Ա�˺�");
            this.setLayout(null);
            
            nameStr = new JLabel("�û���:");
            nameStr.setBounds(250, 150, 100, 25);
         
            IDStr = new JLabel("�˺�:");
            IDStr.setBounds(250, 200, 100, 25);
            this.add(IDStr);

            passwordStr = new JLabel("����:");
            passwordStr.setBounds(250, 250, 100, 25);
            this.add(passwordStr);  
               
             confrimStr = new JLabel("ȷ������:");
            confrimStr.setBounds(250, 300, 100, 30);
            this.add(confrimStr);
            
             userName = new JTextField();
            userName.setBounds(320, 150, 150, 25);
            this.add(userName);

             userID = new JTextField();
            userID.setBounds(320, 200, 150, 25);
            this.add(userID);

             password = new JPasswordField();
            password.setBounds(320, 250, 150, 25);
            this.add(password);

             confrimPassword = new JPasswordField();
            confrimPassword.setBounds(320, 300, 150, 25);
            this.add(confrimPassword);
            
            buttonregister = new JButton("ע��");
            buttonregister.setBounds(350, 350, 70, 25);
            this.add(buttonregister);
            this.getContentPane().add(nameStr);
            this.getContentPane().add(IDStr);
            this.getContentPane().add(passwordStr);
            this.getContentPane().add(confrimStr);
            this.getContentPane().add(userName);
            this.getContentPane().add(userID);
            this.getContentPane().add(password);
            this.getContentPane().add(confrimPassword);
            this.getContentPane().add(buttonregister);
        

            this.setBounds(400, 100, 800, 640);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
          //Ϊע�ᰴť���Ӽ�����
            MyEvent myEvent=new MyEvent();
			 buttonregister.addActionListener(myEvent);
	}		
			 class MyEvent implements ActionListener{
         
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = userName.getText();
                    String ID = userID.getText();
                    String passwd = new String (password.getPassword());
                    String confrimpasswd = new String (confrimPassword.getPassword());
                    
                    //����Register��
                    Register register = new Register();
                    register.setID(ID);
                    register.setName(name);
                    register.setPassword(passwd);
                    register.setconfirmpasswd(confrimpasswd);
                    
                    //���ע��ɹ������ص�¼����
                    try {
						if(register.JudgeRegister()) {
							System.out.println("ע��ɹ���");
						    Login_Register login_register = new Login_Register();
						    dispose();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                }
                
            }
	}
