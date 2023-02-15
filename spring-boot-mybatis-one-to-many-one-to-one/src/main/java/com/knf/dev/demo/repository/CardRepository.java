package com.knf.dev.demo.repository;

import com.knf.dev.demo.model.Card;
import com.knf.dev.demo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CardRepository {
 
    /*
     *  one to one Select.
     */
    @Select("SELECT cards.id, cards.email, " +
            "cards.cardnumber, cards.cardtype" +
            " FROM cards WHERE cards.id = #{id}")
    @Results(value = {
        @Result(property = "email", column = "email"),
        @Result(property = "cardNumber", column = "cardnumber"),
        @Result(property = "cardType", column = "cardtype"),
        @Result(property = "user", column = "email",
                one=@One(select = "getUser"))
    })
    Card selectCardById(Integer id);
 
    @Select("SELECT users.name, users.email FROM " +
            "users WHERE users.email = #{email}")
    User getUser(String email);
}