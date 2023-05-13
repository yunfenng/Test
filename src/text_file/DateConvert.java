package text_file;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Jaa
 * @Date: 2023/5/12 8:43
 * @Description:
 */
public class DateConvert {

    public static void main(String[] args) {
        // 获取当前日期和时间
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 获取前一天的日期
        LocalDate previousDate = currentDateTime.toLocalDate().minusDays(1);

        // 获取当前时间
        LocalTime currentTime = currentDateTime.toLocalTime();

        // 创建前一天的相同时刻的日期时间对象
        LocalDateTime previousDateTime = LocalDateTime.of(previousDate, currentTime);

        // 设置日期时间格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");

        // 格式化前一天的相同时刻为字符串
        String formattedDateTime = previousDateTime.format(formatter);

        // 输出结果
        System.out.println("Formatted DateTime: " + formattedDateTime); // 20230511022357





        // 获取当前日期和时间
        LocalDateTime currentDateTime1 = LocalDateTime.now();
        // 获取前一天的日期
        LocalDate previousDate1 = currentDateTime1.toLocalDate().minusDays(1);
        // 设置日期时间格式化器
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 格式化前一天的日期和时间为字符串
        String formattedDateTime1 = previousDate1.atStartOfDay().format(formatter1);
        // 输出结果
        System.out.println("Formatted DateTime: " + formattedDateTime1); // 2023-05-11
    }
}
