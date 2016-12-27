package com.example.wangfei.compositeproject.model.utils;

import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wangfei on 16/9/21.
 */

public class TimeUtils {

    public static final String TAG = TimeUtils.class.getSimpleName();

    /**
     * --格式常用--start--
     */

    public final static String Y_M_DOT = "yyyy.MM";
    public final static String Y_M_D_DOT = "yyyy.MM.dd";
    public final static String Y_M_D_H_DOT = "yyyy.MM.dd HH";
    public final static String Y_M_D_H_M_DOT = "yyyy.MM.dd HH:mm";
    public final static String Y_M_D_H_M_S_DOT = "yyyy.MM.dd HH:mm:ss";

    /** --格式常用--end-- */

    /**
     * 东八区时间偏移量(毫秒).
     */
    public static final long UTC_8_OFFSET = 28800000;

    /**
     * eg: 2013-05-25.
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * eg: 2013年5月25日.
     */
    public static final String CN_YYYY_MM_DD = "yyyy年MM月dd日";

    /**
     * 用于时间格式化，eg:2013-05-25 15:35:20.
     */
    public static final String YYYY_MM_DD_KK_MM_SS = "yyyy-MM-dd kk:mm:ss";

    /**
     * 用于时间解析，eg:2013-05-25 15:35:20.
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 用户时间解析，eg:5月25日 15:35.
     */
    public static final String CN_MM_DD_HH_MM = "MM月dd日 HH:mm";

    /**
     * 用户时间解析，eg:2014年5月25日 15:35.
     */
    public static final String CN_YYYY_MM_DD_HH_MM = "yyyy年MM月dd日 HH:mm";

    /**
     * 一秒对应的毫秒数.
     */
    public static final long ONE_SECOND_IN_MILLIS = DateUtils.SECOND_IN_MILLIS;

    /**
     * 一分钟对应的毫秒数.
     */
    public static final long ONE_MINUTE_IN_MILLIS = DateUtils.MINUTE_IN_MILLIS;

    /**
     * 一小时对应的毫秒数.
     */
    public static final long ONE_HOUR_IN_MILLIS = DateUtils.HOUR_IN_MILLIS;

    /**
     * 一天对应的毫秒数.
     */
    public static final long ONE_DAY_IN_MILLIS = DateUtils.DAY_IN_MILLIS;

    public final static String FORMAT_MONTH = "yyyy-MM";
    public final static String FORMAT_DATE = "yyyy-MM-dd";
    public final static String FORMAT_HOUR = "yyyy-MM-dd kk";
    public final static String FORMAT_MINUTE = "yyyy-MM-dd kk:mm";
    public final static String FORMAT_TIME = "yyyy-MM-dd kk:mm:ss";

    public final static String FORMAT_TIME_DOT = "yyyy.MM.dd kk:mm:ss";
    public final static String FORMAT_DATE_DOT = "yyyy.MM.dd";

    public final static String PARSE_MONTH = "yyyy-MM";
    public final static String PARSE_DATE = "yyyy-MM-dd";
    public final static String PARSE_HOUR = "yyyy-MM-dd HH";
    public final static String PARSE_MINUTE = "yyyy-MM-dd HH:mm";
    public final static String PARSE_TIME = "yyyy-MM-dd HH:mm:ss";

    public final static String PARSE_TIME_DOT = "yyyy.MM.dd HH:mm:ss";

    public final static String FORMAT_MONTH_STR = "yyyyMM";
    public final static String FORMAT_DATE_STR = "yyyyMMdd";
    public final static String FORMAT_HOUR_STR = "yyyyMMdd_kk";
    public final static String FORMAT_MINUTE_STR = "yyyyMMdd_kk:mm";
    public final static String FORMAT_TIME_STR = "yyyyMMdd_kkmmss";

    public final static String PARSE_MONTH_STR = "yyyyMM";
    public final static String PARSE_DATE_STR = "yyyyMMdd";
    public final static String PARSE_HOUR_STR = "yyyyMMdd_HH";
    public final static String PARSE_MINUTE_STR = "yyyyMMdd_HH:mm";
    public final static String PARSE_TIME_STR = "yyyyMMdd_HHmmss";

    public final static int ONE_DAY = 24 * 60 * 60 * 1000;
    public final static int TWO_DAY = 2 * 24 * 60 * 60 * 1000;
    public final static int ONE_HOUR = 60 * 60 * 1000;
    public final static int TEN_MINUTES = 10 * 60 * 1000;


    /**
     * --格式--start--
     */
    public final static String Y = "yyyy";
    public final static String M = "MM";
    public final static String D = "dd";
    public final static String H_H_1 = "hh";//半天的小时数（1-12）
    public final static String H_H_2 = "HH";//一天的小时数（0-23）
    public final static String H_K_1 = "KK";//半天的小时数（0-11）
    public final static String H_K_2 = "kk";//一天的小时数（1-24）
    public final static String F = "mm";
    public final static String S = "ss";

    public final static String Blank = " ";
    public final static String Dot = ".";
    public final static String Dash = "_";
    public final static String Minus = "-";
    public final static String Colon = ":";
    /**
     * --格式--end--
     */

    public final static String Y_M_MINUS = "yyyy-MM";
    public final static String Y_M_D_MINUS = "yyyy-MM-dd";
    public final static String Y_M_D_H_MINUS = "yyyy-MM-dd HH";
    public final static String Y_M_D_H_M_MINUS = "yyyy-MM-dd HH:mm";
    public final static String Y_M_D_H_M_S_MINUS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间通用类.
     */
    private TimeUtils() {
    }

    /**
     * 获取Time对象.
     *
     * @param millis 时间戳
     */
    public static Time getTime(final long millis) {
        Time time = new Time();
        time.set(millis);
        return time;
    }

    /**
     * 获取Date对象.
     *
     * @param timeInMillis
     * @param format
     */
    public static Date getDate(long timeInMillis, String format) {
        SimpleDateFormat fm = new SimpleDateFormat(format);
        try {
            String formatDate = formatBase(timeInMillis, format);
            return fm.parse(formatDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long getDateTime(long timeInMillis, String format) {
        return getDate(timeInMillis, format).getTime();
    }

    /**
     * 把用户时区的时间戳转成UTC时间戳.
     *
     * @param millis 用户时区的时间戳
     * @return UTC时间戳
     */
    public static long getUtcMillis(final long millis) {
        Time time = getTime(millis);
        long offset = time.gmtoff * DateUtils.SECOND_IN_MILLIS;
        return millis - offset;
    }

    /**
     * 把用户时区的时间戳转成东八区时间戳
     *
     * @param millis 用户时区的时间戳
     * @return 东八区时间戳
     */
    public static long getMillis(final long millis) {
        return getUtcMillis(millis) + UTC_8_OFFSET;
    }

    /**
     * 把YYYY_MM_DD形式的date转换成PHP服务器的时间戳（11位）
     *
     * @param date YYYY_MM_DD形式
     * @return
     */
    public static long getSecondsFromDate(final String date) {
        return getSecondsFromMillis(TimeUtils.parseBase(date, YYYY_MM_DD));
    }

    /**
     * 把客户端时间戳（13位）转换成PHP服务器的时间戳（11位）
     *
     * @param millis 客户端时间戳
     * @return PHP服务器时间戳
     */
    public static long getSecondsFromMillis(final long millis) {
        return millis / 1000;
    }

    /**
     * 把PHP服务器的时间戳（11位）转换成客户端时间戳（13位）.
     *
     * @param seconds 服务器时间戳
     * @return 客户端时间戳
     */
    public static long getMillisFromSeconds(final long seconds) {
        return seconds * 1000;
    }

    /**
     * 获取东八区当前时间戳.
     *
     * @return 东八区当前时间戳
     */
    public static long getCurMillis() {
        return getMillis(System.currentTimeMillis());
    }

    /**
     * 获取东八区当前时间的毫秒值(yyyy-MM-dd转换的).
     *
     * @return
     */
    public static long getCurDateMillis() {
        long millis;
        millis = parseBase(getCurDateText(), YYYY_MM_DD);
        return millis;
    }

    /**
     * 获取东八区当前时间的描述(yyyy-MM-dd).
     *
     * @return 东八区当前时间的描述
     */
    public static String getCurDateText() {
        long curMillis = getCurMillis();
        return TimeUtils.formatBase(curMillis, YYYY_MM_DD);
    }

    /**
     * 获取当前时间的描述(yyyy-MM-dd HH:mm:ss).
     *
     * @return 当前时间的描述
     */
    public static String getCurDateTimeText() {
        long curMillis = getCurMillis();
        return TimeUtils.formatBase(curMillis, YYYY_MM_DD_KK_MM_SS);
    }

    /**
     * 获取YYYY_MM_DD形式date.
     *
     * @param phpSeconds
     * @return
     */
    public static String getDateText(long phpSeconds) {
        return TimeUtils.formatBase(TimeUtils.getMillisFromSeconds(phpSeconds), YYYY_MM_DD);
    }

    /**
     * 获取YYYY_MM_DD_KK_MM_SS形式date.
     *
     * @param phpSeconds
     * @return
     */
    public static String getDateTimeText(long phpSeconds) {
        return TimeUtils.formatBase(TimeUtils.getMillisFromSeconds(phpSeconds), YYYY_MM_DD_KK_MM_SS);
    }

    /* 解析millis -- start */

    /** --时间格式--start-- */

    /**
     * 把时间毫秒值格式成时间文本.
     *
     * @param millis 时间毫秒值
     * @param fmt    时间格式串
     * @return 时间文本
     */
    public static String format(final long millis, final String fmt) {
        try {
            if (TextUtils.isEmpty(String.valueOf(millis))) {
                throw new NullPointerException("dateText不能为空");
            } else if (TextUtils.isEmpty(fmt)) {
                throw new NullPointerException("fmt不能为空");
            }
            SimpleDateFormat fm = new SimpleDateFormat(fmt);
            return fm.format(new Date(millis));
        } catch (NullPointerException e) {
            LogUtils.e(TAG, e.getMessage());
            return null;
        }

        /*
        if (TextUtils.isEmpty(fmt)) {
            throw new NullPointerException("fmt不能为空");
        }
        return (String) DateFormat.format(fmt, millis);
        */
    }

    /**
     * 把时间文本解析成时间毫秒值.
     *
     * @param dateText 时间文本
     * @param fmt      时间格式串
     * @return 时间毫秒值
     */
    public static long parse(final String dateText, final String fmt) {
        try {
            if (TextUtils.isEmpty(dateText)) {
                throw new NullPointerException("dateText不能为空");
            } else if (TextUtils.isEmpty(fmt)) {
                throw new NullPointerException("fmt不能为空");
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmt, Locale.getDefault());
            Date date = sdf.parse(dateText);
            return date.getTime();
        } catch (NullPointerException e) {
            LogUtils.e(TAG, e.getMessage());
            return 0;
        } catch (ParseException e) {
            LogUtils.e(TAG, e.getMessage());
            return 0;
        }
    }

    /** --时间格式--end-- */

    /**
     * 把时间文本转换成时间戳.
     *
     * @param dateText 时间文本
     * @param fmt      时间格式
     * @return 时间戳
     */
    public static long parseBase(final String dateText, final String fmt) {
        try {
            if (TextUtils.isEmpty(dateText)) {
                throw new NullPointerException("dateText不能为空");
            } else if (TextUtils.isEmpty(fmt)) {
                throw new NullPointerException("fmt不能为空");
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmt, Locale.getDefault());
            Date date = sdf.parse(dateText);
            return date.getTime();
        } catch (NullPointerException e) {
            LogUtils.e(TAG, e.getMessage());
            return 0;
        } catch (ParseException e) {
            LogUtils.e(TAG, e.getMessage());
            return 0;
        }
    }

    /**
     * 把时间文本转换成时间戳.
     *
     * @param dateText 时间文本
     * @return 时间戳
     */
    public static long parseDate(final String dateText) {
        return parseBase(dateText, PARSE_DATE);
    }

    /**
     * 把时间文本转换成时间戳.
     *
     * @param dateText 时间文本
     * @return 时间戳
     */
    public static long parseTimeWithDot(final String dateText) {
        return parseBase(dateText, PARSE_TIME_DOT);
    }

    public static long parseDate(long destTime) {
        String formatDate = formatDate(destTime);
        return parseDate(formatDate);
    }

    public static long parseHour(String formatTimeHour) {
        return parseBase(formatTimeHour, PARSE_HOUR);
    }

    /**
     * 把时间文本转换成时间戳.
     *
     * @param dateText 时间文本
     * @return 时间戳
     */
    public static long parseTime(final String dateText) {
        return parseBase(dateText, PARSE_TIME);
    }

    /**
     * 解析日期.
     *
     * @param formatDate String:yyyyMMdd
     * @return int:yyyyMMdd
     */
    public static int parseAsIntDate(String formatDate) {
        String intDate = formatDate.replace("-", "");
        return Integer.valueOf(intDate);
    }

    /**
     * 解析日期.
     *
     * @param formatIntDate String:yyyyMMdd
     * @return date.getTime() 从基准时间到"yyyyMMdd"型formatTime的毫秒值
     */
    public static long parseIntDate(String formatIntDate) {
        return parseBase(formatIntDate, PARSE_DATE_STR);
    }

    /**
     * yyyyMMdd
     *
     * @param formatIntDate int: yyyyMMdd
     * @return date.getTime() 从基准时间到yyyyMMdd型formatTime的毫秒值
     */
    public static long parseIntDate(int formatIntDate) {
        return parseBase(formatIntDate + "", PARSE_DATE_STR);
    }

   /* 解析millis -- end */

    /* 格式text -- start */

    /**
     * 格式化时间戳.
     *
     * @param dateMillis 时间戳
     * @param fmt        时间格式
     * @return 格式化时间文本
     */
    public static String formatBase(final long dateMillis, final String fmt) {
        try {
            if (TextUtils.isEmpty(String.valueOf(dateMillis))) {
                throw new NullPointerException("dateText不能为空");
            } else if (TextUtils.isEmpty(fmt)) {
                throw new NullPointerException("fmt不能为空");
            }
            SimpleDateFormat fm = new SimpleDateFormat(fmt);
            return fm.format(new Date(dateMillis));
        } catch (NullPointerException e) {
            LogUtils.e(TAG, e.getMessage());
            return null;
        }

//        if (TextUtils.isEmpty(fmt)) {
//            throw new NullPointerException("fmt不能为空");
//        }
//        return (String) DateFormat.format(fmt, millis);
    }

    /**
     * 将输入时间文本格式化为其他格式的文本.
     *
     * @param inDateText 输入时间文本
     * @param inFmt      输入时间格式
     * @param outFmt     输出时间格式
     * @return 格式化后的时间文本
     * @throws ParseException 时间转换异常
     */
    public static String formatChange(final String inDateText, final String inFmt, final String outFmt) {
        try {
            if (TextUtils.isEmpty(inDateText)) {
                throw new NullPointerException("inDateText不能为空");
            } else if (TextUtils.isEmpty(inFmt)) {
                throw new NullPointerException("inFmt不能为空");
            } else if (TextUtils.isEmpty(outFmt)) {
                throw new NullPointerException("outFmt不能为空");
            }
            long millis = TimeUtils.parseBase(inDateText, inFmt);
            return TimeUtils.formatBase(millis, outFmt);
        } catch (NullPointerException e) {
            LogUtils.e(TAG, e.getMessage());
            return null;
        }

    }

    /**
     * 获取yyyy-MM-dd形式date.
     *
     * @param timeInMillis
     */
    public static String formatDate(long timeInMillis) {
        return formatBase(timeInMillis, FORMAT_DATE);
    }

    /**
     * format as yyyy-MM-dd
     *
     * @param intDate yyyyMMdd
     * @return yyyy-MM-dd
     */
    public static String formatDate(int intDate) {
        long time = parseIntDate(intDate);
        return formatBase(time, FORMAT_DATE);
    }

    /**
     * 获取yyyy-MM-dd HH形式date.
     *
     * @param timeInMillis
     */
    public static String formatHour(final long timeInMillis) {
        return formatBase(timeInMillis, FORMAT_HOUR);
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss形式date.
     *
     * @param timeInMillis
     */
    public static String formatTime(final long timeInMillis) {
        return formatBase(timeInMillis, FORMAT_TIME);
    }

    /**
     * 获取yyyy.MM.dd HH:mm:ss形式date.
     *
     * @param timeInMillis
     */
    public static String formatTimeDot(final long timeInMillis) {
        return formatBase(timeInMillis, FORMAT_TIME_DOT);
    }

    /**
     * 获取yyyy.MM.dd形式date.
     *
     * @param timeInMillis
     */
    public static String formatDateDot(final long timeInMillis) {
        return formatBase(timeInMillis, FORMAT_DATE_DOT);
    }

    /**
     * 获取YYYY年MM月形式date.
     *
     * @param timeInMillis
     * @return
     */
    public static String formatTextInYearAndMonth(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return String.format("%4d年%2d月", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * format as yyyyMM
     *
     * @param timeInMillis
     */
    public static String formatYearMonthDate(long timeInMillis) {
        return formatBase(timeInMillis, FORMAT_MONTH_STR);
    }

    /**
     * format as yyyyMMdd
     *
     * @param timeInMillis
     */
    public static String formatAsIntDate(long timeInMillis) {
        return formatBase(timeInMillis, FORMAT_DATE_STR);
    }

    /* 格式text -- end */

    /* 日期判断 -- start */

    public static boolean isSameDate(long time1, long time2) {
        Date date1 = new Date(time1);
        Date date2 = new Date(time2);
        return date1.getDate() == date2.getDate()
                && date1.getMonth() == date2.getMonth()
                && date1.getYear() == date2.getYear();
    }

    public static boolean isToday(Date destTime) {
        int year = destTime.getYear();
        int month = destTime.getMonth();
        int day = destTime.getDate();
        Date now = new Date();
        if (year == now.getYear() && month == now.getMonth()
                && day == now.getDate()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isToday(long destTime) {
        return isToday(new Date(destTime));
    }

    public static boolean isTomorrowDay(Date destTime) {
        int year = destTime.getYear();
        int month = destTime.getMonth();
        int day = destTime.getDate();
        Date now = new Date(Calendar.getInstance().getTimeInMillis() + ONE_DAY);
        if (year == now.getYear() && month == now.getMonth()
                && day == now.getDate()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isTomorrow(long destTime) {
        return isTomorrowDay(new Date(destTime));
    }

    public static boolean isYesterday(Date destTime) {
        int year = destTime.getYear();
        int month = destTime.getMonth();
        int day = destTime.getDate();
        Date now = new Date(Calendar.getInstance().getTimeInMillis() - ONE_DAY);
        if (year == now.getYear() && month == now.getMonth()
                && day == now.getDate()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isYesterday(long destTime) {
        return isYesterday(new Date(destTime));
    }

    public static boolean isNextDay(long lastTime) {
        return System.currentTimeMillis() > getClock24Time(lastTime);
    }

    public static boolean isNextDay(long lastTime, int intervalDays) {
        return (System.currentTimeMillis() - intervalDays * ONE_DAY) > getClock24Time(lastTime);
    }

    public static boolean isNextDayNow(long currentTime, long previousTime) {
        if (currentTime > previousTime) {
            long diff = currentTime - previousTime;
            return diff > ONE_DAY;
        }
        return false;
    }

    public static boolean isNextDayNow(long prevTime) {
        return isNextDayNow(System.currentTimeMillis(), prevTime);
    }

    public static boolean isNextHour(long prevTime) {
        return isNextHour(System.currentTimeMillis(), prevTime);
    }

    public static boolean isNextHour(long currentTime, long previousTime) {
        if (currentTime > previousTime) {
            long diff = currentTime - previousTime;
            return diff > ONE_HOUR;
        }
        return false;
    }

    public static boolean isNextTime(long lastTime, int interval) {
        long now = System.currentTimeMillis();
        if (now > lastTime) {
            long diff = now - lastTime;
            return diff > interval;
        }
        return false;
    }

    /* 日期判断 -- end */

    /** --日期的单个元素的差值--start-- */

    /**
     * 计算previousMillis到nextMillis间的天数
     *
     * @param previousMillis
     * @param nextMillis
     * @return
     */
    public static int caculateDiffDays(long previousMillis, long nextMillis) {
        long diff = Math.abs(nextMillis - previousMillis);
        int diffDays = (int) Math.floor(diff / ONE_DAY);
        return diffDays;
    }

    /**
     * 计算当前日期到previousMillis的间隔天数.
     *
     * @param previousMillis
     */
    public static int caculateDiffDays(long previousMillis) {
        return caculateDiffDays(previousMillis, System.currentTimeMillis());
        /*
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        int nowYear = cal.get(Calendar.YEAR);
        int nowDay = cal.get(Calendar.DAY_OF_YEAR);
        // previous time
        cal.setTimeInMillis(previousMillis);
        int prevYear = cal.get(Calendar.YEAR);
        int prevDay = cal.get(Calendar.DAY_OF_YEAR);
        if (nowYear > prevYear) {
            nowDay = (nowYear - prevYear) * 365;
        }
        int diffDay = nowDay - prevDay;
        return diffDay;

        Date date = new Date(previousMillis);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        long deffTime = System.currentTimeMillis() - date.getTime();
        return (int) Math.ceil(deffTime / ONE_DAY);
        */
    }

    /**
     * 计算[previousMillis,nextMillis]间的月数
     *
     * @param startMonthMillis
     * @param endMonthMillis
     */
    public static int caculateDiffMonths(long startMonthMillis, long endMonthMillis) {
        if (startMonthMillis >= endMonthMillis) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(startMonthMillis);
        int pYear = cal.get(Calendar.YEAR);
        int pMonth = cal.get(Calendar.MONTH);
        cal.setTimeInMillis(endMonthMillis);
        int nYear = cal.get(Calendar.YEAR);
        int nMonth = cal.get(Calendar.MONTH);
        int diffMonths = nMonth >= pMonth ? ((nYear - pYear) * 12 + nMonth - pMonth) : ((nYear - pYear - 1) * 12 + 12 + nMonth - pMonth);
        return diffMonths;
    }

    /**
     * 计算prevMillis到nextMillis间的年数
     *
     * @param prevMillis 起点毫秒值
     * @param nextMillis 终点毫秒值
     * @return
     */
    public static int caculateDiffYearsOfAge(long prevMillis, long nextMillis) {
        Date pDate = new Date(prevMillis);
        int pYear = pDate.getYear();
        int pMonth = pDate.getMonth();
        int pDateDay = pDate.getDate();
        Date nDate = new Date(nextMillis);
        int nYear = nDate.getYear();
        int nMonth = nDate.getMonth();
        int nDateDay = nDate.getDate();
        int diffYears = Math.abs(nYear - pYear);
        if (diffYears > 0 && nMonth < pMonth
                || (nMonth == pMonth && nDateDay < pDateDay)) {
            diffYears--;
            Log.i("hulk", "birthday: " + pDate.toLocaleString());
        }
        return diffYears;
    }

    /** --日期的单个元素的差值--end-- */

    /** --日期的单个元素的整数值--start-- */

    /**
     * 获取指定毫秒值的年份
     *
     * @param millis
     */
    public static int getYear(long millis) {
        if (millis < 0) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取比指定毫秒值早diffMont个月的年份
     *
     * @param refTimeMillis
     * @param diffMonth     要早或要晚的月数
     * @param isLate        true:向后 false:向前
     */
    public static int getYear(long refTimeMillis, int diffMonth, boolean isLate) {
        int rYear = getYear(refTimeMillis);
        int dYear = diffMonth / 12;
        int rMonth = getMonth(refTimeMillis);
        int dMonth = diffMonth % 12;
        if (isLate) {
            return (rMonth + dMonth <= 12 ? (rYear + dYear) : (rYear + dYear + 1));
        } else {
            return (rMonth > dMonth ? (rYear - dYear) : (rYear - dYear - 1));
        }
    }

    /**
     * 获取比指定毫秒值早diffMont个月的年份
     *
     * @param latestTimeMillis
     * @param diffMonth        要早的月数
     */
    public static int getYear(long latestTimeMillis, int diffMonth) {
        return getYear(latestTimeMillis, diffMonth, false);
    }

    /**
     * 获取指定毫秒值的月份(以1始).
     *
     * @param millis
     */
    public static int getMonth(long millis) {
        if (millis < 0) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取比指定毫秒值早diffMont个月的月份(以1始)
     *
     * @param refTimeMillis
     * @param diffMonth     要早或要晚的月数
     * @param isLate        true:向后 false:向前
     */
    public static int getMonth(long refTimeMillis, int diffMonth, boolean isLate) {
        int rMonth = getMonth(refTimeMillis);
        int dMonth = diffMonth % 12;
        if (isLate) {
            return (rMonth + dMonth <= 12 ? (rMonth + dMonth) : (rMonth + dMonth - 12));
        } else {
            return (rMonth > dMonth ? (rMonth - dMonth) : (rMonth - dMonth + 12));
        }
    }

    /**
     * 获取比指定毫秒值早diffMont个月的月份(以1始)
     *
     * @param latestTimeMillis
     * @param diffMonth        要早的月数
     */
    public static int getMonth(long latestTimeMillis, int diffMonth) {
        return getMonth(latestTimeMillis, diffMonth, false);
//        if (latestTimeMillis<0) {
//            return 0;
//        }
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(latestTimeMillis);
//        int lMonth = cal.get(Calendar.MONTH);
//        int dMonth = diffMonth%12;
//        return (lMonth>=dMonth?(lMonth-dMonth +1):(12+lMonth-dMonth +1));
    }

    /**
     * 获取指定毫秒值的月份的天数(31/30/29/28).
     *
     * @param millis
     */
    public static int getDayMax(Long millis) {
        if (millis < 0) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        //得到一个月最最后一天日期(31/30/29/28)
        int MaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return MaxDay;
    }

    /**
     * 获取此毫秒对应的日期如：2015-06-27则返回27
     *
     * @param millis
     */
    public static int getDayOfMonth(Long millis) {
        if (millis < 0) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * --日期的单个元素的整数值--end--
     */




    /* 其它 -- start */
    public static long getTimeInMillis(long srcTime, int hour, int minute, int second) {
        try {
            Date date = new Date(srcTime);
            date.setHours(hour);
            date.setMinutes(minute);
            date.setSeconds(second);
            return date.getTime();
        } catch (Exception e) {
            return 0;
        }
    }

    public static long getTimeInMillis(long srcTime) {
        return getTimeInMillis(srcTime, 0, 0, 0);
    }

    public static boolean isInClock24() {
        return isInDestClock24(System.currentTimeMillis());
    }

    public static boolean isInDestClock24(long destDate) {
        return System.currentTimeMillis() < getClock24Time(destDate);
    }

    public static long getClock0Time(long destTime) {
        return getTimeInMillis(destTime, 0, 0, 1);
    }

    public static long getClock24Time(long destTime) {
        return getTimeInMillis(destTime, 23, 59, 59);
    }

    public static long getDateTime2(long destTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(destTime);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static long getDateNextDay(long destTime) {
        return getClock24Time(destTime) + 1000;
    }


    /**
     * 获取周岁.
     *
     * @param birthTimeInMillis 出生日期的毫秒值
     * @return years
     */
    public static int getAge(long birthTimeInMillis) {
        return caculateDiffYearsOfAge(birthTimeInMillis, System.currentTimeMillis());
    }

    /**
     * 获取周岁.
     *
     * @param formatDate String:yyyy-MM-dd
     * @return years
     */
    public static int getAge(String formatDate) {
        return getAge(parseDate(formatDate));
    }


    /**
     * "yyyyMMdd"
     *
     * @param timeInMillis
     * @return int yyyyMMdd
     */
    public static int toIntDate(long timeInMillis) {
        return Integer.valueOf(formatBase(timeInMillis, FORMAT_DATE_STR));
    }

    /**
     * @param formatDate yyyy-MM-dd
     * @return yyyyMMdd
     */
    public static int toAsIntDate(String formatDate) {
        return parseAsIntDate(formatDate);
    }

    public static int toAsIntDate(long timeInMillis) {
        return toIntDate(timeInMillis);
    }

    public static long toDateTimeInMillis(int formatIntDate) {
        return parseIntDate(String.valueOf(formatIntDate));
    }

    /**
     * @param formatIntDate yyyyMMdd
     * @return
     */
    public static int toIntDate(String formatIntDate) {
        return Integer.valueOf(formatIntDate);
    }

    public static String toLocaleString(long milliseconds) {
        return new Date(milliseconds).toLocaleString();
    }

    /**
     * @param formatDate : "20140405" or "2014-04-05"
     * @return date timestamp
     */
    public static long parseGenericDate(String formatDate) {
        long dateTimeStamp = 0;
        if (!formatDate.contains("-") && formatDate.length() == 8) {
            dateTimeStamp = parseIntDate(formatDate);
        } else if (formatDate.contains("-") && formatDate.length() == 10) {
            dateTimeStamp = parseDate(formatDate);
        } else {
            throw new IllegalArgumentException("The formatDate length Is Invalid,must(8 or 10) !! ");
        }
        return dateTimeStamp;
    }

    /**
     * @param timeInMillis  java timeInMillis orint date 20140405
     * @param withConnector with "-"
     * @return "20140405" or "2014-04-05"
     */
    public static String formatGenericDate(long timeInMillis, boolean withConnector) {
        String formatDate = null;
        String timeStr = String.valueOf(timeInMillis);
        if (timeStr.length() == 13) {
            if (withConnector) {
                formatDate = formatDate(timeInMillis);
            } else {
                formatDate = formatAsIntDate(timeInMillis);
            }
        } else if (timeStr.length() == 8) {
            formatDate = timeStr;
        } else {
            formatDate = formatDate(timeInMillis);
        }
        return formatDate;
    }

    public static long getNextDayTime(long time) {
        return time + ONE_DAY;
    }

    public static long getPrevDayTime(long time) {
        return time - ONE_DAY;
    }

    /**
     * change time period to "00:00:00"
     */
    public static String formatTimePeriod(long time) {
        if (time < 0) {
            return "00:00:00";
        }
        String timeCount = "";
        long hourc = time / ONE_HOUR;
        String hour = String.valueOf(hourc);
        if (hour.length() < 2) {
            hour = "0" + hourc;
        }
        long minuec = (time % ONE_HOUR) / (60000);
        String minue = "0" + minuec;
        minue = minue.substring(minue.length() - 2, minue.length());
        long secc = (time % 60000) / 1000;
        String sec = "0" + secc;
        sec = sec.substring(sec.length() - 2, sec.length());
        timeCount = hour + " : " + minue + " : " + sec;
        return timeCount;
    }

    public static boolean isExpired(String date, String format) {
        return System.currentTimeMillis() > parseBase(date, format);
    }

    public static boolean isExpired(long time) {
        return time < System.currentTimeMillis();
    }

    public static SimpleDateFormat getDateFormat(String format) {
        SimpleDateFormat fm = new SimpleDateFormat(format);
        return fm;
    }

//    public static boolean isRecipeUpdateIn24(Context context) {
//        long before = SubmitData.getRecipeUpLoadTime();
//        Date d = new Date(before);
//        int beforeD = d.getDay();
//        Date current = new Date(Calendar.getInstance().getTimeInMillis());
//        int currentD = current.getDay();
//        return Math.abs(currentD - beforeD) >= 1 ? false : true;
//    }

    public static long getCurrDateMillons() {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        String text = sdf.format(new Date());
        Date dt = null;
        try {
            dt = sdf.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt.getTime();
    }

    /* 其它 -- end */

    public static boolean checkDate(String date, String format) {
        java.text.DateFormat df = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = df.parse(date);
        } catch (Exception e) {
            //如果不能转换,肯定是错误格式
            return false;
        }
        String s1 = df.format(d);
        // 转换后的日期再转换回String,如果不等,逻辑错误.如format为"yyyy-MM-dd",date为
        // "2006-02-31",转换为日期后再转换回字符串为"2006-03-03",说明格式虽然对,但日期
        // 逻辑上不对.
        return date.equals(s1);
    }


    /**
     * 获取当月的 天数
     *
     * @return
     */
    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 根据年 月 获取对应的月份 天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 找到对应日期的 星期几名
     *
     * @param date
     * @return "周一"至"周日"
     */
    public static String getDayNameOfWeekByDate(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E");
            String str = formatter.format(myDate);
            dayOfweek = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayOfweek;
    }

    /**
     * 找到当前日期的 星期几名
     *
     * @return "周一"至"周日"
     */
    public static String getDayNameOfWeekByCur() {
        return getDayNameOfWeekByDate(getCurDateText());
    }

    /**
     * 根据日期 找到对应日期的 星期几编号
     *
     * @param date
     * @return 1至7
     */
    public static int getDayIndexOfWeekByDate(String date) {
        int dayOfweek = -1;
        if (date.equals("周一")) {
            dayOfweek = 1;
        } else if (date.equals("周二")) {
            dayOfweek = 2;
        } else if (date.equals("周三")) {
            dayOfweek = 3;
        } else if (date.equals("周四")) {
            dayOfweek = 4;
        } else if (date.equals("周五")) {
            dayOfweek = 5;
        } else if (date.equals("周六")) {
            dayOfweek = 6;
        } else if (date.equals("周日")) {
            dayOfweek = 7;
        }
        return dayOfweek;
    }

    /**
     * 获取指定毫秒值之前或之后的第一个月份的第一天的0点
     *
     * @param refMills
     * @param difMonths
     */
    public static String getMonthFirstDay(long refMills, int difMonths, boolean isLate) {
        String result = "";
        int year = TimeUtils.getYear(refMills, difMonths, isLate);
        int month = TimeUtils.getMonth(refMills, difMonths, isLate);
        result = result + year + "." + (month < 10 ? "0" + month : "" + month) + "." + "01" + " 00:00:00";
        return result;
    }

    /**
     * 获取指定毫秒值之前或之后的第一个月份的第一天的0点
     *
     * @param refMills
     * @param difMonths 相差月数
     * @param isLate    true:后
     */
    public static String getMonthFirstDayOfMinus(long refMills, int difMonths, boolean isLate) {
        String result = "";
        int year = TimeUtils.getYear(refMills, difMonths, isLate);
        int month = TimeUtils.getMonth(refMills, difMonths, isLate);
        result = result + year + "-" + (month < 10 ? "0" + month : "" + month) + "-" + "01" + " 00:00:00";
        return result;
    }

    /**
     * 获取小时
     */
    public static int getHour() {
        Date date = new Date(getCurMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(H_H_2);
        String hour = simpleDateFormat.format(date);
        return Integer.parseInt(hour);
    }
}
