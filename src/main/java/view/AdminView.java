/*
 * Created by JFormDesigner on Wed Dec 15 11:49:36 CST 2021
 */

package view;

import server.UDPClient;
import service.ActivityService;
import service.AnnouncementService;
import service.CommentService;
import service.PeopleService;
import service.impl.ActivityServiceImpl;
import service.impl.AnnouncementServiceImpl;
import service.impl.CommentServiceImpl;
import service.impl.PeopleServiceImpl;
import util.ShowInSwing;
import util.SwingUtil;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

/**
 * @author Admin
 */
public class AdminView extends JFrame {
    private AnnouncementService announcementService = new AnnouncementServiceImpl();
    private PeopleService peopleService = new PeopleServiceImpl();
    private ActivityService activityService = new ActivityServiceImpl();
    private CommentService commentService = new CommentServiceImpl();
    private UDPClient client = new UDPClient("localhost",8200);


    public AdminView() {
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShowInSwing.showAllMessageInAdminView(announcementPane,peoplePane,appealPane,activityPane,applyPane,sitePane,commentPane);
        client.sendMessage("我上线了！！！");
        new Thread(()->{
            while(true){
                String message = client.receiveMessage();
                System.out.println(message);
            }
        }).start();
    }

    private void chatCommit(MouseEvent e) {
        String message = chatArea.getText();
        client.sendMessage(message);
        SwingUtil.makeFieldToEmpty(chatArea);
    }

    private void commentCommit(MouseEvent e) {
        String content = commentArea.getText();
        commentService.giveOutComment(content);
        JOptionPane.showMessageDialog(null,"评论成功");
        SwingUtil.makeFieldToEmpty(commentArea);
        ShowInSwing.showAllMessageInPeopleView(commentPane,null,null);
    }

    private void deletePeople(MouseEvent e) {
        String username = peopleField.getText();
        peopleService.deletePeople(username);
        JOptionPane.showMessageDialog(null,"删除成功");
        SwingUtil.makeFieldToEmpty(peopleField);
        ShowInSwing.showAllMessageInAdminView(null,peoplePane,null,null,null,null,null);
    }

    private void activityCommit(MouseEvent e) {
        List<String> stringList = SwingUtil.getFieldToString(activityField1, activityField2);
        activityService.addActivity(stringList.get(0),stringList.get(1));
        JOptionPane.showMessageDialog(null,"活动添加成功!");
        SwingUtil.makeFieldToEmpty(activityField1,activityField2);
        ShowInSwing.showAllMessageInAdminView(null,null,null,activityPane,null,null,null);
    }

    private void announcementCommit(MouseEvent e) {
        String content = announcementArea.getText();
        announcementService.addAnnouncement(content);
        JOptionPane.showMessageDialog(null,"公告添加成功!");
        SwingUtil.makeFieldToEmpty(announcementArea);
        ShowInSwing.showAllMessageInAdminView(announcementPane,null,null,null,null,null,null);
    }

    private void logout(MouseEvent e) {
        this.dispose();
        new NotLoginView();
        client.close();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane4 = new JScrollPane();
        announcementPane = new JEditorPane();
        label7 = new JLabel();
        label8 = new JLabel();
        scrollPane12 = new JScrollPane();
        announcementArea = new JTextArea();
        button6 = new JButton();
        panel2 = new JPanel();
        scrollPane3 = new JScrollPane();
        peoplePane = new JEditorPane();
        label5 = new JLabel();
        label6 = new JLabel();
        peopleField = new JTextField();
        button5 = new JButton();
        panel3 = new JPanel();
        scrollPane5 = new JScrollPane();
        appealPane = new JEditorPane();
        panel4 = new JPanel();
        scrollPane6 = new JScrollPane();
        activityPane = new JEditorPane();
        label2 = new JLabel();
        label3 = new JLabel();
        activityField1 = new JTextField();
        label4 = new JLabel();
        activityField2 = new JTextField();
        button4 = new JButton();
        panel5 = new JPanel();
        scrollPane7 = new JScrollPane();
        applyPane = new JEditorPane();
        panel7 = new JPanel();
        scrollPane10 = new JScrollPane();
        sitePane = new JEditorPane();
        panel6 = new JPanel();
        scrollPane8 = new JScrollPane();
        chatPane = new JEditorPane();
        scrollPane9 = new JScrollPane();
        chatArea = new JTextArea();
        button2 = new JButton();
        panel8 = new JPanel();
        scrollPane2 = new JScrollPane();
        commentPane = new JEditorPane();
        scrollPane11 = new JScrollPane();
        commentArea = new JTextArea();
        button3 = new JButton();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u6765\u5230\u7ba1\u7406\u5458\u7cfb\u7edf");
        label1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 28));
        contentPane.add(label1);
        label1.setBounds(0, 0, 610, 70);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //======== scrollPane4 ========
                {

                    //---- announcementPane ----
                    announcementPane.setEditable(false);
                    scrollPane4.setViewportView(announcementPane);
                }
                panel1.add(scrollPane4);
                scrollPane4.setBounds(5, 5, 485, 410);

                //---- label7 ----
                label7.setText("\u6dfb\u52a0\u516c\u544a");
                label7.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 30));
                panel1.add(label7);
                label7.setBounds(525, 30, 160, 60);

                //---- label8 ----
                label8.setText("\u516c\u544a\u5185\u5bb9");
                label8.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 18));
                panel1.add(label8);
                label8.setBounds(500, 95, 145, 50);

                //======== scrollPane12 ========
                {

                    //---- announcementArea ----
                    announcementArea.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
                    scrollPane12.setViewportView(announcementArea);
                }
                panel1.add(scrollPane12);
                scrollPane12.setBounds(525, 155, 225, 170);

                //---- button6 ----
                button6.setText("\u63d0\u4ea4");
                button6.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 16));
                button6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        announcementCommit(e);
                    }
                });
                panel1.add(button6);
                button6.setBounds(590, 360, 130, 35);

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
            tabbedPane1.addTab("\u516c\u544a\u7ba1\u7406", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(null);

                //======== scrollPane3 ========
                {

                    //---- peoplePane ----
                    peoplePane.setEditable(false);
                    scrollPane3.setViewportView(peoplePane);
                }
                panel2.add(scrollPane3);
                scrollPane3.setBounds(5, 5, 475, 410);

                //---- label5 ----
                label5.setText("\u5220\u9664\u8fdd\u89c4\u7528\u6237");
                label5.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 28));
                panel2.add(label5);
                label5.setBounds(505, 25, 205, 55);

                //---- label6 ----
                label6.setText("\u7528\u6237\u540d:");
                label6.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 20));
                panel2.add(label6);
                label6.setBounds(495, 115, 115, 30);

                //---- peopleField ----
                peopleField.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
                panel2.add(peopleField);
                peopleField.setBounds(520, 175, 230, peopleField.getPreferredSize().height);

                //---- button5 ----
                button5.setText("\u63d0\u4ea4");
                button5.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 18));
                button5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        deletePeople(e);
                    }
                });
                panel2.add(button5);
                button5.setBounds(570, 290, 120, 55);

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
            tabbedPane1.addTab("\u7528\u6237\u7ba1\u7406", panel2);

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //======== scrollPane5 ========
                {

                    //---- appealPane ----
                    appealPane.setEditable(false);
                    scrollPane5.setViewportView(appealPane);
                }
                panel3.add(scrollPane5);
                scrollPane5.setBounds(5, 5, 775, 410);

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
            tabbedPane1.addTab("\u8bc9\u6c42\u7ba1\u7406", panel3);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                //======== scrollPane6 ========
                {

                    //---- activityPane ----
                    activityPane.setEditable(false);
                    scrollPane6.setViewportView(activityPane);
                }
                panel4.add(scrollPane6);
                scrollPane6.setBounds(5, 5, 475, 410);

                //---- label2 ----
                label2.setText("\u6dfb\u52a0\u6d3b\u52a8");
                label2.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 28));
                panel4.add(label2);
                label2.setBounds(505, 30, 220, 50);

                //---- label3 ----
                label3.setText("\u4e3b\u9898:");
                label3.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 20));
                panel4.add(label3);
                label3.setBounds(495, 90, 70, 25);

                //---- activityField1 ----
                activityField1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
                panel4.add(activityField1);
                activityField1.setBounds(530, 120, 220, activityField1.getPreferredSize().height);

                //---- label4 ----
                label4.setText("\u573a\u5730:");
                label4.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 20));
                panel4.add(label4);
                label4.setBounds(495, 170, 55, 20);

                //---- activityField2 ----
                activityField2.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 14));
                panel4.add(activityField2);
                activityField2.setBounds(530, 215, 225, activityField2.getPreferredSize().height);

                //---- button4 ----
                button4.setText("\u63d0\u4ea4");
                button4.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 20));
                button4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        activityCommit(e);
                    }
                });
                panel4.add(button4);
                button4.setBounds(585, 325, 100, 55);

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
            tabbedPane1.addTab("\u6d3b\u52a8\u7ba1\u7406", panel4);

            //======== panel5 ========
            {
                panel5.setLayout(null);

                //======== scrollPane7 ========
                {

                    //---- applyPane ----
                    applyPane.setEditable(false);
                    scrollPane7.setViewportView(applyPane);
                }
                panel5.add(scrollPane7);
                scrollPane7.setBounds(5, 5, 770, 415);

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
            tabbedPane1.addTab("\u62a5\u540d\u7ba1\u7406", panel5);

            //======== panel7 ========
            {
                panel7.setLayout(null);

                //======== scrollPane10 ========
                {

                    //---- sitePane ----
                    sitePane.setEditable(false);
                    scrollPane10.setViewportView(sitePane);
                }
                panel7.add(scrollPane10);
                scrollPane10.setBounds(5, 5, 775, 415);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel7.getComponentCount(); i++) {
                        Rectangle bounds = panel7.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel7.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel7.setMinimumSize(preferredSize);
                    panel7.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u573a\u5730\u7cfb\u7edf", panel7);

            //======== panel6 ========
            {
                panel6.setLayout(null);

                //======== scrollPane8 ========
                {

                    //---- chatPane ----
                    chatPane.setEditable(false);
                    scrollPane8.setViewportView(chatPane);
                }
                panel6.add(scrollPane8);
                scrollPane8.setBounds(5, 5, 770, 315);

                //======== scrollPane9 ========
                {

                    //---- chatArea ----
                    chatArea.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 16));
                    scrollPane9.setViewportView(chatArea);
                }
                panel6.add(scrollPane9);
                scrollPane9.setBounds(10, 325, 595, 90);

                //---- button2 ----
                button2.setText("\u53d1\u9001");
                button2.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 20));
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        chatCommit(e);
                    }
                });
                panel6.add(button2);
                button2.setBounds(620, 335, 150, 80);

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
            tabbedPane1.addTab("\u804a\u5929\u7cfb\u7edf", panel6);

            //======== panel8 ========
            {
                panel8.setLayout(null);

                //======== scrollPane2 ========
                {

                    //---- commentPane ----
                    commentPane.setEditable(false);
                    scrollPane2.setViewportView(commentPane);
                }
                panel8.add(scrollPane2);
                scrollPane2.setBounds(0, 5, 505, 415);

                //======== scrollPane11 ========
                {

                    //---- commentArea ----
                    commentArea.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 18));
                    scrollPane11.setViewportView(commentArea);
                }
                panel8.add(scrollPane11);
                scrollPane11.setBounds(520, 15, 250, 250);

                //---- button3 ----
                button3.setText("\u53d1\u9001");
                button3.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 24));
                button3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        commentCommit(e);
                    }
                });
                panel8.add(button3);
                button3.setBounds(540, 300, 220, 95);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel8.getComponentCount(); i++) {
                        Rectangle bounds = panel8.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel8.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel8.setMinimumSize(preferredSize);
                    panel8.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7559\u8a00\u7cfb\u7edf", panel8);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 75, 780, 455);

        //---- button1 ----
        button1.setText("\u9000\u51fa\u767b\u5f55");
        button1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 18));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logout(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(645, 20, 115, 55);

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
        SwingUtil.makeEditorPaneBeHTML(announcementPane,peoplePane,appealPane,activityPane,applyPane,sitePane,chatPane,commentPane);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane4;
    private JEditorPane announcementPane;
    private JLabel label7;
    private JLabel label8;
    private JScrollPane scrollPane12;
    private JTextArea announcementArea;
    private JButton button6;
    private JPanel panel2;
    private JScrollPane scrollPane3;
    private JEditorPane peoplePane;
    private JLabel label5;
    private JLabel label6;
    private JTextField peopleField;
    private JButton button5;
    private JPanel panel3;
    private JScrollPane scrollPane5;
    private JEditorPane appealPane;
    private JPanel panel4;
    private JScrollPane scrollPane6;
    private JEditorPane activityPane;
    private JLabel label2;
    private JLabel label3;
    private JTextField activityField1;
    private JLabel label4;
    private JTextField activityField2;
    private JButton button4;
    private JPanel panel5;
    private JScrollPane scrollPane7;
    private JEditorPane applyPane;
    private JPanel panel7;
    private JScrollPane scrollPane10;
    private JEditorPane sitePane;
    private JPanel panel6;
    private JScrollPane scrollPane8;
    private JEditorPane chatPane;
    private JScrollPane scrollPane9;
    private JTextArea chatArea;
    private JButton button2;
    private JPanel panel8;
    private JScrollPane scrollPane2;
    private JEditorPane commentPane;
    private JScrollPane scrollPane11;
    private JTextArea commentArea;
    private JButton button3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
