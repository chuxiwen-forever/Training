package util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 减少图形界面代冗余
 */
public class SwingUtil {

    //使文本框或文本域内的字符串为空
    public static void makeFieldToEmpty(JComponent... components){
        for (JComponent component:components) {
            if (component instanceof JTextField){
                JTextField jTextField = (JTextField) component;
                jTextField.setText("");
            }else if (component instanceof JTextArea){
                JTextArea jTextArea = (JTextArea) component;
                jTextArea.setText("");
            }
        }
    }

    //得到所有文本框或者文本域的字符串
    public static List<String> getFieldToString(JComponent... components){
        List<String> stringList = new ArrayList<>();
        for (JComponent component : components){
            if (component instanceof JTextField){
                JTextField textField = (JTextField) component;
                String fieldText = textField.getText();
                stringList.add(fieldText);
            }else if (component instanceof JTextArea){
                JTextArea textArea = (JTextArea) component;
                String areaText = textArea.getText();
                stringList.add(areaText);
            }
        }
        return stringList;
    }

}
