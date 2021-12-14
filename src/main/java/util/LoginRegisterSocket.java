package util;

import VO.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LoginRegisterSocket implements TypeNumber{

    /**
     *
     * @param vo 得到的视图信息
     * @return 状态码
     */
    public static Integer getVOReturnMessage(VO vo){
        Integer result = null;
        try {
            Socket socket = new Socket("localhost", 8100);
            //传输值
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            if (vo instanceof PeopleVO){
                PeopleVO peopleVO = (PeopleVO) vo;
                outputStream.writeObject(peopleVO);
            }else if (vo instanceof AppealVO){
                AppealVO appealVO = (AppealVO) vo;
                outputStream.writeObject(appealVO);
            }else if (vo instanceof SiteVO){
                SiteVO siteVO = (SiteVO) vo;
                outputStream.writeObject(siteVO);
            }
            outputStream.flush();

            //接收服务器返回值
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            MessageUtil message = (MessageUtil) inputStream.readObject();
            result = message.getResult();
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
