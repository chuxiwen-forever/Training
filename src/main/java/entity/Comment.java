package entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

/**
 * 评论实体类
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment implements Serializable {

    private static final long serialVersionUID = -671958543348052007L;
    /**
     * 评论id
     */
    private Integer id;

    /**
     * 评论用户名称
     */
    private String username;

    /**
     * 评论创建时间
     */
    private Date createTime;

    /**
     * 评论内容
     */
    private String content;

    @Override
    public String toString() {
        return "<h3>" + username + ":</h3>"+
                "<h4><i>"+createTime.toString()+"</i></h4></br>"+
                "<h3>" + content + "</h3></br>" +
                "<hr/>";
    }
}
