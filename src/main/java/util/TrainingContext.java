package util;


public class TrainingContext {
    /**
     * 当前登录用户的用户名
     */
    private static String Local_User_Name;

    public static String getLocal_User_Name() {
        return Local_User_Name;
    }

    public static void setLocal_User_Name(String local_User_Name) {
        Local_User_Name = local_User_Name;
    }
}
