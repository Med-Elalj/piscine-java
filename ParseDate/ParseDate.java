import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDate {
    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("EEEE dd MMMM yyyy")
            .toFormatter(Locale.ENGLISH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(stringDate);
        int[] nums = new int[3];
        int count = 0;
        while (matcher.find() && count < 3) {
            nums[count++] = Integer.parseInt(matcher.group());
        }
        if (count < 3) {
            throw new IllegalArgumentException("Invalid time format");
        }
        int hours = nums[0];
        int minutes = nums[1];
        int seconds = nums[2];
        boolean isEvening = stringDate.toLowerCase().contains("evening");
        if (isEvening) {
            if (hours != 12) {
                hours += 12;
            }
        } else {
            if (hours == 12) {
                hours = 0;
            }
        }
        return LocalTime.of(hours, minutes, seconds);
    }

}
