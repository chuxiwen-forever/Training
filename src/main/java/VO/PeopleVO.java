package VO;

import entity.People;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleVO  implements Serializable , VO {

    private static final long serialVersionUID = -671958543348052007L;
    //传送username和password
    private People people;

    //根据type进行业务选择
    private Integer type;

}
