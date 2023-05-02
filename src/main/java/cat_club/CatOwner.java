package catOwner;

import cat.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatOwner {
    private long id;
    private String name;
    private String address;
    private String code;
    private List<Cat> cats = new ArrayList<>();

    public CatOwner(){}

    public CatOwner(String name, String address, String code, List<Cat> cats) {
        this.name = name;
        this.address = address;
        this.code = code;
        this.cats = cats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    @Override
    public String toString() {
        return "CatOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", cats=" + cats.size() + // for not printing infinite cats of owners, it prints size of cats list
                '}';
    }
}
