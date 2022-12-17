package com.service.impl;

import com.model.Mail;
import com.repository.IMailRepository;
import com.repository.impl.MailRepository;
import com.service.IMailService;

import java.util.List;

public class MailService implements IMailService {
    private IMailRepository iMailRepository = new MailRepository();

    @Override
    public List<Mail> showAll() {
        return iMailRepository.showAll();
    }

    @Override
    public List<Integer> getPageSizeList() {
        return this.iMailRepository.getPageSizeList();
    }

    @Override
    public List<String> getLanguageList() {
        return iMailRepository.getLanguageList();
    }

    @Override
    public Mail findById(int idSearch) {
        return iMailRepository.findById(idSearch);
    }

    @Override
    public void update(Mail mail) {
        iMailRepository.update(mail);
    }
}
