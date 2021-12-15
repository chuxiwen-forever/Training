/*
 * Created by JFormDesigner on Tue Dec 14 16:47:17 CST 2021
 */

package view;

import util.ShowInSwing;
import util.SwingUtil;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Admin
 */
public class NotLoginView extends JFrame {

    public NotLoginView() {
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShowInSwing.showAllMessageInPeopleView(editorPane4,editorPane3,editorPane2);
    }

    private void ToLogin(MouseEvent e) {
        new LoginView(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane3 = new JScrollPane();
        editorPane3 = new JEditorPane();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        editorPane2 = new JEditorPane();
        panel3 = new JPanel();
        scrollPane4 = new JScrollPane();
        editorPane4 = new JEditorPane();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 18));

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(editorPane3);
                }
                panel1.add(scrollPane3);
                scrollPane3.setBounds(0, 0, 700, 415);

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

            //======== panel2 ========
            {
                panel2.setLayout(null);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(editorPane2);
                }
                panel2.add(scrollPane2);
                scrollPane2.setBounds(0, 0, 700, 415);

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
            tabbedPane1.addTab("\u76f8\u5173\u6d3b\u52a8", panel2);

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(editorPane4);
                }
                panel3.add(scrollPane4);
                scrollPane4.setBounds(0, 0, 700, 410);

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
            tabbedPane1.addTab("\u7559\u8a00\u533a", panel3);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 45, 700, 450);

        //---- label1 ----
        label1.setText("\u793e\u533a\u515a\u7fa4\u670d\u52a1\u4e2d\u5fc3");
        label1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 24));
        contentPane.add(label1);
        label1.setBounds(0, 0, 545, 45);

        //---- button1 ----
        button1.setText("\u9009\u62e9\u767b\u5f55");
        button1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.PLAIN, 18));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToLogin(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(555, 0, 140, 45);

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
        SwingUtil.makeEditorPaneBeHTML(editorPane2,editorPane3,editorPane4);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane3;
    private JEditorPane editorPane3;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JEditorPane editorPane2;
    private JPanel panel3;
    private JScrollPane scrollPane4;
    private JEditorPane editorPane4;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
