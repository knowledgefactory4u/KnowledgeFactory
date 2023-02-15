package com.knf.dev.demo.repository;

import com.knf.dev.demo.model.Card;
import com.knf.dev.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {
 
    /*
     *  one to many Select.
     */
    @Select("SELECT users.name, users.email " +
            "FROM users WHERE users.email = #{email}")
    @Results(value = {
         @Result(property = "email", column = "email"),
         @Result(property="cards", javaType=List.class, column="email",
         many=@Many(select="getCards"))
                      })
    User selectUserById(String email);
 
    @Select("SELECT cards.id, cards.cardnumber, cards.cardtype, " +
            "cards.email FROM cards WHERE cards.email = #{email}")
    @Results(value = {
            @Result(property = "cardNumber", column = "cardnumber"),
            @Result(property = "cardType", column = "cardtype")
    })
    List<Card> getCards(String email);
}