package codegym.c0623k1.md3_casestudy_walletonline.model;


public class Category {
    private int categoryID;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int idCategory, String name) {
        this.categoryID = idCategory;
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int idCategory) {
        this.categoryID = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

