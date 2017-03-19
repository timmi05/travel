package by.intexsoft.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.course.model.Authority;
import by.intexsoft.course.repository.AuthorityRepository;
import by.intexsoft.course.service.AuthorityService;

/**
 * It used to implement the techniques {@link AuthorityService}
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository roleRepository;

	@Override
	public List<Authority> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Authority findByAuthority(String authority) {
		return roleRepository.findByAuthority(authority);
	}
}
