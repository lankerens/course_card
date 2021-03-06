package cn.edu.csust.coursecard.utils;

import cn.edu.csust.coursecard.bean.WeekDay;
import cn.edu.csust.coursecard.bean.WeekDayEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author zsw
 * @date 2020/02/08 08:09
 */
public class WeekUtil {
	private static SimpleDateFormat weekDaySdf = new SimpleDateFormat("EEEE");
	private static SimpleDateFormat daySdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 获取每周周一对应的日期
	 * @param nowWeek 当前周次
	 * @param totalWeek 总周次
	 * @return
	 * @throws ParseException
	 */
	public static List<WeekDay> getWeekDays(int nowWeek, int totalWeek) throws ParseException {
		Date date = new Date();
		String weekDay = weekDaySdf.format(date);
		Integer weekIdByStr = WeekDayEnum.getWeekIdByStr(weekDay);
		int sub = 1 - weekIdByStr;
		String dayOfWeekMon = CalendarUtil.getDateOfDesignDay(date, daySdf, sub);
		Date monDate;
		monDate = daySdf.parse(dayOfWeekMon);
		List<WeekDay> weekDays = new ArrayList<>();
		int index = 0;
		for (int i = nowWeek; i >= 1; i--) {
			WeekDay weekDayTemp = new WeekDay();
			weekDayTemp.setWeekId(i);
			weekDayTemp.setWeekMonStr(CalendarUtil.getDateOfDesignDay(monDate, daySdf, index * 7 * -1));
			index++;
			weekDays.add(weekDayTemp);
		}
		index = 1;
		for (int i = nowWeek + 1; i <= totalWeek; i++) {
			WeekDay weekDayTemp = new WeekDay();
			weekDayTemp.setWeekId(i);
			weekDayTemp.setWeekMonStr(CalendarUtil.getDateOfDesignDay(monDate, daySdf, index * 7));
			index++;
			weekDays.add(weekDayTemp);
		}
		Collections.sort(weekDays);
		return weekDays;
	}


}
