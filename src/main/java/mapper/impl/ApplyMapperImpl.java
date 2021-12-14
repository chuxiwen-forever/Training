package mapper.impl;

import entity.Apply;
import mapper.ApplyMapper;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
