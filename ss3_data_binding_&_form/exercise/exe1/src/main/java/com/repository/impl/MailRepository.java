package com.repository.impl;

import com.model.Mail;
import com.repository.IMailRepository;

import java.util.ArrayList;
import java.util.List;

public class MailRepository implements IMailRepository {
    private static List<Mail> mailList = new ArrayList<>();

    static {
        Mail mail1 = new Mail(1, "English", 25, true, "abc");
        Mail mail2 = new Mail(2, "Japanese", 20, true, "abc");
        Mail mail3 = new Mail(3, "Chinese", 15, false, "abc");
        mailList.add(mail1);
        mailList.add(mail2);
        mailList.add(mail3);
    }


    public List<String> getLanguageList() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    public List<Integer> getPageSizeList() {
        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        return pageSizeList;
    }

    @Override
    public List<Mail> showAll() {
        return mailList;
    }

    @Override
    public Mail findById(int idSearch) {
        for (Mail mail : mailList) {
            if (idSearch == mail.getId()) {
                return mail;
            }
        }
        return null;
    }

    public int findIndex(int idSearch) {
        for (int i = 0; i < mailList.size(); i++) {
            if (idSearch == mailList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(Mail mail) {
        mailList.set(findIndex(mail.getId()), mail);
    }
}
