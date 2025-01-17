package cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.helpers;

import java.util.Date;

public class GlobalInfo {
    private final int SPLASH_SCREEN_TIMEOUT = 4000;

    private Date last_login ;

    private int last_points;

    private int last_level;

    private static GlobalInfo instance = new GlobalInfo();

    public static GlobalInfo getInstance()
    {
        return instance;
    }

    public int getSPLASH_SCREEN_TIMEOUT() {
        return SPLASH_SCREEN_TIMEOUT;
    }

    public Date getLastLogin()
    {
        return last_login;
    }
    public void setLast_login(Date date)
    {
        last_login = date;
    }

    public int getLast_points() {
        return last_points;
    }

    public void setLast_points(int last_points) {
        this.last_points = last_points;
    }

    public int getLast_level() {
        return last_level;
    }

    public void setLast_level(int last_level) {
        this.last_level = last_level;
    }
}