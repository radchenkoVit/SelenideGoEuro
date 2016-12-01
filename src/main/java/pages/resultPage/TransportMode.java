package pages.resultPage;

public enum TransportMode {
    Train(1), Flight(2), Bus(3);
    private static String modeLocatorPattern = "(//a[@data-test='ResutlTab'])[%d]";

    private int index;

    TransportMode(int index){
        this.index = index;
    }

    public String getLocator(){
        return String.format(modeLocatorPattern, index);
    }
}
