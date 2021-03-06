package mapper;

import entity.Activity;

import java.util.List;

public interface ActivityMapper {

    String select = "select id,theme,time,site from activity";
    String insert = "insert into activity values (null,?,?,?)";

    List<Activity> selectAll();

    void insert(Activity activity);
}
