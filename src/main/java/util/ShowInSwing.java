package util;

import service.*;
import service.impl.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowInSwing {
    private static CommentService commentServer = new CommentServiceImpl();
    private static AnnouncementService announcementService = new AnnouncementServiceImpl();
    private static ActivityService activityService = new ActivityServiceImpl();
    private static PeopleService peopleService = new PeopleServiceImpl();
    private static AppealService appealService = new AppealServiceImpl();
    private static ApplyService applyService = new ApplyServiceImpl();
    private static SiteService siteService = new SiteServiceImpl();


    //控制管理员页面显示
    public static void showAllMessageInAdminView(JEditorPane... panes){
        List<JEditorPane> jEditorPanes = new ArrayList<>();
        for (JEditorPane pane : panes){
            jEditorPanes.add(pane);
        }
        showAnnouncement(jEditorPanes.get(0));
        showPeople(jEditorPanes.get(1));
        showAppeal(jEditorPanes.get(2));
        showActivity(jEditorPanes.get(3));
        showApply(jEditorPanes.get(4));
        showSite(jEditorPanes.get(5));
        showAllComment(jEditorPanes.get(6));
    }

    //控制用户页面显示
    public static void showAllMessageInPeopleView(JEditorPane... panes){
        List<JEditorPane> jEditorPanes = new ArrayList<>();
        for (JEditorPane pane : panes){
            jEditorPanes.add(pane);
        }
        ShowInSwing.showAllComment(jEditorPanes.get(0));
        ShowInSwing.showAnnouncement(jEditorPanes.get(1));
        ShowInSwing.showActivity(jEditorPanes.get(2));
    }

    private static boolean justifyNull(JEditorPane pane){
        if (pane == null)return true;
        else return false;
    }

    //显示公告
    private static void showAnnouncement(JEditorPane announcement){
        if (!justifyNull(announcement)){
            Map<String, Object> map = announcementService.returnAnnouncement();
            String value = (String) map.get("value");
            if (value.equals("No")){
                announcement.setText("<h1><strong>暂无公告!!</strong></h1>");
            }else if (value.equals("Yes")){
                announcement.setText((String) map.get("data"));
            }
        }
    }

    //所有用户信息展示
    private static void showPeople(JEditorPane people){
        if (justifyNull(people)) return;
        Map<String, Object> map = peopleService.selectPeople();
        String value = (String) map.get("value");
        if (value.equals("No")){
            people.setText("<h1><strong>暂无用户注册!!</strong></h1>");
        }else if (value.equals("Yes")){
            people.setText((String) map.get("data"));
        }
    }

    //诉求展示
    private static void showAppeal(JEditorPane appeal){
        if (justifyNull(appeal))return;
        Map<String, Object> map = appealService.getAllAppeal();
        String value = (String) map.get("value");
        if (value.equals("No")){
            appeal.setText("<h1><strong>暂无诉求!!</strong></h1>");
        }else if (value.equals("Yes")){
            appeal.setText((String) map.get("data"));
        }
    }

    //主页展示活动
    private static void showActivity(JEditorPane activity){
        if (justifyNull(activity))return;
        Map<String, Object> map = activityService.showActivity();
        String value = (String) map.get("value");
        if (value.equals("No")){
            activity.setText("<h1><strong>暂无活动!!</strong></h1>");
        }else if (value.equals("Yes")){
            activity.setText((String) map.get("data"));
        }
    }

    //展示所以报名信息
    private static void showApply(JEditorPane apply){
        if (justifyNull(apply))return;
        Map<String, Object> map = applyService.selectAllApply();
        String value = (String) map.get("value");
        if (value.equals("No")){
            apply.setText("<h1><strong>暂无用户参加活动</strong></h1>");
        }else if (value.equals("Yes")){
            apply.setText((String) map.get("data"));
        }
    }

    //显示所有的场地信息
    private static void showSite(JEditorPane site){
        if (justifyNull(site))return;
        Map<String, Object> map = siteService.showAllSite();
        String value = (String) map.get("value");
        if (value.equals("No")){
            site.setText("<h1><strong>暂无用户申请场地</strong></h1>");
        }else {
            site.setText((String) map.get("data"));
        }
    }

    //展示评论
    private static void showAllComment(JEditorPane comment){
        if (justifyNull(comment))return;
        Map<String, Object> map = commentServer.selectAll();
        String value = (String) map.get("value");
        if (value.equals("No")){
            comment.setText("<h1><strong>暂无评论!!</strong></h1>");
        }else if (value.equals("Yes")){
            comment.setText((String) map.get("data"));
        }
    }
}
