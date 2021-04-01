package boot.bean;

import lombok.*;

@Data
//@AllArgsConstructor定制参数构造器可以自己写
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;

    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
