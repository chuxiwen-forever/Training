package service.impl;

import VO.SiteVO;
import entity.Site;
import mapper.SiteMapper;
import mapper.impl.SiteMapperImpl;
import service.SiteService;

public class SiteServiceImpl implements SiteService {
    private SiteMapper siteMapper = new SiteMapperImpl();
    @Override
    public void applySite(SiteVO siteVO) {
        Site site = new Site();
        site.setName(siteVO.getName());
        site.setType(siteVO.getType());
        site.setPurpose(siteVO.getPurpose());
        site.setNote(siteVO.getNote());
        site.setState(siteVO.getState());
        site.setIntroduce(siteVO.getIntroduce());
        siteMapper.insert(site);
    }
}
