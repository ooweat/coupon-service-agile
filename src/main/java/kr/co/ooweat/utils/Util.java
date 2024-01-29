package kr.co.ooweat.utils;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

//TODO: 일단 통합으로 구현..
@Slf4j
public class Util {

    //날짜 & 시간 관련 Utils
    public static DateUtils dateUtils() {
        return new DateUtils();
    }

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMM");

    public static class DateUtils {
    
        public String now(String format) {
            if(format.isEmpty()){
                return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            } else {
                return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
            }
        }
        public String yyyyMM() {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
        }

        public String yyyyMM(int option) {
            String result = null;
            if (option == 0) {
                result = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
            } else if (option > 0) {    //NOTE: 미래
                result = LocalDateTime.now().plusMonths(option)
                    .format(DateTimeFormatter.ofPattern("yyyyMM"));
            } else if (option < 0) {    //NOTE: 과거
                option = option * -1;
                result = LocalDateTime.now().minusMonths(option)
                    .format(DateTimeFormatter.ofPattern("yyyyMM"));
            }
            return result;
        }

        //NOTE: 기존 Service 대응하기 위함.
        public String yyyyMMdd() {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        }

        //NOTE: 범위 지정 시 Option 을 넣어 사용.
        public String yyyyMMdd(int dayOption) {
            return calcYYYYMMDD(dayOption);
        }

        public String yyyyMMddHH(int dayOption, int hourOption) {
            String day = null, hour = null;
            day = calcYYYYMMDD(dayOption);

            if (hourOption == 0) {
                hour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH"));
            } else if (hourOption > 0) {    //NOTE: 미래
                hour = LocalDateTime.now().plusHours(hourOption)
                    .format(DateTimeFormatter.ofPattern("HH"));
            } else if (hourOption < 0) {    //NOTE: 과거
                hourOption = hourOption * -1;
                hour = LocalDateTime.now().minusHours(hourOption)
                    .format(DateTimeFormatter.ofPattern("HH"));
            }
            return day+hour;
        }

        public String calcYYYYMMDD(int option){
            String day = null;
            if (option == 0) {
                day = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            } else if (option > 0) {    //NOTE: 미래
                day = LocalDateTime.now().plusDays(option)
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            } else if (option < 0) {    //NOTE: 과거
                option = option * -1;
                day = LocalDateTime.now().minusDays(option)
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            }
            return day;
        }

        public String calcHHMMSS(String HHMMSS, int option){
            String day = null;
            if (option == 0) {
                day = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
            } else if (option > 0) {    //NOTE: 미래
                day = LocalTime.parse(HHMMSS, DateTimeFormatter.ofPattern("HHmmss")).plusMinutes(option)
                        .format(DateTimeFormatter.ofPattern("HHmmss"));
            } else if (option < 0) {    //NOTE: 과거
                option = option * -1;
                day = LocalTime.parse(HHMMSS, DateTimeFormatter.ofPattern("HHmmss")).minusMinutes(option)
                        .format(DateTimeFormatter.ofPattern("HHmmss"));
            }
            return day;
        }
        public String hhmmss() {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
        }

        public String hh() {
            //(('0' + (date.getMonth() + 1)).slice(-2))
            String hh = "0"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH"));
            return hh.substring(hh.length() - 2);
        }

        public int dayOfWeek() {
            return LocalDateTime.now().getDayOfWeek().getValue();
        }
        public static String getWeekOfMonth (String yyyyMMdd) {
            return LocalDate.parse(yyyyMMdd, DateTimeFormatter.ofPattern("yyyyMMdd"))
                .format(DateTimeFormatter.ofPattern("W"));
        }

    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static int getDayOfWeek(String yyyyMMdd){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(yyyyMMdd,formatter);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getValue();
        // 1=월, 7=일요일

    }

    public static String getCurrentDD() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(date);
    }

    //문자열 Util
    public static StringUtil stringUtil(String param) {
        return new StringUtil(param);
    }

    public static class StringUtil {

        private String value;

        public StringUtil(String value) {
            this.value = value;
        }

        //SQL 의 그것과 같음 in
        public boolean in(String... values) {
            for (String v : values) {
                if (v.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        //SQL 의 그것과 같음 notIn
        public boolean notIn(String... values) {
            for (String v : values) {
                if (v.equals(value)) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public static Boolean empty(Object obj) {
        if (obj instanceof String) return obj == null || "".equals(obj.toString().trim());
        else if (obj instanceof List) return obj == null || ((List) obj).isEmpty();
        else if (obj instanceof Map) return obj == null || ((Map) obj).isEmpty();
        else if (obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
        else return obj == null;
    }
    
    public static Boolean notEmpty(Object obj) {
        return !empty(obj);
    }
}
