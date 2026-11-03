package com.ardak.tricoach;

import org.springframework.boot.SpringApplication;

public class TestTriCoachApplication {

	public static void main(String[] args) {
		SpringApplication.from(TriCoachApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
