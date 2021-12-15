package service.impl;

import entity.Comment;
import mapper.CommentMapper;
import mapper.impl.CommentMapperImpl;
import service.CommentService;
import util.TrainingContext;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentServiceImpl implements CommentService {
    private CommentMapper commentMapper = new CommentMapperImpl();

    @Override
    public void giveOutComment(String content) {
        Comment comment = new Comment();
        comment.setUsername(TrainingContext.getLocal_User_Name());
        comment.setCreateTime(new Date(System.currentTimeMillis()));
        comment.setContent(content);
        commentMapper.insert(comment);
    }

    @Override
    public Map<String,Object> selectAll() {
        Map<String,Object> result = new HashMap<>();
        List<Comment> commentList = commentMapper.selectAll();
        StringBuilder builder = new StringBuilder();
        for (Comment comment : commentList){
            builder.append(comment);
        }
        if (commentList.isEmpty()){
            result.put("value","No");
        }else {
            result.put("value","Yes");
            result.put("data",builder.toString());
        }
        return result;
    }
}
