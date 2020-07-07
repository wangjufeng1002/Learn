package learn.javassist;

/**
 * @author wangjufeng1
 * @description:
 * @date 2018/8/23
 */
public class Student {
    private String name;
    private Integer age;
    private String gender;

    public void execute() {
        System.out.println("my name is wangjufeng");
    }

    public Student(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
