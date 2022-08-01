package bank_account.service.impl;

import bank_account.exception.NotFoundBankAccountException;
import bank_account.exception.NumberInvalidException;
import bank_account.model.BankAccount;
import bank_account.model.SavingBankAccount;
import bank_account.service.ISavingBankAccountService;
import bank_account.utils.ReadWriteBankAccountUtil;

import java.util.List;
import java.util.Scanner;

public class SavingBankAccountService implements ISavingBankAccountService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATH_SAVING = "src/bank_account/data/saving_account.csv";

    @Override
    public void add() {
        List<BankAccount> bankAccountList = ReadWriteBankAccountUtil.readBankAccountFile(PATH_SAVING);

        int id = bankAccountList.get(bankAccountList.size() - 1).getId() + 1;

        System.out.println("Nhập mã tài khoản: ");
        String code = SCANNER.nextLine();

        System.out.println("Nhập tên chủ tài khoản: ");
        String name = SCANNER.nextLine();

        System.out.println("Nhập ngày tạo tài khoản: ");
        String date = SCANNER.nextLine();

        System.out.print("Nhập số tiền gửi tiết kiệm (VNĐ): ");
        int moneySaving;
        do {
            try {
                moneySaving = Integer.parseInt(SCANNER.nextLine());
                if (moneySaving <= 0) {
                    throw new NumberInvalidException("Vui lòng nhập số dương!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            } catch (NumberInvalidException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Nhập ngày gửi: ");
        String dateSaving = SCANNER.nextLine();

        System.out.println("Nhập lãi suất (%): ");
        double interestRate;
        do {
            try {
                interestRate = Double.parseDouble(SCANNER.nextLine());
                if (interestRate <= 0) {
                    throw new NumberInvalidException("Vui lòng nhập số dương!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            } catch (NumberInvalidException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Nhập kì hạn (tháng): ");
        int time;
        do {
            try {
                time = Integer.parseInt(SCANNER.nextLine());
                if (time <= 0) {
                    throw new NumberInvalidException("Vui lòng nhập số dương!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            } catch (NumberInvalidException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        bankAccountList.add(new SavingBankAccount(id, code, name, date, moneySaving, dateSaving, interestRate, time));
        ReadWriteBankAccountUtil.writeBankAccountFile(PATH_SAVING, bankAccountList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        List<BankAccount> bankAccountList = ReadWriteBankAccountUtil.readBankAccountFile(PATH_SAVING);
        boolean isExist = false;
        String codeRemove;

        do {
            System.out.println("Mời bạn nhập mã tài khoản cần xóa: ");
            codeRemove = SCANNER.nextLine();

            for (BankAccount bankAccount : bankAccountList) {
                if (codeRemove.equals(bankAccount.getCode())) {
                    System.out.println("Tài khoản cần xóa: ");
                    System.out.println(bankAccount);
                    System.out.println("Bạn có chắc muốn xóa hay không? \n" +
                            "1. Nhấn phím '1' nếu chọn CÓ. \n" +
                            "2. Nhấn phím khác nếu chọn KHÔNG.");
                    String chooseYesNo = SCANNER.nextLine();

                    if (chooseYesNo.equals("1")) {
                        bankAccountList.remove(bankAccount);
                        ReadWriteBankAccountUtil.writeBankAccountFile(PATH_SAVING, bankAccountList);
                        System.out.println("Xóa thành công!");
                    }
                    isExist = true;
                    break;
                }
            }

            try {
                if (!isExist) {
                    throw new NotFoundBankAccountException("Tài khoản không tồn tại!");
                }
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (!isExist);
    }

    @Override
    public void display() {
        List<BankAccount> bankAccountList = ReadWriteBankAccountUtil.readBankAccountFile(PATH_SAVING);
        for (BankAccount bankAccount : bankAccountList) {
            System.out.println(bankAccount);
        }
    }

    @Override
    public void find() {
        List<BankAccount> bankAccountList = ReadWriteBankAccountUtil.readBankAccountFile(PATH_SAVING);

        System.out.println("Mời bạn nhập mã tài khoản hoặc tên chủ tài khoản cần tìm kiếm: ");
        String find = SCANNER.nextLine();
        boolean isExist = false;

        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getCode().contains(find) || bankAccount.getName().toLowerCase().contains(find.toLowerCase())) {
                System.out.println(bankAccount);
                isExist = true;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }
}
