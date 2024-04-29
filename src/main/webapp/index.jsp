<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.TimeZone" %>

<!DOCTYPE html>
<html>
<head>
    <title>Greeting Page</title>
</head>
<body>
    <% 
        // Get current time
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        // Determine the time of day and set the greeting message
        String greeting = "";
        if (hour >= 6 && hour < 12) {
            greeting = "Good Morning Sir!";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Good Afternoon Madam!";
        } else {
            greeting = "Good Evening Vampire!";
        }
    %>

    <h1><%= greeting %></h1>
    <p>
        <a href="servlet">Click here</a> to go to the Servlet.
    </p>  
</body>
</html>