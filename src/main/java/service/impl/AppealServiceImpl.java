package service.impl;

import entity.Appeal;
import mapper.AppealMapper;
import mapper.impl.AppealMapperImpl;
import service.AppealService;
import util.TrainingContext;

import java.sql.Date;
import java.util.List;

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
    public List<Appeal> getLocalAppeal(String username) {
        return appealMapper.selectByName(username);
    }

    @Override
    public List<Appeal> getAllAppeal() {
        return appealMapper.selectAll();
    }
}
