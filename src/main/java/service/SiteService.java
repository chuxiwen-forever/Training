package service;

import VO.SiteVO;

public interface SiteService {

    /**
     * 根据视图信息进行储存信息
     * @param siteVO
     */
    void applySite(SiteVO siteVO);

}
