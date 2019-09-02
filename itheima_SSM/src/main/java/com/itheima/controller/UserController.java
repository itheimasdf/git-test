package com.itheima.controller;

import com.itheima.model.Result;
import com.itheima.model.User;
import com.itheima.service.ResultService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResultService resultService;

    /**
     * 抽奖
     * @param prize
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/lucky")
    public Object Lucky(String prize, HttpSession session) {

        //获取当前用户
        User user = (User) session.getAttribute("user");
        //判断抽奖次数
        List<Result> resultList = resultService.findByUserId(user.getId());
        //15次
        if(resultList.size()>14){
            System.out.println("抽奖次数已用完");
            return "fail";
        }
        //保存抽奖记录
        Result result = new Result();
        result.setPrize(prize);
        result.setUserId(user.getId());
        resultService.save(result);
        System.out.println("hello");
        return "success";
    }

    /**
     * 用户个人中心-页面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView, HttpSession session) {

        User user = (User) session.getAttribute("user");
        //直接从数据库拿出抽奖结果
        List<Result> resultList = resultService.findByUserId(user.getId());
        modelAndView.addObject("resultList", resultList);
        modelAndView.setViewName("user_index");
        return modelAndView;
//        return "user_index";
    }

    /**
     * 访问地址：url = /user/login
     * 登录页面 - GET
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 访问地址：url = /user/login
     * 登录 - POST
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession session) {
        //去数据库比对 检查用户名和密码
        User loginUser = userService.login(user);
        if (loginUser == null) {
            return "error";
        }
        //登录信息放入session
        session.setAttribute("user", loginUser);
        //跳转
        return "redirect:/user/index";
    }

}
