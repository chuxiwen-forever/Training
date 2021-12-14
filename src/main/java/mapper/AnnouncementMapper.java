package mapper;

import entity.Announcement;

import java.util.List;

public interface AnnouncementMapper {
    String select = "select id,content from announcement";

    List<Announcement> selectAnnouncement();
}
