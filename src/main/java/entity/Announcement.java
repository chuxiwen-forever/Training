package entity;


import lombok.*;

import java.io.Serializable;

/**
 * 公告实体类
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Announcement implements Serializable {

    private static final long serialVersionUID = -671958543348052007L;
    /**
     * 公告id
     */
    private Integer id;

    /**
     * 公告内容
     */
    private String content;

    @Override
    public String toString() {
        return "<h3>"+content+"</h3><hr/>";
    }
}
