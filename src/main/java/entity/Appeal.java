package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * 诉求实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
