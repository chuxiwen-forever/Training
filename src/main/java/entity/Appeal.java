package entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

/**
 * 诉求实体类
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appeal implements Serializable {
    private static final long serialVersionUID = -671958543348052007L;

    /**
     * 诉求id
     */
    private Integer id;

    /**
     * 诉求标题
     */
    private String title;

    /**
     * 诉求内容
     */
    private String content;

    /**
     * 诉求日期
     */
    private Date createTime;

    /**
     * 诉求备注
     */
    private String note;

    /**
     * 诉求人
     */
    private String number;

    @Override
    public String toString() {
        return "<h2> 标题："+title+"</h2> <h4> 诉求人:"+number+" 诉求日期:"+createTime.toString()+"</h4><br/>"+
        "<h3> 诉求内容:" + content + "</h3> <br/>  <h4>备注："+note+ "</h4><hr/>";
    }
}
