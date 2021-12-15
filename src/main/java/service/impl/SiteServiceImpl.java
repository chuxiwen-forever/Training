package service.impl;

import VO.SiteVO;
import entity.Site;
import mapper.SiteMapper;
import mapper.impl.SiteMapperImpl;
import service.SiteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> showAllSite() {
        Map<String,Object> map = new HashMap<>();
        List<Site> siteList = siteMapper.selectAll();
        StringBuilder builder = new StringBuilder();
        if (siteList.isEmpty()){
            map.put("value","No");
        }else {
            map.put("value","Yes");
            for(Site site : siteList){
                builder.append(site.toString());
            }
            map.put("data",builder.toString());
        }
        return map;
    }
}
