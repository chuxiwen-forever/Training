/*
 * Created by JFormDesigner on Thu Dec 16 17:10:31 CST 2021
 */

package view;

import entity.Appeal;
import mapper.AppealMapper;
import mapper.impl.AppealMapperImpl;
import service.AppealService;
import service.impl.AppealServiceImpl;
import util.SwingUtil;
import util.TrainingContext;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;

/**
 * @author Admin
 */
public class AppealView extends JFrame {
    private AppealService appealService = new AppealServiceImpl();
    private AppealMapper appealMapper = new AppealMapperImpl();

    public AppealView() {
        initComponents();
        this.setVisible(true);
        showAppeal();
    }

    private void keepAppeal(MouseEvent e) {
        List<Appeal> appealList = appealMapper.selectByName(TrainingContext.getLocal_User_Name());
        StringBuilder builder = new StringBuilder();
        for (Appeal appeal : appealList){
            builder.append(appeal.toString0());
        }
        String appeals = builder.toString();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("MyAppeal.txt"));
            writer.write(appeals,0,appeals.length());
            writer.flush();
            writer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"您的诉求已经保存到MyAppeal.txt中");
    }

    private void showAppeal(){
        Map<String, Object> map = appealService.getLocalAppeal(TrainingContext.getLocal_User_Name());
        String value = (String) map.get("value");
        if (value.equals("No")){
            appealPane.setText("<h1><strong>您暂无诉求！！！</strong></h1>");
        }else {
            appealPane.setText((String) map.get("data"));
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        appealPane = new JEditorPane();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- appealPane ----
            appealPane.setEditable(false);
            scrollPane1.setViewportView(appealPane);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 365, 470);

        //---- button1 ----
        button1.setText("\u4fdd\u5b58\u5230\u672c\u5730");
        button1.setFont(new Font("\u534e\u6587\u65b0\u9b4f", Font.BOLD, 18));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                keepAppeal(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(45, 495, 165, 40);

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
        SwingUtil.makeEditorPaneBeHTML(appealPane);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JEditorPane appealPane;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
