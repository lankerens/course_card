package cn.edu.csust.coursecard.utils;

import cn.edu.csust.coursecard.common.CodeEnum;
import cn.edu.csust.coursecard.exception.BaseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zsw
 * @date 2019/11/19 20:44
 */
public class CalendarUtil {
    /**
     * days为负数获取前 days天
     * days为整数获取后 days 天
     * @param now
     * @param sdf
     * @param days
     * @return
     */
    public static String getDateOfDesignDay(Date now, SimpleDateFormat sdf, int days) {
        try {
            Calendar c = Calendar.getInstance();
            if (null != now) {
                c.setTime(now);
            }
            c.add(Calendar.DAY_OF_YEAR, days);
            return sdf.format(c.getTime());
        } catch (Exception e) {
            throw new BaseException(CodeEnum.SYSTEM_ERROR.getCode(),"系统错误");
        }
    }
}
