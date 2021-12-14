/*
 * Created by JFormDesigner on Mon Dec 13 14:33:31 CST 2021
 */

package view;

import VO.PeopleVO;
import entity.People;
import service.PeopleService;
import service.impl.PeopleServiceImpl;
import util.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.*;

/**
 * @author Admin
 */
public class LoginView extends JFrame implements TypeNumber {

    public LoginView() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void register(MouseEvent e) {
        new RegisterView();
        usernameField.setText("");
        passwordField.setText("");
    }

    private void Login(MouseEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        PeopleVO peopleVO = new PeopleVO(new People(null,username,password),LOGIN);
        Integer result = LoginRegisterSocket.getVOReturnMessage(peopleVO);
        if (result.equals(FAILED)){
            JOptionPane.showMessageDialog(null,"用户名或密码错误");
            SwingUtil.makeFieldToEmpty(passwordField);
        }else if (result.equals(SUCCESS)){
            TrainingContext.setLocal_User_Name(username);
            new MainView();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"服务器出现故障!");
            SwingUtil.makeFieldToEmpty(usernameField,passwordField);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        button1 = new JButton();
        label4 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u793e\u533a\u515a\u7fa4\u670d\u52a1\u4e2d\u5fc3");
            label1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 24));
            panel1.add(label1);
            label1.setBounds(110, 25, 315, 60);

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d\uff1a");
            label2.setFont(new Font("\u534e\u6587\u6977\u4f53", Font.BOLD, 16));
            panel1.add(label2);
            label2.setBounds(65, 140, 100, 25);

            //---- label3 ----
            label3.setText("\u5bc6  \u7801\uff1a");
            label3.setFont(new Font("\u534e\u6587\u6977\u4f53", Font.BOLD, 16));
            panel1.add(label3);
            label3.setBounds(65, 190, 70, 21);
            panel1.add(usernameField);
            usernameField.setBounds(155, 140, 160, usernameField.getPreferredSize().height);
            panel1.add(passwordField);
            passwordField.setBounds(155, 185, 160, passwordField.getPreferredSize().height);

            //---- button1 ----
            button1.setText("\u767b\u5f55");
            button1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 15));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Login(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(175, 270), button1.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u6ca1\u6709\u8d26\u6237\uff1f\u70b9\u6211\u6ce8\u518c...");
            label4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    register(e);
                }
            });
            panel1.add(label4);
            label4.setBounds(175, 220, 150, 15);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 435, 325);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton button1;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
