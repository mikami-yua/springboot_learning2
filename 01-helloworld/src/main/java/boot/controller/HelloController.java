package boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody//这个类中的方法的返回值都是写给浏览器的，不是返回页面（写在方法上面就是这个方法是写给浏览器的）
@Controller*/
@RestController//上面两个的总和
public class HelloController {


    @RequestMapping("/hello")
    public String handle01(){
        return "hello springboot 2"+"你好";
    }
}
