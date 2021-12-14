package mapper;

import entity.Site;

import java.util.List;

public interface SiteMapper {
    String insert = "insert into site values (null,?,?,?,?,?,?)";
    String select = "select id,name,type,purpose,note,state,introduce from site";

    /**
     * 插入场地申请
     * @param site 场地信息
     */
    void insert(Site site);

    /**
     * 返回所有场地信息
     * @return 场地集合
     */
    List<Site> selectAll();
}
