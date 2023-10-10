package codegym.c0623k1.md3_casestudy_walletonline.model;

public class Category extends AbstractModel {

    public Category() {
    }

    public Category(String name) {
        super(name);
    }

    public Category(int id, String name) {
        super(id, name);
    }

    public Category(int id, String name, int status) {
        super(id, name, status);
    }
}

