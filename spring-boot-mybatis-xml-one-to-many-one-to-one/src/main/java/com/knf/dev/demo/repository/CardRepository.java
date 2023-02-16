package com.knf.dev.demo.repository;

import com.knf.dev.demo.model.Card;

public interface CardRepository {
    Card selectCardById(Integer id);

}