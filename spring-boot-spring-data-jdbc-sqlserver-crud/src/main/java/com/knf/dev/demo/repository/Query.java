package com.knf.dev.demo.repository;

public class Query {

    public static final String FIND_ONE = 
            "select id, first_name, last_name,"
                + " email from users where id = ?";
    
    public static final String FIND_ALL =
            "select id, first_name,last_name,"
              + " email from users";

    public static final String SAVE =
            "insert into users(first_name, "
                    + "last_name, email) "
                    + "values (?, ?, ?)";

    public static final String UPDATE =
           "update users set " 
              + "first_name = ?, last_name = ?," 
                   + " email = ? " + "where id = ?";

    public static final String DELETE =
          "delete from users where id = ?";
}