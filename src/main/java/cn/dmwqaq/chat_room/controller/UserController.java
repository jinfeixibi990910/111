package cn.dmwqaq.chat_room.controller;

import cn.dmwqaq.chat_room.pojo.User;
import cn.dmwqaq.chat_room.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    //    private final UserService userService;

    //    public UserController(UserService userService) {
    //        this.userService = userService;
    //    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        String userId = request.getParameter("id");
        String password = request.getParameter("password");
        User user = null;

        try {
            user = userService.getById(userId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        try {
            if (user == null || !password.equals(user.getPassword())) {
                response.getWriter().write("false");
            } else {
                response.getWriter().write("true");
                request.getSession().setAttribute("userId", userId);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getSession().removeAttribute("userId");
            response.setContentType("text/html");
            response.getWriter().write("true");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.getWriter().write("false");
        }
    }
}
