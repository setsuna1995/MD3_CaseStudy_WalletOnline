package codegym.c0623k1.md3_casestudy_walletonline.model;

public class CategoryDetail {
    private int id;
    private String name;
    private int status;
    private int categoryID;
    private int role;

    public CategoryDetail() {
    }

    public CategoryDetail(int id, String name, int status, int categoryID, int role) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.categoryID = categoryID;
        this.role = role;
    }

    public CategoryDetail(String name, int status, int categoryID, int role) {
        this.name = name;
        this.status = status;
        this.categoryID = categoryID;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}