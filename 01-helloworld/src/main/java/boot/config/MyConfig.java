package boot.config;

import boot.bean.Pet;
import boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *proxyBeanMethods = true 代理bean的方法默认是单实例的
 *  false 会产生新的实例
 */
@Configuration(proxyBeanMethods = false)//创建一个类，告诉springboot这是一个配置类.配置类本身也是组件
@ImportResource("classpath:beans.xml")//使用的第三方程序，还使用老的xml格式的方式。在项目中兼容老的code使用这个代码
public class MyConfig {

    /**
     * 外部无论对配置类中的方法调用多少次，获取的都是之前注册到容器的单实例。
     * @return
     */
    @Bean //bean注解给容器中添加组件.以方法名作为组件id，返回类型就是组件类型。返回对象就是在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        zhangsan.setPet(tomcat());
        return zhangsan;
    }

    @Bean
    public Pet tomcat(){
        return new Pet("tomcat");
    }
}
