package controller;

import dao.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ProfileController extends AbstractController {
    
    
    public ProfileController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        User user = new User();
        user.setUname(request.getParameter("username"));
        user.setUpass(request.getParameter("password"));
        
        UserDao.insert(user);
        
        return new ModelAndView("profile","user_profile",user);
    
    }
}
