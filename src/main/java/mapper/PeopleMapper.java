package mapper;

import entity.People;

import java.sql.ResultSet;

/**
 * 用户mapper接口
 */
public interface PeopleMapper {
    String insert = "insert into people values (null,? ,?)";
    String select = "select id,username,password from people where username = ? and password = ?";

    void insert(String username ,String password);

    People selectByPeople(String username , String password);
}
