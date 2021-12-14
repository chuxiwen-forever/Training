/*
 * Created by JFormDesigner on Mon Dec 13 15:07:01 CST 2021
 */

package view;

import VO.AppealVO;
import VO.SiteVO;
import VO.ApplyVO;
import VO.VO;
import service.ActivityService;
import service.AnnouncementService;
import service.CommentServer;
import service.impl.ActivityServiceImpl;
import service.impl.AnnouncementServiceImpl;
import service.impl.CommentServerImpl;
import util.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;

/**
 * @author Admin
 */
public class MainView extends JFrame implements TypeNumber {
    private static CommentServer commentServer = new CommentServerImpl();

    public MainView() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        ShowInSwing.showAllComment(editorPane1);
        ShowInSwing.showAnnouncement(announcement);
        ShowInSwing.showActivity(activity);
    }

    /**
     * Appeal
     */
    //发送诉求
    private void bingo(MouseEvent e) {
        List<String> stringList = SwingUtil.getFieldToString(title, content, note);
        AppealVO appealVO = new AppealVO(stringList.get(0),stringList.get(1),stringList.get(2));
        Integer message = LoginRegisterSocket.getVOReturnMessage(appealVO);
        if (message.equals(SUCCESS)){
            JOptionPane.showMessageDialog(null,"感谢您的反馈!");
        }else{
            JOptionPane.showMessageDialog(null,"系统出现故障!");
        }
        SwingUtil.makeFieldToEmpty(title,content,note);
    }

    //得到自己的诉求信息
    private void getLocalAppeal(MouseEvent e) {
        // TODO add your code here
    }

    /**
     * Comment
     */
    //发表评论
    private void deliverComment(MouseEvent e) {
        String comment = textArea1.getText();
        commentServer.giveOutComment(comment);
        JOptionPane.showMessageDialog(null,"发表成功！");
        SwingUtil.makeFieldToEmpty(textArea1);
        ShowInSwing.showAllComment(editorPane1);
    }


    /**
     * Site
     */

    //申请场地
    private void appealSite(MouseEvent e) {
        List<String> field = SwingUtil.getFieldToString(siteName, siteType, siteUseage, siteNote, siteStatus, siteIntro);
        SiteVO siteVO = new SiteVO(field.get(0),field.get(1),field.get(2),field.get(3),field.get(4),field.get(5));
        Integer message = LoginRegisterSocket.getVOReturnMessage(siteVO);
        if (message.equals(SUCCESS)){
            JOptionPane.showMessageDialog(null,"提交成功，等待管理员同意");
        }else {
            JOptionPane.showMessageDialog(null,"服务器出现故障！！！");
        }
        SwingUtil.makeFieldToEmpty(siteName,siteType,siteUseage,siteNote,siteStatus,siteIntro);
    }

    /**
     *Apply
     */
    //参加活动
    private void AttendActivity(MouseEvent e) {
        List<String> stringList = SwingUtil.getFieldToString(activityCase, activityId);
        ApplyVO applyVO = new ApplyVO(stringList.get(0),Integer.parseInt(stringList.get(1)));
        Integer message = LoginRegisterSocket.getVOReturnMessage(applyVO);
        if (message.equals(SUCCESS)){
            JOptionPane.showMessageDialog(null,"请求已发送,等待管理员审核！");
        }else {
            JOptionPane.showMessageDialog(null,"服务器出现故障！");
        }
        SwingUtil.makeFieldToEmpty(activityCase,activityId);
    }


    //退出登录
    private void logout(MouseEvent e) {
        this.dispose();
        new NotLoginView();
    }

    //和管理员聊天
    private void sendMessage(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane10 = new JScrollPane();
        announcement = new JEditorPane();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        activity = new JEditorPane();
        label13 = new JLabel();
        activityId = new JTextField();
        label14 = new JLabel();
        scrollPane11 = new JScrollPane();
        activityCase = new JTextArea();
        button6 = new JButton();
        panel4 = new JPanel();
        label1 = new JLabel();
        siteName = new JTextField();
        label8 = new JLabel();
        siteType = new JTextField();
        label9 = new JLabel();
        scrollPane6 = new JScrollPane();
        siteUseage = new JTextArea();
        label10 = new JLabel();
        scrollPane7 = new JScrollPane();
        siteNote = new JTextArea();
        label11 = new JLabel();
        scrollPane8 = new JScrollPane();
        siteStatus = new JTextArea();
        label12 = new JLabel();
        scrollPane9 = new JScrollPane();
        siteIntro = new JTextArea();
        button5 = new JButton();
        panel5 = new JPanel();
        scrollPane4 = new JScrollPane();
        editorPane1 = new JEditorPane();
        scrollPane5 = new JScrollPane();
        textArea1 = new JTextArea();
        button4 = new JButton();
        panel6 = new JPanel();
        scrollPane12 = new JScrollPane();
        chat = new JEditorPane();
        scrollPane13 = new JScrollPane();
        chatFiled = new JTextArea();
        button7 = new JButton();
        panel2 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        title = new JTextField();
        scrollPane2 = new JScrollPane();
        content = new JTextArea();
        scrollPane3 = new JScrollPane();
        note = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        label6 = new JLabel();
        label7 = new JLabel();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //======== scrollPane10 ========
                {
                    scrollPane10.setViewportView(announcement);
                }
                panel1.add(scrollPane10);
                scrollPane10.setBounds(0, 0, 840, 495);

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
            tabbedPane1.addTab("\u516c\u544a", panel1);

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //======== scrollPane1 ========
                {

                    //---- activity ----
                    activity.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 8));
                    activity.setEditable(false);
                    scrollPane1.setViewportView(activity);
                }
                panel3.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 475, 490);

                //---- label13 ----
                label13.setText("\u53c2\u52a0\u7684\u6d3b\u52a8\u7f16\u53f7:");
                label13.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                panel3.add(label13);
                label13.setBounds(505, 35, 125, 20);
                panel3.add(activityId);
                activityId.setBounds(635, 30, 155, activityId.getPreferredSize().height);

                //---- label14 ----
                label14.setText("\u53c2\u52a0\u539f\u56e0:");
                label14.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                panel3.add(label14);
                label14.setBounds(510, 120, 115, 25);

                //======== scrollPane11 ========
                {

                    //---- activityCase ----
                    activityCase.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 14));
                    scrollPane11.setViewportView(activityCase);
                }
                panel3.add(scrollPane11);
                scrollPane11.setBounds(525, 160, 290, 220);

                //---- button6 ----
                button6.setText("\u63d0\u4ea4");
                button6.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                button6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        AttendActivity(e);
                    }
                });
                panel3.add(button6);
                button6.setBounds(590, 425, 160, 45);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u76f8\u5173\u6d3b\u52a8", panel3);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                //---- label1 ----
                label1.setText("\u573a\u5730\u540d\u79f0:");
                label1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                panel4.add(label1);
                label1.setBounds(40, 25, 105, 25);
                panel4.add(siteName);
                siteName.setBounds(135, 25, 275, siteName.getPreferredSize().height);

                //---- label8 ----
                label8.setText("\u573a\u5730\u7c7b\u578b:");
                label8.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                panel4.add(label8);
                label8.setBounds(40, 85, 75, label8.getPreferredSize().height);
                panel4.add(siteType);
                siteType.setBounds(135, 80, 275, siteType.getPreferredSize().height);

                //---- label9 ----
                label9.setText("\u573a\u5730\u7528\u9014:");
                label9.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                panel4.add(label9);
                label9.setBounds(40, 145, 90, 15);

                //======== scrollPane6 ========
                {
                    scrollPane6.setViewportView(siteUseage);
                }
                panel4.add(scrollPane6);
                scrollPane6.setBounds(140, 145, 265, 160);

                //---- label10 ----
                label10.setText("\u573a\u5730\u5907\u6ce8:");
                label10.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                panel4.add(label10);
                label10.setBounds(35, 340, 80, 20);

                //======== scrollPane7 ========
                {
                    scrollPane7.setViewportView(siteNote);
                }
                panel4.add(scrollPane7);
                scrollPane7.setBounds(140, 340, 270, 90);

                //---- label11 ----
                label11.setText("\u573a\u5730\u72b6\u6001:");
                label11.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                panel4.add(label11);
                label11.setBounds(435, 25, 120, 30);

                //======== scrollPane8 ========
                {
                    scrollPane8.setViewportView(siteStatus);
                }
                panel4.add(scrollPane8);
                scrollPane8.setBounds(530, 25, 245, 135);

                //---- label12 ----
                label12.setText("\u573a\u5730\u4ecb\u7ecd:");
                label12.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                panel4.add(label12);
                label12.setBounds(435, 200, 80, 20);

                //======== scrollPane9 ========
                {
                    scrollPane9.setViewportView(siteIntro);
                }
                panel4.add(scrollPane9);
                scrollPane9.setBounds(530, 210, 245, 130);

                //---- button5 ----
                button5.setText("\u63d0\u4ea4");
                button5.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 20));
                button5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        appealSite(e);
                    }
                });
                panel4.add(button5);
                button5.setBounds(595, 390, 120, 70);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u573a\u5730\u7533\u8bf7", panel4);

            //======== panel5 ========
            {
                panel5.setLayout(null);

                //======== scrollPane4 ========
                {

                    //---- editorPane1 ----
                    editorPane1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 16));
                    editorPane1.setEditable(false);
                    scrollPane4.setViewportView(editorPane1);
                }
                panel5.add(scrollPane4);
                scrollPane4.setBounds(0, 0, 840, 395);

                //======== scrollPane5 ========
                {

                    //---- textArea1 ----
                    textArea1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 18));
                    scrollPane5.setViewportView(textArea1);
                }
                panel5.add(scrollPane5);
                scrollPane5.setBounds(0, 395, 670, 100);

                //---- button4 ----
                button4.setText("\u53d1\u8868");
                button4.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 20));
                button4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        deliverComment(e);
                    }
                });
                panel5.add(button4);
                button4.setBounds(670, 395, 170, 100);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel5.getComponentCount(); i++) {
                        Rectangle bounds = panel5.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel5.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel5.setMinimumSize(preferredSize);
                    panel5.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7559\u8a00\u533a", panel5);

            //======== panel6 ========
            {
                panel6.setLayout(null);

                //======== scrollPane12 ========
                {

                    //---- chat ----
                    chat.setEditable(false);
                    scrollPane12.setViewportView(chat);
                }
                panel6.add(scrollPane12);
                scrollPane12.setBounds(0, 0, 835, 410);

                //======== scrollPane13 ========
                {

                    //---- chatFiled ----
                    chatFiled.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 16));
                    scrollPane13.setViewportView(chatFiled);
                }
                panel6.add(scrollPane13);
                scrollPane13.setBounds(0, 410, 680, 85);

                //---- button7 ----
                button7.setText("\u53d1\u9001");
                button7.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 20));
                button7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        sendMessage(e);
                    }
                });
                panel6.add(button7);
                button7.setBounds(680, 410, 155, 85);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel6.getComponentCount(); i++) {
                        Rectangle bounds = panel6.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel6.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel6.setMinimumSize(preferredSize);
                    panel6.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5bfb\u627e\u7ba1\u7406\u5458", panel6);

            //======== panel2 ========
            {
                panel2.setLayout(null);

                //---- label2 ----
                label2.setText("\u8bf4\u51fa\u60a8\u7684\u8bc9\u6c42\uff0c\u6211\u4eec\u5e2e\u60a8\uff01\uff01");
                label2.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 24));
                panel2.add(label2);
                label2.setBounds(10, 20, 430, 35);

                //---- label3 ----
                label3.setText("\u6807\u9898:");
                label3.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 18));
                panel2.add(label3);
                label3.setBounds(25, 90, 70, 35);

                //---- label4 ----
                label4.setText("\u5185\u5bb9:");
                label4.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 18));
                panel2.add(label4);
                label4.setBounds(25, 145, 70, 45);

                //---- label5 ----
                label5.setText("\u5907\u6ce8:");
                label5.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 18));
                panel2.add(label5);
                label5.setBounds(25, 320, 90, 30);
                panel2.add(title);
                title.setBounds(115, 90, 480, 40);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(content);
                }
                panel2.add(scrollPane2);
                scrollPane2.setBounds(120, 170, 475, 135);

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(note);
                }
                panel2.add(scrollPane3);
                scrollPane3.setBounds(120, 335, 480, 70);

                //---- button1 ----
                button1.setText("\u63d0\u4ea4");
                button1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 11));
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        bingo(e);
                    }
                });
                panel2.add(button1);
                button1.setBounds(265, 445, 165, button1.getPreferredSize().height);

                //---- button2 ----
                button2.setText("\u67e5\u770b\u6211\u7684\u53cd\u9988");
                button2.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        getLocalAppeal(e);
                    }
                });
                panel2.add(button2);
                button2.setBounds(620, 25, 145, button2.getPreferredSize().height);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u56f0\u96be\u8bc9\u6c42", panel2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 60, 840, 530);

        //---- label6 ----
        label6.setText("\u540c\u5fd7\uff0c\u6b22\u8fce\u60a8\u7684\u5230\u6765\uff01\uff01");
        label6.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
        contentPane.add(label6);
        label6.setBounds(180, 10, 500, 35);

        //---- label7 ----
        label7.setText("...");
        label7.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 18));
        contentPane.add(label7);
        label7.setBounds(60, 15, 110, 30);

        //---- button3 ----
        button3.setText("\u9000\u51fa\u767b\u5f55");
        button3.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logout(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(685, 20, 130, button3.getPreferredSize().height);

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
        label7.setText(TrainingContext.getLocal_User_Name());
        SwingUtil.makeEditorPaneBeHTML(editorPane1,announcement,activity);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane10;
    private JEditorPane announcement;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JEditorPane activity;
    private JLabel label13;
    private JTextField activityId;
    private JLabel label14;
    private JScrollPane scrollPane11;
    private JTextArea activityCase;
    private JButton button6;
    private JPanel panel4;
    private JLabel label1;
    private JTextField siteName;
    private JLabel label8;
    private JTextField siteType;
    private JLabel label9;
    private JScrollPane scrollPane6;
    private JTextArea siteUseage;
    private JLabel label10;
    private JScrollPane scrollPane7;
    private JTextArea siteNote;
    private JLabel label11;
    private JScrollPane scrollPane8;
    private JTextArea siteStatus;
    private JLabel label12;
    private JScrollPane scrollPane9;
    private JTextArea siteIntro;
    private JButton button5;
    private JPanel panel5;
    private JScrollPane scrollPane4;
    private JEditorPane editorPane1;
    private JScrollPane scrollPane5;
    private JTextArea textArea1;
    private JButton button4;
    private JPanel panel6;
    private JScrollPane scrollPane12;
    private JEditorPane chat;
    private JScrollPane scrollPane13;
    private JTextArea chatFiled;
    private JButton button7;
    private JPanel panel2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField title;
    private JScrollPane scrollPane2;
    private JTextArea content;
    private JScrollPane scrollPane3;
    private JTextArea note;
    private JButton button1;
    private JButton button2;
    private JLabel label6;
    private JLabel label7;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
