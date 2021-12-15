package mapper;

import entity.Apply;

import java.util.List;

public interface ApplyMapper {

    String insert = "insert into apply values (null,?,?,?,?)";
    String select = "select id,cause,time,username,activity_id from apply";
    void insert(Apply apply);

    List<Apply> selectAll();

}
