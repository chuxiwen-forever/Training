package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
