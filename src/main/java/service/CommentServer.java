package service;

import java.util.Map;

public interface CommentServer {

    /**
     * 发表评论
     * @param content 评论内容
     */
    void giveOutComment(String content);

    /**
     * 评论列表
     * @return 回传列表是否为空的以及列表数据
     */
    Map<String,Object> selectAll();
}
