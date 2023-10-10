package codegym.c0623k1.md3_casestudy_walletonline.model;

public class User extends AbstractModel {
    private String userName;
    private String password;
    private String address;
    private float totalMoney;

    public User() {
    }

    public User(int id, String name, String userName, String password, String address, float totalMoney) {
        super(id, name);
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.totalMoney = totalMoney;
    }

    public User(String name, String userName, String password, String address) {
        super(name);
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public User(int id, String name, String userName, String password, String address) {
        super(id, name);
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
}
