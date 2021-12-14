package mapper;

import entity.Comment;

import java.util.List;

public interface CommentMapper {
    String insert = "insert into comment values (null,?,?,?)";
    String select = "select id,username,create_time,content from comment";

    void insert(Comment comment);

    List<Comment> selectAll();
}
