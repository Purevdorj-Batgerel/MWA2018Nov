package domain;

public interface iPerson {
    boolean login(String username, String password);

    void logout();
}
