package mapper.impl;

import entity.Site;
import mapper.SiteMapper;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiteMapperImpl implements SiteMapper {
    @Override
    public void insert(Site site) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(insert);
            statement.setString(1,site.getName());
            statement.setString(2,site.getType());
            statement.setString(3,site.getPurpose());
            statement.setString(4,site.getNote());
            statement.setString(5,site.getState());
            statement.setString(6,site.getIntroduce());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement);
    }

    @Override
    public List<Site> selectAll() {
        List<Site> sites = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(select);
            set = statement.executeQuery();
            while(set.next()){
                sites.add(new Site(set.getInt("id"),set.getString("name"),set.getString("type"),
                                set.getString("purpose"),set.getString("note"),set.getString("state"),
                                set.getString("introduce")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(conn,statement,set);
        return sites;
    }
}
