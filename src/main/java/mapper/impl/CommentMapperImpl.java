package mapper.impl;

import entity.Comment;
import mapper.CommentMapper;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentMapperImpl implements CommentMapper {
    @Override
    public void insert(Comment comment) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setString(1, comment.getUsername());
            statement.setDate(2,comment.getCreateTime());
            statement.setString(3, comment.getContent());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement);
    }

    @Override
    public List<Comment> selectAll() {
        List<Comment> commentList = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            statement = conn.prepareStatement(select);
            set = statement.executeQuery();
            while(set.next()){
                commentList.add(new Comment(set.getInt("id"),set.getString("username"),
                                            set.getDate("create_time"),set.getString("content")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement,set);
        return commentList;
    }
}
