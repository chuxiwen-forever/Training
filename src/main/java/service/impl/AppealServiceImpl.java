package service.impl;

import entity.Appeal;
import mapper.AppealMapper;
import mapper.impl.AppealMapperImpl;
import service.AppealService;
import util.TrainingContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppealServiceImpl implements AppealService {
    private AppealMapper appealMapper = new AppealMapperImpl();

    @Override
    public void addAppeal(String title, String content, String note) {
        Appeal appeal = new Appeal();
        appeal.setTitle(title);
        appeal.setContent(content);
        appeal.setCreateTime(new Date(System.currentTimeMillis()));
        appeal.setNote(note);
        appeal.setNumber(TrainingContext.getLocal_User_Name());
        appealMapper.addAppeal(appeal);
    }

    @Override
    public Map<String,Object> getLocalAppeal(String username) {
        return getAppeal(username);
    }

    @Override
    public Map<String,Object> getAllAppeal() {
        return getAppeal(null);
    }

    private Map<String,Object> getAppeal(String username){
        Map<String,Object> map = new HashMap<>();
        List<Appeal> appealList = null;
        if (username == null){
            appealList = appealMapper.selectAll();
        }else {
            appealList = appealMapper.selectByName(username);
        }
        StringBuilder builder = new StringBuilder();
        if (appealList.isEmpty()){
            map.put("value","No");
        }else {
            map.put("value","Yes");
            for (Appeal appeal : appealList){
                builder.append(appeal.toString());
            }
            map.put("data",builder.toString());
        }
        return map;
    }
}
