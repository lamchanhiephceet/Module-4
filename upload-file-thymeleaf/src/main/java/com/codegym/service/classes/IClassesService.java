package com.codegym.c0320h1.service.classes;

import com.codegym.c0320h1.model.Classess;
import com.codegym.c0320h1.service.IService;

public interface IClassesService extends IService<Classess> {
    Classess findByName(String name);
}
