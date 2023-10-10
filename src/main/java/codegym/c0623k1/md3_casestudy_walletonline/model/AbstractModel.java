package codegym.c0623k1.md3_casestudy_walletonline.model;

public abstract class AbstractModel {
    private int id;
    private String name;
    private int status;

    public AbstractModel() {
    }

    public AbstractModel(int id) {
        this.id = id;
    }

    public AbstractModel(String name) {
        this.name = name;
    }

    public AbstractModel(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public AbstractModel(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public AbstractModel(int id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
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
}
