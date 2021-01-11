package com.assignment.languages.services;


import com.assignment.languages.models.language;
import com.assignment.languages.repositories.languageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class languageService {
    private final com.assignment.languages.repositories.languageRepository languageRepository;

    public languageService(languageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    public List<language> alllanguages() {
        return languageRepository.findAll();
    }
    public language createlanguage(language l) {
        return languageRepository.save(l);
    }
    public language findlanguage(Long id) {
        Optional<language> optionallanguage = languageRepository.findById(id);
        if(optionallanguage.isPresent()) {
            return optionallanguage.get();
        } else {
            return null;
        }
    }

    public void deletelanguage(Long id) {
        languageRepository.deleteById(id);
    }

    public language updatelanguage(Long id, String name, String creator, String currentVersion) {
        Optional <language> update = languageRepository.findById(id);
        if(update != null && update.isPresent()) {
            update.get().setName(name);
            update.get().setCreator(creator);
            update.get().setCurrentVersion(currentVersion);
            languageRepository.save(update.get());
            return update.get();
        }
        return null;
    }

}