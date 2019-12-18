package dao;

public interface ObjectDao {
    public boolean SignUp(Object obj);
    public boolean SignIn(String email, String password);
    public boolean EditUser(Object obj, String username);
}
