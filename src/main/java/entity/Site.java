package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 场地实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Site implements Serializable {

    private static final long serialVersionUID = -671958543348052007L;
    /**
     * 场地id
     */
    private Integer id;

    /**
     * 场地名称
     */
    private String name;

    /**
     * 场地类型
     */
    private String type;

    /**
     * 场地用途
     */
    private String purpose;

    /**
     * 场地备注
     */
    private String note;

    /**
     * 场地状态
     */
    private String state;

    /**
     * 场地介绍
     */
    private String introduce;
}
