# 🕒 Time Conversion with java

📌 Description

Given a time in 12-hour AM/PM format, your task is to convert it to military (24-hour) time.

🔹 Rules:

* 12:00:00 AM (midnight) converts to 00:00:00.
* 12:00:00 PM (noon) remains 12:00:00.

✅ Function Signature
```java
public class TimeConversion {
    public static String timeConversion(String s) {
        // Parse the input string and convert to 24-hour format
        int hour = Integer.parseInt(s.substring(0, 2));
        String minutesAndSeconds = s.substring(2, 8);
        String period = s.substring(8, 10);

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0; // Midnight case (12 AM -> 00)
            }
        } else { // PM case
            if (hour != 12) {
                hour += 12; // Convert PM hours (except 12 PM)
            }
        }

        return String.format("%02d%s", hour, minutesAndSeconds);
    }

    public static void main(String[] args) {
        // Example usage
        String input = "07:05:45PM";
        System.out.println(timeConversion(input)); // Output: 19:05:45
    }
}

```
📥 Input

* A single string s representing time in 12-hour format (e.g., 07:05:45PM).

📤 Output

* A string representing the 24-hour format time.

📌 Constraints

* The input time will always be valid.

🔍 Example

| Input |	Output |
|-------|--------|
|07:05:45PM	| 19:05:45 |
|12:01:00AM	| 00:01:00 |
|12:30:00PM	| 12:30:00 |



