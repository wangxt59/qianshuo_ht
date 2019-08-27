package com.qianshuo.controller;

import com.qianshuo.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

//    @RequestMapping(value = "/")
//    public String login() {
//        return "pages/login";
//    }

    /**
     * @return
     * @Title: userLogin
     * @Description: 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(String username, String password) {
        // 是否认证通过
        Map<String, Object> returnMap = new HashMap<>();
        // 以下部分在配置阶段就已经完成,可以直接使用
        // 读取配置文件
        // Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 获取SecurityManager的实例
        // SecurityManager securityManager = factory.getInstance();
        // 把 securityManager 的实例绑定到 SecurityUtils 上
        // SecurityUtils.setSecurityManager(securityManager);

        System.out.println(username + ":" + password);
        Subject subject = SecurityUtils.getSubject();
        // 自己创建一个令牌，输入用户名和密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

        try {
            subject.login(usernamePasswordToken);
            System.out.println("身份认证成功");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("账号不存在！");
            returnMap.put("data","账号不存在！");
        } catch (LockedAccountException e) {
            e.printStackTrace();
            System.out.println("账号被锁定！");
            returnMap.put("data","账号被锁定！");
        } catch (DisabledAccountException e) {
            e.printStackTrace();
            System.out.println("账号被禁用！");
            returnMap.put("data","账号被禁用！");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("凭证/密码错误！");
            returnMap.put("data","凭证/密码错误！");
        } catch (ExpiredCredentialsException e) {
            e.printStackTrace();
            System.out.println("凭证/密码过期！");
            returnMap.put("data","凭证/密码过期！");
        } catch (ExcessiveAttemptsException e) {
            e.printStackTrace();
            returnMap.put("data","登录失败次数过多！");
            System.out.println("登录失败次数过多！");

        }
        // 是否认证通过
        boolean isAuthenticated1 = subject.isAuthenticated();
        System.out.println("登录后,是否认证通过：" + isAuthenticated1);

        // 退出
        subject.logout();

        // 是否认证通过
        boolean isAuthenticated2 = subject.isAuthenticated();
        System.out.println("退出登录后,是否认证通过：" + isAuthenticated2);

//        return "处理登录";
        if (isAuthenticated1){
            return new ModelAndView("common");
        }else {
            return new ModelAndView("pages/login",returnMap);
        }
    }




    @RequestMapping(value = "request.do", method = RequestMethod.POST)
    public ModelAndView request(@RequestBody Map map){
        Map returnMap = new HashMap();

        returnMap.put("data", null);
        returnMap.put("map", "map");
        System.out.println(map.toString());
        String url = map.get("url").toString();
        System.out.println(url);
        url = url.replace(".html","");
        return new ModelAndView(url, returnMap);
    }
}
