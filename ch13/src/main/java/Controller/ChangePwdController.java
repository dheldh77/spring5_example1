package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.Authinfo;
import spring.ChangePasswordService;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

    private ChangePasswordService changePasswordService;

    public void setChangePasswordService(ChangePasswordService changePasswordService){
        this.changePasswordService = changePasswordService;
    }

    @GetMapping
    public String form(@ModelAttribute("command") ChangePwdCommand pwdCommand, HttpSession session){
        Authinfo authInfo = (Authinfo) session.getAttribute("authInfo");

        if(authInfo == null) return "redirect:/login";
        return "edit/changePwdForm";
    }

    @PostMapping
    public String submit(@ModelAttribute("command") ChangePwdCommand pwdCmd, Errors errors, HttpSession session){
        new ChangePwdCommandValidator().validate(pwdCmd, errors);

        if(errors.hasErrors()) return "edit/changePwdForm";

        Authinfo authinfo = (Authinfo) session.getAttribute("authInfo");

        try{
            changePasswordService.changePassword(authinfo.getEmail(), pwdCmd.getCurrentPassword(), pwdCmd.getNewPassword());
            return "edit/changePwd";
        } catch (WrongIdPasswordException ex){
            errors.rejectValue("currentPassword", "notMatching");
            return "edit/changePwdForm";
        }
    }

}
