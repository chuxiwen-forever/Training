package mapper.impl;

import entity.Appeal;
import mapper.AppealMapper;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppealMapperImpl implements AppealMapper {
    @Override
    public void addAppeal(Appeal appeal) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setString(1,appeal.getTitle());
            statement.setString(2, appeal.getContent());
            statement.setDate(3,appeal.getCreateTime() );
            statement.setString(4, appeal.getNote());
            statement.setString(5, appeal.getNumber());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement);
    }

    @Override
    public List<Appeal> selectByName(String number) {
        return select(number);
    }

    @Override
    public List<Appeal> selectAll() {
        return select(null);
    }

    private List<Appeal> select(String number){
        Connection conn = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Appeal> appealList = new ArrayList<>();
        try {
            if (number == null){
                statement = conn.prepareStatement(selectAll);
            }else{
                statement = conn.prepareStatement(selectByName);
                statement.setString(1,number);
            }
            set = statement.executeQuery();
            while(set.next()){
                appealList.add(new Appeal(
                        set.getInt("id"),set.getString("title"),
                        set.getString("content"),set.getDate("create_time"),
                        set.getString("note"),set.getString("number")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement,set);
        return appealList;
    }
}
