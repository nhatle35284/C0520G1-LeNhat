package repository;

import model.Setting;

import java.util.List;

public interface ISettingRepository {
    List<String> getLanguage();
    List<String> getPageSize();

}

