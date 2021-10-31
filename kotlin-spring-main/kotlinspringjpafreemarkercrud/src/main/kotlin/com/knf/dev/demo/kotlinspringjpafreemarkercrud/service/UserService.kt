package com.knf.dev.demo.kotlinspringjpafreemarkercrud.service

import com.knf.dev.demo.kotlinspringjpafreemarkercrud.model.User
import org.springframework.beans.factory.annotation.Autowired
import com.knf.dev.demo.kotlinspringjpafreemarkercrud.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.ArrayList
import kotlin.Throws
import javax.persistence.EntityNotFoundException

@Service
class UserService {
    @Autowired
    var repository: UserRepository? = null
    val allusers: List<User?>
        get() {
            val result = repository!!.findAll() as List<User?>
            return if (result.size > 0) {
                result
            } else {
                ArrayList()
            }
        }

    @Throws(EntityNotFoundException::class)
    fun getUserById(id: Long): User {
        val user = repository!!.findById(id)
        return if (user.isPresent) {
            user.get()
        } else {
            throw EntityNotFoundException("No user record exist for given id")
        }
    }

    fun createOrUpdateUser(entity: User): User {
        var entity = entity
        return if (entity.id == null) {
            entity = repository!!.save(entity)
            entity
        } else {
            val user = repository!!.findById(
                entity.id!!
            )
            if (user.isPresent) {
                var newEntity = user.get()
                newEntity.email = entity.email
                newEntity.firstName = entity.firstName
                newEntity.lastName = entity.lastName
                newEntity = repository!!.save(newEntity)
                newEntity
            } else {
                entity = repository!!.save(entity)
                entity
            }
        }
    }

    @Throws(EntityNotFoundException::class)
    fun deleteUserById(id: Long) {
        val user = repository!!.findById(id)
        if (user.isPresent) {
            repository!!.deleteById(id)
        } else {
            throw EntityNotFoundException("No user record exist for given id")
        }
    }
}