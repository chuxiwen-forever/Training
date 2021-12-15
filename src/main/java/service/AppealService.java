package service;


import entity.Appeal;

import java.util.List;
import java.util.Map;

public interface AppealService {

    /**
     *
     * @param title  标题
     * @param content 内容
     * @param note 备注
     */
    void addAppeal(String title,String content,String note);

    /**
     * 通过登录人员用户名得到其上报的诉求
     * @param username
     * @return 上报诉求
     */
    List<Appeal> getLocalAppeal(String username);

    /**
     * 管理员观看所有人的诉求
     */
    Map<String,Object> getAllAppeal();
}
