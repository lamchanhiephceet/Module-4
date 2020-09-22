package com.codegym.cms.formater;

import com.codegym.cms.model.Province;
import com.codegym.cms.service.ProvinceService;
import org.hibernate.engine.jdbc.internal.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    private ProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return provinceService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

    @Override
    public String format(String source) {
        return null;
    }

    /**
     * Print the object of type T for display.
     *
     * @param object the instance to print
     * @param locale the current user locale
     * @return the printed text string
     */
    @Override
    public String print(Object object, Locale locale) {
        return null;
    }
}