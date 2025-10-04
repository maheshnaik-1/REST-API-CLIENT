# REST-API-CLIENT

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: SUGALI MAHESH NAIK

*INTERN ID*: CT04DY1974

*DOMAIN*: JAVA PROGRAMMING

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTOSH

# Description of Task2:

WeatherApp is a Java console program that obtains current weather data using user-entered latitude and longitude. It leverages built-in Java classes like HttpURLConnection to send HTTP requests and parses the JSON response manually without relying on external libraries. The application can run on any Java-enabled platform such as IntelliJ or the command line. It is useful for understanding API calls and string processing in Java. After collecting coordinates, it requests weather details from the Open-Meteo API, extracts temperature, wind speed, and time, and displays them to the user. Its lightweight design makes it ideal for environments where adding dependencies is difficult. Overall, WeatherApp provides a straightforward, portable solution for accessing real-time weather data using core Java features.

# Tools and Technologies Used:

Only the standard libraries included in the Java Development Kit (JDK) are used in the WeatherApp software, which is entirely developed in Java.  This indicates that no third-party libraries or dependencies—such JSON parsing libraries like Jackson or Gson—are needed.  With this method, the software can execute on any system that has a Java Runtime Environment (JRE), guaranteeing portability and simplicity.

Used resources like GOOGLE, QUICKREF, YOUTUBE AND CHATGPT for quick reference, they helped me complete tasks efficiently.

## The program uses several core Java packages:

java.net.HttpURLConnection and java.net.URL: With the help of these classes, the program can send a GET request to an external weather API (Open-Meteo) and manage the HTTP network connection.  Basic client-side HTTP communication is demonstrated here.

java.io.BufferedReader and java.io.InputStreamReader: These classes read the response from the API over the network stream efficiently.

java.util.Scanner: This class reads user input from the console, enabling interactive input of latitude and longitude.

String manipulation methods to parse the JSON response manually without using any JSON library.

This minimalist approach showcases a low-dependency solution ideal for environments where external libraries may not be permitted or available.

# Editor and Compiler Platforms:

During the development and testing process, I used multiple environments to ensure the program’s portability and correctness:

IntelliJ IDEA: A widely used, feature-rich Integrated Development Environment (IDE) for Java development. IntelliJ offers code completion, debugging, and project management, making it an excellent choice for writing and testing this program.

Eclipse IDE: Another popular Java IDE that provides similar features and can run this program easily.

Visual Studio Code (VS Code): With Java extensions, VS Code supports Java development and debugging in a lightweight editor.

Command Line / Terminal: The program can be compiled and run entirely via command line tools using javac and java commands, making it platform-independent and suitable for server environments or lightweight machines.

Because the program depends only on the standard Java library, it is highly portable and does not require special setup beyond installing the Java runtime.

# Some of the applications:

The WeatherApp program is a simple demonstration of:

Making HTTP requests in Java without external libraries.

Manual parsing of JSON data — a useful exercise for understanding data formats and programming fundamentals.

Interactive console-based user input.

Beyond education, this program can be used as a lightweight weather query tool on systems where installing additional libraries is not feasible.

Potential real-world applications include:

Embedded Systems: Devices with limited resources and restricted software installations can use similar minimal Java programs to fetch live data.

Learning and Teaching: This program is a great teaching example to explain networking, JSON structure, and string parsing in Java.

Prototyping: Quickly test API responses or integrate basic API calls without investing time in setting up complex dependencies.

Automation Scripts: Integrated into larger Java-based automation workflows where weather data influences processes (e.g., scheduling irrigation systems, outdoor event planning tools).

With minor extensions — such as error handling improvements, geolocation services, or GUI development — this program can evolve into a more user-friendly application.

# How the Program Works:

User Input:
Latitude and longitude are the first two values the program asks the user to enter. These values correspond to the geographic location for which the weather data is being requested.  These inputs are read from the command line by the Scanner class.

Constructing the API URL:
The program creates a URL to query the Open-Meteo weather API using the input coordinates.  The parameters to request the current weather at the given location are included in this URL.

Sending the HTTP GET Request:
After creating a HttpURLConnection object that points to the API endpoint, the program sends a GET request.  The HTTP response code is then examined to verify that the request was successful (HTTP 200 OK).

Reading the API Response:
The application reads the incoming JSON response line by line and concatenates it into a single string using BufferedReader and InputStreamReader.

Parsing the JSON Manually:
The application manually extracts the weather information from the JSON string because no JSON parsing libraries are used.

It locates the "current_weather" object by searching for its key in the JSON string.

It isolates the substring representing the object by matching braces.

It then extracts values for "temperature", "windspeed", and "time" by searching for their respective keys and reading the associated values.

This method requires careful string index manipulation and assumes the JSON structure does not change drastically.

Displaying the Weather Information:
The extracted values are printed to the console in a readable format, showing temperature in Celsius, wind speed in km/h, and the timestamp in ISO 8601 format.

Error Handling:
Basic error handling is implemented to catch exceptions such as network errors or invalid input and display meaningful messages to the user.

# Output:

Enter latitude (e.g., 35): 50

Enter longitude (e.g., 139): 150

Full API Response: {"latitude":50.0,"longitude":150.0,"generationtime_ms":0.29277801513671875,"utc_offset_seconds":0,"timezone":"GMT","timezone_abbreviation":"GMT","elevation":0.0,"current_weather_units":{"time":"iso8601","interval":"seconds","temperature":"°C","windspeed":"km/h","winddirection":"°","is_day":"","weathercode":"wmo code"},"current_weather":{"time":"2025-10-04T08:30","interval":900,"temperature":11.0,"windspeed":43.5,"winddirection":201,"is_day":0,"weathercode":3}}

Weather Report:

Temperature: 11.0 °C

Wind Speed: 43.5 km/h

Time: 2025-10-04T08:30


![Image](https://github.com/user-attachments/assets/ae8f7ea9-c43a-4d00-acad-f3b5a1dcd136)
