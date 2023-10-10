package codegym.c0623k1.md3_casestudy_walletonline.model;

public class CategoryDetail extends AbstractModel {
    private Category category;
    private int role;

    public CategoryDetail() {
    }

    public CategoryDetail(int id) {
        super(id);
    }

    public CategoryDetail(int id, String name, int status, Category category, int role) {
        super(id, name, status);
        this.category = category;
        this.role = role;
    }

    public CategoryDetail(String name, int status, Category category, int role) {
        super(name, status);
        this.category = category;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}