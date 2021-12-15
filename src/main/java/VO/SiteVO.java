package VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteVO implements Serializable,VO {
    private static final long serialVersionUID = -671958543348052007L;
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
