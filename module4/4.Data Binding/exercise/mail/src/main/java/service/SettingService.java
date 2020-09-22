package service;

import model.Setting;
import repository.ISettingRepository;
import repository.SettingRepository;
//import repository.SettingRepository;

import java.util.List;

public class SettingService implements ISettingService{
    ISettingRepository iSettingsRepository = new SettingRepository();

    @Override
    public List<String> getLanguage() {
        return iSettingsRepository.getLanguage();
    }

    @Override
    public List<String> getPageSize() {
        return iSettingsRepository.getPageSize();
    }
}
