package com.knf.dev.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knf.dev.models.ERole;
import com.knf.dev.models.Role;
import com.knf.dev.models.Employee;
import com.knf.dev.repository.RoleRepository;
import com.knf.dev.repository.EmployeeRepository;
import com.knf.dev.request.LoginRequest;
import com.knf.dev.request.SignupRequest;
import com.knf.dev.response.JwtResponse;
import com.knf.dev.response.MessageResponse;
import com.knf.dev.security.jwt.JwtUtils;
import com.knf.dev.security.services.EmployeeDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateEmployee(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmployeename(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		EmployeeDetailsImpl employeeDetails = (EmployeeDetailsImpl) authentication.getPrincipal();
		List<String> roles = employeeDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, employeeDetails.getId(), employeeDetails.getUsername(),
				employeeDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

		if (employeeRepository.existsByEmployeename(signUpRequest.getEmployeename())) {

			return ResponseEntity.badRequest().body(new MessageResponse("Error: Employeename is already taken!"));
		}

		if (employeeRepository.existsByEmail(signUpRequest.getEmail())) {

			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new employee account
		Employee employee = new Employee(signUpRequest.getEmployeename(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role employeeRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(employeeRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					Role defaultRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(defaultRole);
				}
			});
		}

		employee.setRoles(roles);
		employeeRepository.save(employee);

		return ResponseEntity.ok(new MessageResponse("Employee registered successfully!"));
	}
}
