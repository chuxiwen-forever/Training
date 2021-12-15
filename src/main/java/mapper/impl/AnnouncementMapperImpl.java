package mapper.impl;

import entity.Announcement;
import mapper.AnnouncementMapper;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementMapperImpl implements AnnouncementMapper {
    @Override
    public List<Announcement> selectAnnouncement() {
        List<Announcement> announcementList = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(select);
            set = statement.executeQuery();
            while(set.next()){
                announcementList.add(new Announcement(set.getInt("id"),set.getString("content")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement,set);
        return announcementList;
    }

    @Override
    public void insertAnnouncement(Announcement announcement) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setString(1, announcement.getContent());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement);
    }
}
