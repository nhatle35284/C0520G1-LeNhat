package service;

import model.Setting;

import java.util.List;

public interface ISettingService {
    List<String> getLanguage();
    List<String> getPageSize();
}
