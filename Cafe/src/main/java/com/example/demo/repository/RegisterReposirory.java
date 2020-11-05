package com.example.demo.repository;

import com.example.demo.entity.Register;
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
public class RegisterReposirory {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Register register) throws Exception {
        log.info("Repository Register Create");
        String query = "insert into register(id, pw, nn, name, em, br) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, register.getId(), register.getPw(), register.getNn(), register.getName(), register.getEm());
    }

    public Boolean overlapID(Register register) throws Exception {
        log.info("Repository Register Overlap");

        List<Register> res = jdbcTemplate.query(
                "select id from register where id = ?",
                new RowMapper<Register>() {
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register1 = new Register();

                        register1.setId(rs.getString("id"));

                        return register1;
                    }
                }, register.getId()
        );

        return res.isEmpty() ? true : false;
    }

    public Boolean overlapNN(Register register) throws Exception {
        log.info("Repository Register Overlap");

        List<Register> res = jdbcTemplate.query(
                "select nn from register where nn = ?",
                new RowMapper<Register>() {
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register1 = new Register();

                        register1.setId(rs.getString("nn"));

                        return register1;
                    }
                }, register.getNn()
        );

        return res.isEmpty() ? true : false;
    }


    public Register findid(Register register) throws Exception {
        log.info("Repository Register Find Id");

        List<Register> res = jdbcTemplate.query(
                "select id from register where name = ? and br = ?",
                new RowMapper<Register>() {
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register1 = new Register();

                        register1.setId(rs.getString("id"));

                        return register1;
                    }
                },register.getName()
        );
        return res.isEmpty() ? null : res.get(0);
    }

    public Register findpw(Register register) throws Exception {
        log.info("Repository Register Find Pw");

        List<Register> res = jdbcTemplate.query(
                "select id from register where name = ? and id = ? and br = ?",
                new RowMapper<Register>() {
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register1 = new Register();
                        register1.setId(rs.getString("id"));

                        return register1;
                    }
                },register.getName(), register.getId()
        );

        return res.isEmpty() ? null : res.get(0);
    }

    public void uplodpw(Register register) throws Exception {
        log.info("Repository Register Up Lod Pw");
        String query = "update register set pw = ? where id = ?";
        jdbcTemplate.update(query, register.getPw(), register.getId());
    }

    public Register login(Register register) throws Exception {
        log.info("Repository Register Login");

        List<Register> res = jdbcTemplate.query(
                "select id from register where id = ? and pw = ?",
                new RowMapper<Register>() {
                    @Override
                    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Register register1 = new Register();
                        register1.setId(rs.getString("id"));

                        return register1;
                    }
                }, register.getId(), register.getPw()
        );

        return res.isEmpty() ? null : res.get(0);
    }
}
