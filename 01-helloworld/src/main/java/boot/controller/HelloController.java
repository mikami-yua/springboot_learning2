package boot.controller;

import boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody//这个类中的方法的返回值都是写给浏览器的，不是返回页面（写在方法上面就是这个方法是写给浏览器的）
@Controller*/
@Slf4j//使用日志
@RestController//上面两个的总和
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello2")
    public String handle01(){
        log.info("请求进来了。。。");
        return "hello springboot 2"+"你好";
    }
}
