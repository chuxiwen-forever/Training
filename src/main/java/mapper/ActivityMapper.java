package mapper;

import entity.Activity;

import java.util.List;

public interface ActivityMapper {

    String select = "select id,theme,time,site from activity";

    List<Activity> selectAll();

}
