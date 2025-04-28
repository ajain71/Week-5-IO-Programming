import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        String line = br.readLine();
        int emailIdx = -1, phoneIdx = -1;

        if (line != null) {
            String[] headers = line.split(",");
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase("Email")) emailIdx = i;
                else if (headers[i].equalsIgnoreCase("Phone Numbers")) phoneIdx = i;
            }
        }

        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            boolean valid = true;

            if (emailIdx != -1 && (emailIdx >= parts.length || !emailPattern.matcher(parts[emailIdx]).matches())) {
                System.out.println("Invalid Email: " + line);
                valid = false;
            }
            if (phoneIdx != -1 && (phoneIdx >= parts.length || !phonePattern.matcher(parts[phoneIdx]).matches())) {
                System.out.println("Invalid Phone Number: " + line);
                valid = false;
            }
        }

        br.close();
    }
}
