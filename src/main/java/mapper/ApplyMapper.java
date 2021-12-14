package mapper;

import entity.Apply;

public interface ApplyMapper {

    String insert = "insert into apply values (null,?,?,?,?)";

    void insert(Apply apply);
}
