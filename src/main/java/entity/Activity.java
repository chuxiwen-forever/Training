package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * 活动实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
