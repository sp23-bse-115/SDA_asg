class Admin {
    private String userId;
    private String name;
    private String email;
    
    public Admin(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
    
    public void generateReport(ReportGenerator reportGenerator) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Report Generation ===");
        System.out.println("Available report types:");
        System.out.println("1. Audit Report");
        System.out.println("2. Performance Report");
        System.out.println("3. System Usage Report");
        System.out.print("Select report type (1-3): ");
        
        int reportType = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();
        
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        
        try {
            Report report = reportGenerator.generateReport(
                ReportType.values()[reportType - 1], 
                startDate, 
                endDate
            );
            
            System.out.println("\nReport generated successfully!");
            System.out.println("Report details:");
            System.out.println(report);
            
            // Option to download as PDF
            System.out.print("\nDownload as PDF? (Y/N): ");
            String downloadChoice = scanner.nextLine();
            
            if (downloadChoice.equalsIgnoreCase("Y")) {
                report.downloadAsPDF();
                System.out.println("Report downloaded as PDF.");
            }
        } catch (ReportGenerationException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}
