package service;

import java.util.Map;

public interface AnnouncementService {

    Map<String,Object> returnAnnouncement();

    void addAnnouncement(String content);
}
