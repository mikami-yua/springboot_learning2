package boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data//lombok帮助生成属性的getter和setter方法
@Component//加载到容器中
@ConfigurationProperties(prefix = "mycar")//指定哪个前缀之后的key和当前类的属性一一对应
public class Car {
    private String brand;
    private Integer price;

}
