package kz.zhenismadiyar.cinema.profile;

public class User {

    private Long id;
    private String name;
    private String ava;

    public User() {}

    public User(String name, String ava) {
        this.name = name;
        this.ava = ava;
    }

    public User(Long id, String name, String ava) {
        this.id = id;
        this.name = name;
        this.ava = ava;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }
}
