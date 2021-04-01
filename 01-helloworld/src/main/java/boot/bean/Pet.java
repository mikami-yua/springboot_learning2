package boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor//有参构造器
@NoArgsConstructor//无参构造器
@Data//setter和getter
@ToString//tostring方法
public class Pet {
    private String name;

}
