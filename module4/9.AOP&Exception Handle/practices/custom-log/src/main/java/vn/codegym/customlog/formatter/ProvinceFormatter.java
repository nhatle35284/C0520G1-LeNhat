package vn.codegym.customlog.formatter;

import org.springframework.format.Formatter;
import vn.codegym.customlog.model.Province;
import vn.codegym.customlog.service.ProvinceService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class ProvinceFormatter implements Formatter<Optional<Province>> {
    private ProvinceService provinceService;

    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Optional<Province> parse(String text, Locale locale) throws ParseException {
        return provinceService.findOne(Long.valueOf(text));
    }

    @Override
    public String print(Optional<Province> object, Locale locale) {
        return object.toString();
    }
}
