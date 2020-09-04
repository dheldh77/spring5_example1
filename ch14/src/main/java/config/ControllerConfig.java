package config;

import Controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Controller.RegisterController;
import spring.MemberRegisterService;
import survey.SurveyController;

import spring.AuthService;
import Controller.LogoutController;

import Controller.ChangePwdController;
import spring.ChangePasswordService;

import Controller.MemberListController;
import spring.MemberDao;

import Controller.MemberDetailController;

@Configuration
public class ControllerConfig {

    @Autowired
    public MemberRegisterService memberRegSvc;

    @Autowired
    public AuthService authService;

    @Autowired
    private ChangePasswordService changePasswordService;

    @Autowired
    private MemberDao memberDao;

    @Bean
    public MemberListController memberListController(){
        MemberListController controller = new MemberListController();
        controller.setMemberDao(memberDao);
        return controller;
    }

    @Bean
    public RegisterController registerController(){
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegSvc);
        return controller;
    }

    @Bean
    public SurveyController surveyController(){
        return new SurveyController();
    }

    @Bean
    public LoginController loginController(){
        LoginController controller = new LoginController();
        controller.setAuthService(authService);
        return controller;
    }

    @Bean
    public LogoutController logoutController(){
        return new LogoutController();
    }

    @Bean
    public ChangePwdController changePwdController(){
        ChangePwdController controller = new ChangePwdController();
        controller.setChangePasswordService(changePasswordService);
        return controller;
    }

    @Bean
    public MemberDetailController memberDetailController(){
        MemberDetailController controller = new MemberDetailController();
        controller.setMemberDao(memberDao);
        return controller;
    }
}
