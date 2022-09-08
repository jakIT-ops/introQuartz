package com.example.introQuartz;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.Banner.Mode;

@ComponentScan
@EnableScheduling
public class IntroQuartzApplication {
	public static void main(String[] args) {
        new SpringApplicationBuilder(IntroQuartzApplication.class).bannerMode(Mode.OFF).run(args);
	}

}
