package bank_account.utils;

import bank_account.model.BankAccount;
import bank_account.model.PaymentBankAccount;
import bank_account.model.SavingBankAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteBankAccountUtil {
    private static List<String> readFile(String path) {
        List<String> stringList = new ArrayList<>();
        String line;
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringList;
    }

    public static List<BankAccount> readBankAccountFile(String path) {
        List<String> stringList = readFile(path);
        List<BankAccount> bankAccountList = new ArrayList<>();
        String[] info;
        for (String line : stringList) {
            info = line.split(",");
            if (info.length == 6) {
                bankAccountList.add(new PaymentBankAccount(Integer.parseInt(info[0]), info[1], info[2], info[3],
                        Integer.parseInt(info[4]), Integer.parseInt(info[5])));
            } else if (info.length == 8) {
                bankAccountList.add(new SavingBankAccount(Integer.parseInt(info[0]), info[1], info[2], info[3],
                        Integer.parseInt(info[4]), info[5], Double.parseDouble(info[6]), Integer.parseInt(info[7])));
            }
        }

        return bankAccountList;
    }

    private static void writeFile(String path, String data) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBankAccountFile(String path, List<BankAccount> bankAccountList) {
        StringBuilder data = new StringBuilder();
        for (BankAccount bankAccount : bankAccountList) {
            data.append(bankAccount.getInfo());
        }

        writeFile(path, data.toString());
    }
}
