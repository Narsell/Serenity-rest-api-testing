package co.com.apitesting.model;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private int age;
    private String profileImage;

    public Employee(Integer id, String employee_name, Integer employee_salary, Integer employee_age, String profile_image) {
        this.id = id;
        this.name = employee_name;
        this.salary = employee_salary;
        this.age = employee_age;
        this.profileImage = profile_image;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
