package com.edu.main;

import com.edu.notifications.EmailSender;
import com.edu.notifications.EmployeeNotifier;
import com.edu.payment.PaymentProcessor;
import com.edu.persistence.EmployeeFileRepository;
import com.edu.persistence.EmployeeFileSerializer;
import com.edu.persistence.EmployeeRepository;

public class PayEmployeesMain {

    /*
    Will take a couple of seconds to execute due to the
    sending of mails.
     */

    public static void main(String[] args) {

        EmployeeFileSerializer serializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository =
                new EmployeeFileRepository(serializer);
        EmployeeNotifier employeeNotifier = new EmailSender();
        PaymentProcessor paymentProcessor = new PaymentProcessor(
                employeeRepository,
                employeeNotifier);

        int totalPayments = paymentProcessor.sendPayments();
        System.out.println("Total payments " + totalPayments);
    }
}
