package com.ll.gramgram.base.initData;

import com.ll.gramgram.boundedContext.instaMember.service.InstaMemberService;
import com.ll.gramgram.boundedContext.likeablePerson.service.LikeablePersonService;
import com.ll.gramgram.boundedContext.member.entity.Member;
import com.ll.gramgram.boundedContext.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "test"})
public class NotProd {
    @Bean
    CommandLineRunner initData(
            MemberService memberService,
            InstaMemberService instaMemberService,
            LikeablePersonService likeablePersonService
    ) {
        return args -> {
            Member memberAdmin = memberService.join("admin", "1234").getData();
            Member memberUser1 = memberService.join("user1", "1234").getData();
            Member memberUser2 = memberService.join("user2", "1234").getData();
            Member memberUser3 = memberService.join("user3", "1234").getData();
            Member memberUser4 = memberService.join("user4", "1234").getData();
            //임시로 새로운 멤버 생성
            Member memberUser5 = memberService.join("user5", "1234").getData();
            Member memberUser6 = memberService.join("user6", "1234").getData();
            Member memberUser7 = memberService.join("user7", "1234").getData();
            Member memberUser8 = memberService.join("user8", "1234").getData();
            Member memberUser9 = memberService.join("user9", "1234").getData();
            Member memberUser10 = memberService.join("user10", "1234").getData();
            Member memberUser11 = memberService.join("user11", "1234").getData();
            Member memberUser12 = memberService.join("user12", "1234").getData();


            Member memberUser5ByKakao = memberService.whenSocialLogin("KAKAO", "KAKAO__2731659195").getData();

            instaMemberService.connect(memberUser2, "insta_user2", "M");
            instaMemberService.connect(memberUser3, "insta_user3", "W");
            instaMemberService.connect(memberUser4, "insta_user4", "M");

//            임시로 새로운 인스타멤버 생성
            instaMemberService.connect(memberUser5, "insta_user5", "M");
            instaMemberService.connect(memberUser6, "insta_user6", "M");
            instaMemberService.connect(memberUser7, "insta_user7", "M");
            instaMemberService.connect(memberUser8, "insta_user8", "M");
            instaMemberService.connect(memberUser9, "insta_user9", "M");
            instaMemberService.connect(memberUser10, "insta_user10", "M");
            instaMemberService.connect(memberUser11, "insta_user11", "M");
            instaMemberService.connect(memberUser12, "insta_user12", "M");


            likeablePersonService.like(memberUser3, "insta_user4", 1);
            likeablePersonService.like(memberUser3, "insta_user100", 2);

//            임시로 새로운 호감표시 생성
            likeablePersonService.like(memberUser12, "insta_user1", 1);
            likeablePersonService.like(memberUser12, "insta_user2", 1);
            likeablePersonService.like(memberUser12, "insta_user3", 1);
            likeablePersonService.like(memberUser12, "insta_user4", 1);
            likeablePersonService.like(memberUser12, "insta_user5", 1);
            likeablePersonService.like(memberUser12, "insta_user6", 1);
            likeablePersonService.like(memberUser12, "insta_user7", 1);
            likeablePersonService.like(memberUser12, "insta_user8", 1);
            likeablePersonService.like(memberUser12, "insta_user9", 1);
            likeablePersonService.like(memberUser12, "insta_user10", 1);


        };
    }
}
