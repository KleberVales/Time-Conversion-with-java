
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

	public static String timeConversion(String s) {
		
		// Extract hour, minutes, seconds, and period (AM/PM)
		int hour = Integer.parseInt(s.substring(0, 2));
		String minutesAndSeconds = s.substring(2, 8);
		String period = s.substring(8, 10);

		// Convert time based on AM/PM
		if (period.equals("AM")) {
			if (hour == 12) {
				hour = 0; // Convert 12 AM to 00
			}
		} else { // PM case
			if (hour != 12) {
				hour += 12; // Convert PM hours (except 12 PM)
			}
		}

		// Format hour as two-digit string
		return String.format("%02d%s", hour, minutesAndSeconds);

	}

}

public class Resolution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result.timeConversion(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
