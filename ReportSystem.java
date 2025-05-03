public class ReportSystem {
    public static void main(String[] args) {
        Admin admin = new Admin("admin1", "Admin User", "admin@system.com");
        ReportGenerator reportGenerator = new ReportGenerator();
        
        // Simulate report generation
        admin.generateReport(reportGenerator);
    }
}
