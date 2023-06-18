package text_file;

import lombok.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Data
class Person {
    private String name;
    private String gender;
    private int age;
    private double salary;

    public Person(String name, String gender, int age, double salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

}

@Data
class TotalInfo {
    private int sourceType;
    private String reqSeqId;
    private int totalCount;
    private double totalSalary;

    public TotalInfo(int sourceType, String reqSeqId, int totalCount, double totalSalary) {
        this.sourceType = sourceType;
        this.reqSeqId = reqSeqId;
        this.totalCount = totalCount;
        this.totalSalary = totalSalary;
    }

    // Getter and setter methods
}

public class FileGeneratorPro {

    private static final int MAX_BATCH_SIZE = 5;

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("张三01", "Male", 30, 50000.0),
                new Person("张三02", "Female", 35, 60000.0),
                new Person("张三03", "Male", 28, 45000.0),
                new Person("张三04", "Female", 25, 55000.0),
                new Person("张三05", "Male", 30, 50000.0),

                new Person("张三06", "Female", 35, 60000.0),
                new Person("张三07", "Male", 28, 45000.0),
                new Person("张三08", "Female", 25, 55000.0),
                new Person("张三09", "Male", 30, 50000.0),
                new Person("张三10", "Female", 35, 60000.0),

                new Person("张三11", "Male", 28, 45000.0),
                new Person("张三12", "Female", 25, 55000.0)
        );

        int totalPersonCount = personList.size();
        int batchCount = (int) Math.ceil((double) totalPersonCount / MAX_BATCH_SIZE);

        TotalInfo totalInfo = new TotalInfo(1006, "010101", totalPersonCount, calculateTotalSalary(personList));

        String baseFileName = "1006";
        String fileExtension = ".txt";

        String fileNum = "";

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

        try {
            int batchIndex = 1;
            int personIndex = 0;

            while (personIndex < totalPersonCount) {
                int num = batchCount;
                if (num < 10) {
                    fileNum = "00" + num;
                } else if (num >= 10 && num < 100) {
                    fileNum = "0" + num;
                } else {
                    fileNum = "" + num;
                }

                String serNum = "";
                if (batchIndex < 10) {
                    serNum = "0" + batchIndex;
                } else {
                    serNum = "" + batchIndex;
                }

                String fileName = baseFileName + lastDayTime + fileNum + "_" + serNum + fileExtension;

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                    // Write TotalInfo data on the first line
                    String totalInfoLine = totalInfo.getSourceType() + "|" +
                            totalInfo.getReqSeqId() + "|" +
                            totalInfo.getTotalCount() + "|" +
                            totalInfo.getTotalSalary();
                    writer.write(totalInfoLine);
                    writer.newLine();

                    // Write Person data from the second line
                    int batchLimit = Math.min(MAX_BATCH_SIZE, totalPersonCount - personIndex);

                    for (int i = 0; i < batchLimit; i++) {
                        Person person = personList.get(personIndex);
                        String personLine = person.getName() + "|" +
                                person.getGender() + "|" +
                                person.getAge() + "|" +
                                person.getSalary();
                        writer.write(personLine);
                        writer.newLine();

                        personIndex++;
                    }

                    System.out.println("Data written to " + fileName + " successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while writing the data to the file.");
                    e.printStackTrace();
                }

                batchIndex++;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while processing the data.");
            e.printStackTrace();
        }
    }

    private static double calculateTotalSalary(List<Person> personList) {
        double totalSalary = 0;
        for (Person person : personList) {
            totalSalary += person.getSalary();
        }
        return totalSalary;
    }
}


