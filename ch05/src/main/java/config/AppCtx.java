package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import spring.*;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = {"spring"})
// 스캔 목록에서 제거
// ,excludeFilters = @Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))
// ,excludeFilters = @Filter(type = FilterType.ASPECTJ, pattern = "spring.*Dao"))
// ,excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = {NoProduct.class.ManualBean.class } ))
// ,excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class ))
public class AppCtx {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSvc(){
        ChangePasswordService pwdSvc = new ChangePasswordService();
        // Autowired 어노테이션을 이용해서 의존을 주입하지않아도 자동으로 주입됨
        //pwdSvc.setMemberDao(memberDao());
        return pwdSvc;
    }

//    @Bean
//    public MemberPrinter memberPrinter(){
//        return new MemberPrinter();
//    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1(){
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2(){
        return new MemberSummaryPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        //infoPrinter.setMemberDao(memberDao());
        //infoPrinter.setPrinter(memberPrinter());
        infoPrinter.setPrinter(memberPrinter2());
        return infoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
