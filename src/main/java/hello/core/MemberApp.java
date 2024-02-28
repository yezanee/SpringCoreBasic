package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); // 객체 생성
        memberService.join(member); // 회원 가입 완료

        Member findMember = memberService.findMember(1L); // id를 통해 멤버를 찾음
        System.out.println("new member = " + member.getName()); // 새로운 멤버
        System.out.println("find Member = " + findMember.getName()); // 찾은 멤버

    }
}
