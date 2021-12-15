package mapper;

import entity.Announcement;

import java.util.List;

public interface AnnouncementMapper {
    String select = "select id,content from announcement";
    String insert = "insert into announcement values (null,?)";

    List<Announcement> selectAnnouncement();

    void insertAnnouncement(Announcement announcement);
}
