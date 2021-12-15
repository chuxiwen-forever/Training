package entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

/**
 * 报名信息实体类
 */


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Apply implements Serializable {
    private static final long serialVersionUID = -671958543348052007L;

    /**
     * 报名信息id
     */
    private Integer id;

    /**
     * 报名原因
     */
    private String cause;

    /**
     * 报名时间
     */
    private Date time;

    /**
     * 报名人
     */
    private String username;

    /**
     * 报名活动的id
     */
    private Integer activityId;

    @Override
    public String toString() {
        return "<h2> 报名人:" + username + "</h2>"+"<h4> 报名时间：" + time.toString()+"</h4><br/>"
                +"<h3> 报名原因" + cause + "</h3><hr/>";
    }
}
