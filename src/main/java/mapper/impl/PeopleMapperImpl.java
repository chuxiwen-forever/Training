package mapper.impl;

import entity.People;
import mapper.PeopleMapper;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMapperImpl implements PeopleMapper {

    @Override
    public void insert(String username, String password) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1 ,username);
            statement.setString(2,password);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(connection,statement);
    }

    @Override
    public People selectByPeople(String username, String password) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet set = null;
        People people = null;
        try {
            statement = connection.prepareStatement(select);
            statement.setString(1,username);
            statement.setString(2,password);
            set = statement.executeQuery();
            while(set.next()){
                people = new People(set.getInt("id"),set.getString("username"),set.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(connection,statement,set);
        return people;
    }
}
