package com.nx.controller;

import com.nx.bean.MSecUsrDef;
import com.nx.service.IUserService;
import com.nx.util.Constans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginAction {
    private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @Resource
    private IUserService iUserService;

    @RequestMapping("")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/in")
    public String login(HttpServletRequest request, Model model) {
        logger.debug("执行登录验证");
        if (doLogin(request, model)) {
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(Constans.SESSION_TIME_OUT);
            session.setAttribute(Constans.USER, request.getParameter("userId"));
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    /**
     * 登录验证
     *
     * @param request
     * @param model
     * @return
     */
    private boolean doLogin(HttpServletRequest request, Model model) {
        String userId = request.getParameter("userId");

        if (userId == null || userId.trim() == "") {
            model.addAttribute("用户名为空");
            return false;
        }

        MSecUsrDef user = new MSecUsrDef();
        user.setId(Integer.parseInt(userId));

        MSecUsrDef userAuth = iUserService.getUserInfo(user);

        if (userAuth == null) {
            model.addAttribute("用户名不存在");
            return false;
        }

        return true;
    }
}
