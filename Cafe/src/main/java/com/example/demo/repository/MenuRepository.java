package com.example.demo.repository;

import com.example.demo.entity.Menu;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Log
@Repository
public class MenuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Menu> list(Menu menu) throws Exception {
        List<Menu> results = jdbcTemplate.query(
                "select drinkName, drinkMemo, drinkPrice, drinkType from menuInfo",
                new RowMapper<Menu>() {
                    @Override
                    public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Menu menu = new Menu();
                        menu.setDrinkName(rs.getString("drinkName"));
                        menu.setDrinkMemo(rs.getString("drinkMemo"));
                        menu.setDrinkPrice(rs.getInt("drinkPrice"));
                        menu.setDrinkType(rs.getString("drinkType"));
                        menu.setDrinkType(rs.getString("drinkImgName"));

                        return menu;
                    }
                }
        );
        return results;
    }

    public void create(Menu menu) throws Exception {
        log.info("Repository Menu create");
        String query = "insert into menu(drinkName, drinkMemo, drinkType, drinkPrice, drinkImgName) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, menu.getDrinkName(), menu.getDrinkMemo(), menu.getDrinkType(), menu.getDrinkPrice(), menu.getDrinkImgName());
    }
}
