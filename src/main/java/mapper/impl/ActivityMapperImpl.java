package mapper.impl;

import entity.Activity;
import mapper.ActivityMapper;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityMapperImpl implements ActivityMapper {
    @Override
    public List<Activity> selectAll() {
        List<Activity> activityList = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(select);
            set = statement.executeQuery();
            while(set.next()){
                activityList.add(new Activity(set.getInt("id"),set.getString("theme"),set.getDate("time"),set.getString("site")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement,set);
        return activityList;
    }
}
