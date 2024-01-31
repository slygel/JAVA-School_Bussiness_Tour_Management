package exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    
    public static boolean isDate(String target) {
        String dateFormatRegex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(dateFormatRegex);
        Matcher matcher = pattern.matcher(target.trim());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(target);
            return true && matcher.matches();
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isFuture(String before, String after) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateAfter = LocalDate.parse(after, formatter);
        LocalDate dateBefore = LocalDate.parse(before, formatter);
        return dateBefore.isBefore(dateAfter);
    }

    
    public static boolean isValidEmail(String email){
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
         Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String formatName(String fullName) {
        String[] parts = fullName.split("\\s+");
        StringBuilder formattedName = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                formattedName.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1)).append(" ");
            }
        }
        return formattedName.toString().trim();
    }
}
