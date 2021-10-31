package com.knf.dev.demo.kotlinspringkeycloakdemo.service

import com.knf.dev.demo.kotlinspringkeycloakdemo.Vo.EmployeeVO
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder
import org.keycloak.OAuth2Constants
import org.keycloak.admin.client.CreatedResponseUtil
import org.keycloak.admin.client.KeycloakBuilder
import org.keycloak.authorization.client.AuthzClient
import org.keycloak.authorization.client.Configuration
import org.keycloak.representations.idm.CredentialRepresentation
import org.keycloak.representations.idm.UserRepresentation
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*


@Service
class KeycloakService {
    @Value("\${keycloak.auth-server-url}")
    private val authServerUrl: String? = null

    @Value("\${keycloak.realm}")
    private val realm: String? = null

    @Value("\${keycloak.resource}")
    private val clientId: String? = null
    private val role = "knowledgefactory-admin"
    private val adminName = "knowledgefactory"
    private val adminPassword = "password"
    private val realmAdmin = "master"
    private val adminClientId = "admin-cli"

    @Value("\${keycloak.credentials.secret}")
    private val clientSecret: String? = null
    fun createEmployee(employeeVo: EmployeeVO): EmployeeVO {
        val keycloak = KeycloakBuilder.builder().serverUrl(authServerUrl)
            .grantType(OAuth2Constants.PASSWORD).realm(realmAdmin).clientId(adminClientId)
            .username(adminName).password(adminPassword)
            .resteasyClient(ResteasyClientBuilder().connectionPoolSize(10).build()).build()
        keycloak.tokenManager().accessToken
        val employee = UserRepresentation()
        employee.isEnabled = true
        employee.username = employeeVo.email
        employee.firstName = employeeVo.firstname
        employee.lastName = employeeVo.lastname
        employee.email = employeeVo.email
        val realmResource = keycloak.realm(realm)
        val usersResource = realmResource.users()
        val response = usersResource.create(employee)
        employeeVo.statusCode =response.status
        employeeVo.status = response.statusInfo.toString()
        if (response.status == 201) {
            val userId = CreatedResponseUtil.getCreatedId(response)
            val passwordCred = CredentialRepresentation()
            passwordCred.isTemporary = false
            passwordCred.type = CredentialRepresentation.PASSWORD
            passwordCred.value = employeeVo.password
            val userResource = usersResource[userId]
            userResource.resetPassword(passwordCred)
            val realmRoleUser = realmResource.roles()[role].toRepresentation()
            userResource.roles().realmLevel().add(Arrays.asList(realmRoleUser))
        }
        return employeeVo
    }

    fun login(employeeVo: EmployeeVO): Any {
        val clientCredentials: MutableMap<String, Any?> = HashMap()
        clientCredentials["secret"] = clientSecret
        clientCredentials["grant_type"] = "password"
        val configuration = Configuration(
            authServerUrl, realm, clientId,
            clientCredentials, null
        )
        val authzClient = AuthzClient.create(configuration)
        val response = authzClient.obtainAccessToken(
            employeeVo.email,
            employeeVo.password
        )
        return ResponseEntity.ok(response)
    }
}
