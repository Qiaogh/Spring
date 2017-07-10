package com.qiaogh.domain;



public class Son {

    private String id;
    private String name;
    private Integer age;
    private Man father;
    private Women mother;
    private String fatherName;
    private String motherName;
    public String getId() {
        return id;
    }
    public void setId( String id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Man getFather() {
        return father;
    }
    public void setFather( Man father ) {
        this.father = father;
    }
    public Women getMother() {
        return mother;
    }
    public void setMother( Women mother ) {
        this.mother = mother;
    }
    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName( String fatherName ) {
        this.fatherName = fatherName;
    }
    public String getMotherName() {
        return motherName;
    }
    public void setMotherName( String motherName ) {
        this.motherName = motherName;
    }
    @Override
    public String toString() {
        return "Son [id=" + id + ", name=" + name + ", age=" + age + ", fatherName=" + fatherName + ", motherName=" + motherName + "]";
    }
}
