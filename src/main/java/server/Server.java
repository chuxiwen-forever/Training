package server;

import VO.AppealVO;
import VO.PeopleVO;
import VO.SiteVO;
import entity.People;
import service.AppealService;
import service.PeopleService;
import service.SiteService;
import service.impl.AppealServiceImpl;
import service.impl.PeopleServiceImpl;
import service.impl.SiteServiceImpl;
import util.MessageUtil;
import util.TypeNumber;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements TypeNumber {
    private static PeopleService peopleService = new PeopleServiceImpl();
    private static AppealService appealService = new AppealServiceImpl();
    private static SiteService siteService = new SiteServiceImpl();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8100);
        System.out.println("服务器已经启动");

        while(true){
            Socket accept = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(accept.getInputStream());
            Object object = inputStream.readObject();
            ObjectOutputStream outputStream = new ObjectOutputStream(accept.getOutputStream());
            MessageUtil message = new MessageUtil();
            //判断业务类型
            if (object instanceof PeopleVO){  //登录注册类型
                PeopleVO people = (PeopleVO) object;
                if (people.getType().equals(LOGIN)){
                    People need = people.getPeople();
                    People login = peopleService.login(need.getUsername(), need.getPassword());
                    if (login != null){
                        message.setResult(SUCCESS);
                    }else {
                        message.setResult(FAILED);
                    }
                }else if (people.getType().equals(REGISTER)){
                    People need = people.getPeople();
                    peopleService.register(need.getUsername(),need.getPassword());
                    message.setResult(SUCCESS);
                }
            }else if (object instanceof AppealVO){// 诉求类型
                AppealVO appealVO = (AppealVO) object;
                appealService.addAppeal(appealVO.getTitle(),appealVO.getContent(),appealVO.getNote());
                message.setResult(SUCCESS);
            }else if (object instanceof SiteVO){ //场地类型
                SiteVO siteVO = (SiteVO) object;
                siteService.applySite(siteVO);
                message.setResult(SUCCESS);
            }

            outputStream.writeObject(message);
            outputStream.flush();
            inputStream.close();
            outputStream.close();
            accept.close();
        }


    }
}
