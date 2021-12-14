package service.impl;

import entity.Announcement;
import mapper.AnnouncementMapper;
import mapper.impl.AnnouncementMapperImpl;
import service.AnnouncementService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnouncementServiceImpl implements AnnouncementService {
    private AnnouncementMapper announcementMapper = new AnnouncementMapperImpl();

    @Override
    public Map<String, Object> returnAnnouncement() {
        Map<String,Object> map = new HashMap<>();
        List<Announcement> announcementList = announcementMapper.selectAnnouncement();
        StringBuilder builder = new StringBuilder();
        if (announcementList.isEmpty()){
            map.put("value","No");
        }else{
            map.put("value","Yes");
            for (Announcement announcement : announcementList){
                builder.append(announcement.toString());
            }
            map.put("data",builder.toString());
        }
        return map;
    }
}
