package com.bao.baoltd;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bao.baoltd.service.UserManager;

@Component
public class BaoLtdAppStartupRunner implements CommandLineRunner{
	
	@Autowired
	private UserManager userManager;
	
	@Override
	public void run(String... args) throws Exception {
		userManager.createUser("admin", "admin", "admin@admin.com", Arrays.asList("ROLE_USER", "ROLE_ADMIN"));	
	}

}
