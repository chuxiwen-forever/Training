package mapper;

import entity.People;

import java.sql.ResultSet;
import java.util.List;

/**
 * 用户mapper接口
 */
public interface PeopleMapper {
    String insert = "insert into people values (null,? ,?)";
    String select = "select id,username,password from people where username = ? and password = ?";
    String selectAll = "select id,username,password from people";
    String delete = "delete from people where username = ?";

    void insert(String username ,String password);

    People selectByPeople(String username , String password);

    List<People> selectAllPeople();

    void deletePeople(People people);
}
