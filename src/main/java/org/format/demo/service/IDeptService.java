package org.format.demo.service;


import org.format.demo.model.Dept;

import java.util.List;

public interface IDeptService {

    List<Dept> listAll();

    void saveOrUpdate(Dept dept);

}
