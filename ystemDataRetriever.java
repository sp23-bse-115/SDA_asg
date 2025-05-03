class SystemDataRetriever {
    public static SystemData retrieveData(ReportType type, LocalDate startDate, LocalDate endDate) {
        // Simulate database/data source access
        Map<String, Object> data = new HashMap<>();
        
        // Add sample data based on report type
        switch (type) {
            case AUDIT:
                data.put("user_actions", Arrays.asList("Login", "Logout", "Data Access"));
                data.put("security_events", Arrays.asList("Failed login attempt", "Password change"));
                break;
            case PERFORMANCE:
                data.put("response_times", Arrays.asList(120, 150, 110, 130));
                data.put("uptime_percentage", 99.8);
                break;
            case SYSTEM_USAGE:
                data.put("active_users", 42);
                data.put("features_used", Arrays.asList("Dashboard", "Reports", "Settings"));
                break;
        }
        
        data.put("start_date", startDate);
        data.put("end_date", endDate);
        
        return new SystemData(data);
    }
}
