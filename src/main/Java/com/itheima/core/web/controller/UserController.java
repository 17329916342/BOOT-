package com.itheima.core.web.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itheima.core.po.User;
import com.itheima.core.service.UserService;
/**
 * �û���������
 */
@Controller
public class UserController {
    // ����ע��
    @Autowired
    private UserService userService;
    /**
     * �û���¼
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String usercode,String password, Model model,
                        HttpSession session) {
        // ͨ���˺ź������ѯ�û�
        User user = userService.findUser(usercode, password);
        if(user != null){
            // ���û�������ӵ�Session
            session.setAttribute("USER_SESSION", user);
            // ��ת����ҳ��
//			return "customer";
            return "redirect:customer/list.action";
        }
        model.addAttribute("msg", "�˺Ż�����������������룡");
        // ���ص���¼ҳ��
        return "login";
    }
}