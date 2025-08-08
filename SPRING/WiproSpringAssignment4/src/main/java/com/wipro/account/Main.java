package com.wipro.account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Account account = (Account) context.getBean("accountBean");
        account.displayDetails();
    }
}

/*Account Number: 875410110025698
Account Holder: Sahil Lokhande
Account Balance: 985632.0
Account Type: Savings
*/