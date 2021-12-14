/*
 * Created by JFormDesigner on Mon Dec 13 14:50:20 CST 2021
 */

package view;

import VO.PeopleVO;
import entity.People;
import service.PeopleService;
import service.impl.PeopleServiceImpl;
import util.LoginRegisterSocket;
import util.MessageUtil;
import util.SwingUtil;
import util.TypeNumber;

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
public class RegisterView extends JFrame implements TypeNumber {
    public RegisterView() {
        this.setVisible(true);
        initComponents();
    }

    private void register(MouseEvent e) {
        String firstPassword = new String(passwordField1.getPassword());
        String againPassword = new String(passwordField2.getPassword());
        String username = usernameField.getText();
        if (!firstPassword.equals(againPassword)){
            JOptionPane.showMessageDialog(null,"两次密码不一致");
            SwingUtil.makeFieldToEmpty(passwordField1,passwordField2);
        }else {
            PeopleVO peopleVO = new PeopleVO(new People(null, username, firstPassword), REGISTER);
            Integer result = LoginRegisterSocket.getVOReturnMessage(peopleVO);
            if (result.equals(SUCCESS)){
                JOptionPane.showMessageDialog(null,"注册成功");
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(null,"系统重新错误！！");
                SwingUtil.makeFieldToEmpty(usernameField,passwordField1,passwordField2);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        usernameField = new JTextField();
        label4 = new JLabel();
        passwordField1 = new JPasswordField();
        label3 = new JLabel();
        passwordField2 = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u7528\u6237\u6ce8\u518c\u4e2d\u5fc3");
            label1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 22));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1);
            label1.setBounds(55, 25, 195, 45);

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d:");
            label2.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
            panel1.add(label2);
            label2.setBounds(30, 125, 75, 30);
            panel1.add(usernameField);
            usernameField.setBounds(105, 125, 180, usernameField.getPreferredSize().height);

            //---- label4 ----
            label4.setText("\u5bc6  \u7801\uff1a");
            label4.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
            panel1.add(label4);
            label4.setBounds(30, 210, 65, 25);
            panel1.add(passwordField1);
            passwordField1.setBounds(105, 205, 180, passwordField1.getPreferredSize().height);

            //---- label3 ----
            label3.setText("\u518d\u6b21\u8f93\u5165\u5bc6\u7801:");
            label3.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
            panel1.add(label3);
            label3.setBounds(5, 290, 95, 21);
            panel1.add(passwordField2);
            passwordField2.setBounds(105, 285, 180, passwordField2.getPreferredSize().height);

            //---- button1 ----
            button1.setText("\u6ce8\u518c");
            button1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    register(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(105, 400, 105, button1.getPreferredSize().height);

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
        panel1.setBounds(0, 0, 315, 490);

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
    private JTextField usernameField;
    private JLabel label4;
    private JPasswordField passwordField1;
    private JLabel label3;
    private JPasswordField passwordField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
