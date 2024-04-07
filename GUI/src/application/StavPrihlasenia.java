package application;

public class StavPrihlasenia {
    private static StavPrihlasenia instance = null;
    
    private boolean login1 = false;
    private boolean login2 = false;
    private boolean login3 = false;
    
    private StavPrihlasenia() {}
    
    public static StavPrihlasenia getInstance() {
        if (instance == null) {
            instance = new StavPrihlasenia();
        }
        return instance;
    }
    
    public boolean isLogin1() {
        return login1;
    }
    
    public void setLogin1(boolean value) {
        login1 = value;
    }
    
    public boolean isLogin2() {
        return login2;
    }
    
    public void setLogin2(boolean value) {
        login2 = value;
    }
    
    public boolean isLogin3() {
        return login3;
    }
    
    public void setLogin3(boolean value) {
        login3 = value;
    }
}
