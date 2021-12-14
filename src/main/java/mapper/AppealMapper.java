package mapper;

import entity.Appeal;

import java.util.List;

/**
 * 诉求mapper接口
 */
public interface AppealMapper {
    String insert = "insert into appeal values (null,?,?,?,?,?)";
    String selectByName = "select id,title,content,create_time,note,number from appeal where number = ?";
    String selectAll = "select id,title,content,create_time,note,number from appeal";

    void addAppeal(Appeal appeal);

    List<Appeal> selectByName(String number);

    List<Appeal> selectAll();
}
