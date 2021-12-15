package VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppealVO implements Serializable ,VO{
    private static final long serialVersionUID = -671958543348052007L;
    /**
     * 诉求标题
     */
    private String title;

    /**
     * 诉求内容
     */
    private String content;

    /**
     * 诉求备注
     */
    private String note;
}
