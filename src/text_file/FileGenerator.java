package text_file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileGenerator {

    public static List<File> generateTxtFile(List<Person> objects) throws IOException, IllegalAccessException {
        List<File> fileList = new ArrayList<>();

        int batchSize = 9999; // 每个文件的行数限制
        int fileCount = (int) Math.ceil((double) objects.size() / batchSize); // 文件数量

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
        // 格式化前一天的日期和时间为字符串
        String lastDayTime = previousDateTime.format(formatter);
        String fileNum = "";
        // 获取对象的Class
        Class<?> clazz = objects.get(0).getClass();

        // 获取对象的所有字段
        Field[] fields = clazz.getDeclaredFields();
        String totalCount = "";
        if (fileCount < 10) {
            totalCount = "0" + fileCount;
        } else {
            totalCount = "" + fileCount;
        }

        for (int i = 0; i < fileCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = Math.min(startIndex + batchSize, objects.size());
            int num = i + 1;
            if (num < 10) {
                fileNum = "00" + num;
            } else if (num >= 10 && num < 100) {
                fileNum = "0" + num;
            } else {
                fileNum = "" + num;
            }

            File file = new File("GCIS" + lastDayTime + fileNum + "_" + totalCount + ".txt");

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);

            // 写入属性名（第一行）
            /*for (String header : headers) {
                writer.write(header + "\t");
            }*/
            for (Field field : fields) {
                writer.write(field.getName());
                writer.write("\t");
            }
            writer.write("\n");

            // 写入数据
            for (int j = startIndex; j < endIndex; j++) {
                Object object = objects.get(j);

                for (Field field : fields) {
                    field.setAccessible(true);
                    Object value = field.get(object);
                    writer.write(String.valueOf(value));
                    writer.write("\t"); // 使用制表符分隔数据
                }
                writer.write("\n");
            }
            fileList.add(file);
            writer.close();
        }

        return fileList; // 返回第一个文件
    }

    public static void main(String[] args) {
        // 示例用法
        List<Person> objects = new ArrayList<>(); // 替换为实际对象列表
        for (int i = 1; i < 300; i++) {
            objects.add(new Person("风清扬" + i, "男", 80, "fengqingyang@huashan.com"));
            objects.add(new Person("令狐冲" + i, "男", 25, "linghuchong@huashan.com"));
            objects.add(new Person("东方伯" + i, "男", 40, "dongfang@heimuya.com"));
        }
        try {
            List<File> fileList = generateTxtFile(objects);
            fileList.forEach(file -> {
                System.out.println("文件生成成功：" + file.getAbsolutePath());
            });
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
