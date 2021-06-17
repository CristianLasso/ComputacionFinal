package com.taller1.CristianLasso.back.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taller1.CristianLasso.back.model.Userr;
import com.taller1.CristianLasso.back.repository.UserrRepository;

@Service
public class MyCustomUserDetailsService implements UserDetailsService {

	private UserrRepository usRepo;

	@Autowired
	public MyCustomUserDetailsService(UserrRepository usRepo) {
		this.usRepo = usRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Userr> us = usRepo.findByUserName(username);

		if (us != null) {
			User.UserBuilder builder = User.withUsername(username).password(us.get().getUserPassword())
					.roles(us.get().getType().toString());
			return builder.build();
		} else {
			throw new UsernameNotFoundException("Userr not found.");
		}
	}
}