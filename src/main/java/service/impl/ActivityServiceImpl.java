package service.impl;

import entity.Activity;
import mapper.ActivityMapper;
import mapper.impl.ActivityMapperImpl;
import service.ActivityService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {

    private ActivityMapper activityMapper = new ActivityMapperImpl();

    @Override
    public Map<String, Object> showActivity() {
        Map<String, Object> map = new HashMap<>();
        List<Activity> activityList = activityMapper.selectAll();
        if (activityList.isEmpty()){
            map.put("value","No");
        }else{
            StringBuilder builder = new StringBuilder();
            map.put("value","Yes");
            for (Activity activity : activityList){
                builder.append(activity.toString());
            }
            map.put("data",builder.toString());
        }
        return map;
    }

    @Override
    public void addActivity(String theme, String site) {
        Activity activity = new Activity();
        activity.setTheme(theme);
        activity.setTime(new Date(System.currentTimeMillis()));
        activity.setSite(site);
        activityMapper.insert(activity);
    }
}
