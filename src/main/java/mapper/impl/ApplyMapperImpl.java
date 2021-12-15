package mapper.impl;

import com.mysql.cj.jdbc.ConnectionImpl;
import entity.Apply;
import mapper.ApplyMapper;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplyMapperImpl implements ApplyMapper {
    @Override
    public void insert(Apply apply) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setString(1,apply.getCause());
            statement.setDate(2,apply.getTime());
            statement.setString(3, apply.getUsername());
            statement.setInt(4,apply.getActivityId());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement);
    }

    @Override
    public List<Apply> selectAll() {
        List<Apply> applyList = new ArrayList<>();
        ResultSet set = null;
        Connection conn = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(select);
            set = statement.executeQuery();
            while(set.next()){
                applyList.add(new Apply(set.getInt("id"), set.getString("cause"),
                                        set.getDate("time"),set.getString("username"),
                                        set.getInt("activity_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement,set);
        return applyList;
    }
}
