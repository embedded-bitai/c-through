package com.example.demo.service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class MenuServiceImpl implements MenuService {
    static final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> list(Menu menu) throws Exception {
        return repository.list(menu);
    }

    @Override
    public boolean create(Menu menu) throws Exception {
        if(Pattern.matches("^(([1-9])+?)$",String.valueOf(menu.getDrinkPrice())))
        {
            repository.create(menu);
            return true;
        }
        else {
            return false;
        }
    }


}
