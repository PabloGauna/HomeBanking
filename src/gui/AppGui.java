package gui;

public class AppGui {
    private static ScreenManager screenManager;

    public AppGui() {
        this.startManager();
        this.showFrame();
    }

    public void startManager() {
        screenManager = new ScreenManager();
        screenManager.createMainScreen();
        screenManager.showAccountsListScreenPanel();
    }

    public void showFrame() {
        screenManager.showFrame();
    }
}
