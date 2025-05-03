class ReportGenerator {
    public Report generateReport(ReportType type, LocalDate startDate, LocalDate endDate) 
        throws ReportGenerationException {
        
        // Validate date range
        if (startDate.isAfter(endDate)) {
            throw new ReportGenerationException("Start date cannot be after end date");
        }
        
        // Simulate data retrieval and report generation
        SystemData systemData = SystemDataRetriever.retrieveData(type, startDate, endDate);
        
        // Generate report based on type
        Report report;
        switch (type) {
            case AUDIT:
                report = new AuditReport(systemData);
                break;
            case PERFORMANCE:
                report = new PerformanceReport(systemData);
                break;
            case SYSTEM_USAGE:
                report = new SystemUsageReport(systemData);
                break;
            default:
                throw new ReportGenerationException("Invalid report type");
        }
        
        return report;
    }
}

// Enums
enum ReportType {
    AUDIT, PERFORMANCE, SYSTEM_USAGE
}
