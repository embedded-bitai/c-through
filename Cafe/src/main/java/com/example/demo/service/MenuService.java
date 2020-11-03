package com.example.demo.service;

import com.example.demo.entity.Menu;
import java.util.List;

public interface MenuService {
    public List<Menu> list(Menu menu) throws Exception;
    public boolean create(Menu menu) throws Exception;
}
