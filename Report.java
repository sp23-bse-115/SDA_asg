abstract class Report {
    protected SystemData systemData;
    protected String title;
    
    public Report(SystemData systemData) {
        this.systemData = systemData;
    }
    
    public abstract void generateContent();
    
    public void downloadAsPDF() {
        // Simulate PDF generation
        System.out.println("Generating PDF for " + title + "...");
