package com.knf.dev.demo.kotlinspringsecurityjwt

import com.knf.dev.demo.kotlinspringsecurityjwt.model.ERole
import com.knf.dev.demo.kotlinspringsecurityjwt.model.Role
import com.knf.dev.demo.kotlinspringsecurityjwt.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class KotlinSpringsecurityJwtApplication : CommandLineRunner {
	@Autowired
	var roleRepository: RoleRepository? = null

	//Add some rows into roles collection before
	// assigning any role to Employee.
	@Throws(Exception::class)
	override fun run(vararg args: String) {
		try {
			val role = Role()
			role.name=ERole.ROLE_EMPLOYEE
			roleRepository!!.save<Role>(role)
			val role2 = Role()
			role2.name=ERole.ROLE_ADMIN
			roleRepository!!.save<Role>(role2)
		} catch (e: Exception) {
		}
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(KotlinSpringsecurityJwtApplication::class.java, *args)
		}
	}
}