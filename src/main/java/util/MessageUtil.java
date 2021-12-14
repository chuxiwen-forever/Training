package util;


import lombok.Data;

import java.io.Serializable;

/**
 * 登录和注册的返回
 */
@Data
public class MessageUtil implements Serializable {
    private static final long serialVersionUID = -671958543348052007L;
    private Integer result;
}
