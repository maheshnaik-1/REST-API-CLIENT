import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter latitude (e.g., 35): ");
        String latitude = scanner.nextLine();
        System.out.print("Enter longitude (e.g., 139): ");
        String longitude = scanner.nextLine();
        try {
            String apiUrl = String.format(
                    "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true",
                    latitude, longitude
            );
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                reader.close();
                String json = responseBuilder.toString();
                // Debug: print full JSON response
                System.out.println("Full API Response: " + json);
                // Extract 'current_weather' JSON substring
                String currentWeatherJson = extractObject(json, "\"current_weather\":");
                // Extract values from current_weather JSON
                String temperature = extractValue(currentWeatherJson, "\"temperature\":", ",");
                String windspeed = extractValue(currentWeatherJson, "\"windspeed\":", ",");
                String time = extractValue(currentWeatherJson, "\"time\":\"", "\"");
                System.out.println("\nWeather Report:");
                System.out.println("Temperature: " + temperature + " °C");
                System.out.println("Wind Speed: " + windspeed + " km/h");
                System.out.println("Time: " + time);
            } else {
                System.out.println("GET request failed. HTTP Code: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    // Extracts a JSON object string starting after the key (assumes { ... } block)
    private static String extractObject(String json, String key) {
        int start = json.indexOf(key);
        if (start == -1) 
        return "";
        start += key.length();
        // Find first '{' after the key
        int objStart = json.indexOf("{", start);
        if (objStart == -1)
        return "";
        int braceCount = 0;
        int i = objStart;
        // Find matching closing brace for the JSON object
        for (; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') braceCount++;
            else if (c == '}') 
            braceCount--;
            if (braceCount == 0) 
            break;
        }
        if (braceCount != 0) 
        return "";
        return json.substring(objStart, i + 1);
    }
    // Extracts value after key up to delimiter
    private static String extractValue(String json, String key, String delimiter) {
        int start = json.indexOf(key);
        if (start == -1) 
        return "N/A";
        start += key.length();
        int end = json.indexOf(delimiter, start);
        if (end == -1) 
        end = json.length();
        return json.substring(start, end).replaceAll("\"", "").trim();
    }
}
