package com.example.demo.service;

import com.example.demo.entity.Register;
import com.example.demo.repository.RegisterReposirory;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Log
@Service
public class RegistrerServicelmpl implements RegisterService{

    @Autowired
    private RegisterReposirory reposirory;

    @Override
    public Boolean register(Register register) throws Exception {
        log.info("Register Service Register");

        if (register.getId().length() > 4 && register.getPw().length() > 16 && register.getNn().length() > 4 && register.getPn() >=1000000000 &&
                Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", register.getEm()) &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getId()) &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([1-9])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([!@#$%^&*(),.?\":{}|<>])+).*$",register.getPw()) &&
                Pattern.matches("^[0-9]*$",String.valueOf(register.getPn()))
        ) {
            reposirory.create(register);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean overlapID(Register register) throws Exception {
        log.info("Register Service Overlap");
        if(register.getId().length() > 4 && Pattern.matches("^.*(([a-zA-Z])+).*$",register.getId()))
        {
            boolean TF = reposirory.overlapID(register);

            return TF ? false : true;
        }
        return false;
    }

    @Override
    public Boolean overlapNN(Register register) throws Exception {
        log.info("Register Service Overlap");
        if(register.getNn().length() > 4)
        {
            boolean TF = reposirory.overlapNN(register);

            return TF ? false : true;
        }
        return false;
    }

    @Override
    public Register findID(Register register) throws Exception {
        log.info("Register Service Find ID");
        if(register.getPn() >=1000000000 && Pattern.matches("^[0-9]*$",String.valueOf(register.getPn()))
        ) {
            Register getforid;
            getforid = reposirory.findid(register);
            return getforid;
        }
        return null;
    }

    @Override
    public Register findPw(Register register) throws Exception {
        log.info("Register Service Find Pw");
        if(register.getId().length() > 4 && Pattern.matches("^.*(([a-zA-Z])+).*$",register.getId()) &&
                Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", register.getEm())
        ) {
            Register getforid;
            getforid = reposirory.findpw(register);
            return getforid;
        }
        return null;
    }

    @Override
    public void uplodPw(Register register) throws Exception {
        log.info("Register Service Up Lod Pw");
        reposirory.uplodpw(register);
    }

    @Override
    public Register login(Register register) throws Exception {
        log.info("Register Service Login");
        if(register.getId().length() > 4 && register.getPw().length() > 16 &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getId()) &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([1-9])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([!@#$%^&*(),.?\":{}|<>])+).*$",register.getPw())
        ) {
            Register getid = reposirory.login(register);
            return getid;
        }
        return null;
    }
}

/*
    아이디	(중복)
    비밀번호
    닉네임	(중복)
    이메일	(보내기)
    주소
    전화번호	(gsm 사용시 확인 문자)

    로그인(아이디 비번)
    아이디 찾기(이름, 전화번호)
    비밀번호(이름 아이디 이메일(확인))
 */