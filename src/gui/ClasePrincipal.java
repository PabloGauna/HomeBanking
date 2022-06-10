package gui;

public class ClasePrincipal {
    private static ScreenManager screenManager;

    public static void main(String[] args) {
        ClasePrincipal ppal = new ClasePrincipal();
        ppal.startManager();
        ppal.showFrame();
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
