package service;

import java.util.Map;

public interface ActivityService {

    /**
     * show activity
     */
    Map<String,Object> showActivity();

    /**
     * add activity
     */
    void addActivity(String theme,String site);
}
