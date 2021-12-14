package entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

/**
 * 活动实体类
 */


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Activity implements Serializable {

    private static final long serialVersionUID = -671958543348052007L;

    /**
     * *活动id
     */
    private Integer id;

    /**
     * 活动主题
     */
    private String theme;

    /**
     * 活动时间
     */
    private Date time;

    /**
     * 活动场地
     */
    private String site;

    @Override
    public String toString() {
        return "<h2><strong>"+ id + " :" + theme + "</strong></h2>"
                +"<h4>" + time.toString() +"</h4><br/>"+
                "<h3>"+site+"</h3> <hr/>";
    }
}
