package test;

public class NewFile {
    private String id;
    private Integer ma;
    private String ten;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public NewFile(String id, Integer ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public NewFile() {
        
    }
}
