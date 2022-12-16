package com.repository;

import com.model.Mail;

import java.util.List;

public interface IMailRepository {
    List<Mail> showAll();

    Mail findById(int idSearch);
    List<String> getLanguageList();
    List<Integer> getPageSizeList();
    void update(Mail mail);
}
