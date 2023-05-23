package main.entity;

public class Child {

    private String parentSocialNo;
    private String name;
    private int age;

    public Child(String name, int age, String parentSocialNo) {
        this.name = name;
        this.age = age;
        this.parentSocialNo = parentSocialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getParentSocialNo() {
        return parentSocialNo;
    }

    public void setParentSocialNo(String parentSocialNo) {
        this.parentSocialNo = parentSocialNo;
    }
}
