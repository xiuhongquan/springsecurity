package jit.wxs.web;

import jit.wxs.entity.SysUser;
import jit.wxs.service.SysUserService;
import jit.wxs.support.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jitwxs
 * @date 2018/3/30 1:30
 */
@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆用户：" + name);
        return "home.html";
    }

  /*  @RequestMapping("/login")
    public String showLogin() {
        return "login.html";
    }*/

    @RequestMapping("/index")
    public String showIndex() {
        return "index.html";
    }
    @RequestMapping("/success")
    public String showsuccess() {
        return "success.html";
    }




    @RequestMapping(value = "/regsiter" , method = RequestMethod.POST)
    public String regsiter(String username,String password){
        sysUserService.addUser(username,password);

        return "login.html";
    }

}
