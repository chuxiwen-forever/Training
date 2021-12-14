package util;

import service.ActivityService;
import service.AnnouncementService;
import service.CommentServer;
import service.impl.ActivityServiceImpl;
import service.impl.AnnouncementServiceImpl;
import service.impl.CommentServerImpl;

import javax.swing.*;
import java.util.Map;

public class ShowInSwing {
    private static CommentServer commentServer = new CommentServerImpl();
    private static AnnouncementService announcementService = new AnnouncementServiceImpl();
    private static ActivityService activityService = new ActivityServiceImpl();

    //显示公告
    public static void showAnnouncement(JEditorPane announcement){
        Map<String, Object> map = announcementService.returnAnnouncement();
        String value = (String) map.get("value");
        if (value.equals("No")){
            announcement.setText("<h1><strong>暂无公告!!</strong></h1>");
        }else if (value.equals("Yes")){
            announcement.setText((String) map.get("data"));
        }
    }


    //展示评论
    public static void showAllComment(JEditorPane comment){
        Map<String, Object> map = commentServer.selectAll();
        String value = (String) map.get("value");
        if (value.equals("No")){
            comment.setText("<h1><strong>暂无评论!!</strong></h1>");
        }else if (value.equals("Yes")){
            comment.setText((String) map.get("data"));
        }
    }

    //主页展示活动
    public static void showActivity(JEditorPane activity){
        Map<String, Object> map = activityService.showActivity();
        String value = (String) map.get("value");
        if (value.equals("No")){
            activity.setText("<h1><strong>暂无活动!!</strong></h1>");
        }else if (value.equals("Yes")){
            activity.setText((String) map.get("data"));
        }
    }
}
