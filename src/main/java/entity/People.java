package entity;

import lombok.*;

import java.io.Serializable;

/**
 * 用户实体类
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class People implements Serializable {

    private static final long serialVersionUID = -671958543348052007L;
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    @Override
    public String toString() {
        return "<h3>  id:" + id + " 姓名:" + username + "</h3><hr/>";
    }
}
