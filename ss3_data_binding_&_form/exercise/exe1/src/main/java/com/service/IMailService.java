package com.service;

import com.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> showAll();

    List<Integer> getPageSizeList();
    List<String> getLanguageList();
    Mail findById(int idSearch);

    void update(Mail mail);
}
