package VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyVO implements Serializable,VO {
    private static final long serialVersionUID = -671958543348052007L;

    /**
     * 申请原因
     */
    private String cause;

    /**
     * 报名活动的id
     */
    private Integer activity_id;
}
