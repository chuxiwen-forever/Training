package service;

import VO.SiteVO;

import java.util.Map;

public interface SiteService {

    /**
     * 根据视图信息进行储存信息
     * @param siteVO
     */
    void applySite(SiteVO siteVO);

    /**
     * 管理员查看所以场地
     */
    Map<String,Object> showAllSite();
}
