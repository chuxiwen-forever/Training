package entity;

import lombok.*;

import java.io.Serializable;

/**
 * 场地实体类
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Override
    public String toString() {
        return "<h2> 场地名称 ：" + name + "</h2> <h5>场地状态:"+state+ "&nbsp&nbsp场地类型:"+type+"</h5><br/>"+
                "<h3>场地目的:" + purpose + "</h3><br/>"+
                "<h3>场地备注:" + note + "</h3><br/>"+
                "<h3>场地介绍:" + introduce+"</h3><hr/>";
    }
}
