package model;

public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private String email;

    // ✅ Constructor WITHOUT id (ADD ke liye – AUTO_INCREMENT)
    public Student(String name, int age, String course, String email) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    // ✅ Constructor WITH id (VIEW / UPDATE / SEARCH ke liye)
    public Student(int id, String name, int age, String course, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    // ===== Getters =====
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public String getEmail() { return email; }
}
