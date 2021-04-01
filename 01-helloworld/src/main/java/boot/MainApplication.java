package boot;

import boot.bean.Pet;
import boot.bean.User;
import boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*主程序类
这是一个springboot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器中的组件
        String[] names=run.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }

        //3.从容器中获取组件,注册的组件默认是单实例的
        Pet tom1=run.getBean("tomcat",Pet.class);
        System.out.println(tom1);
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        ///如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。Full全配置
        //保持组件单实例。@Configuration(proxyBeanMethods = false) lite轻量级配置
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);
        System.out.println(user);
        System.out.println(user1);

    }
}
