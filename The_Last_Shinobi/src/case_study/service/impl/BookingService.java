package case_study.service.impl;

import case_study.exception.DateInvalidException;
import case_study.exception.DuplicateIdException;
import case_study.exception.IdFormatException;
import case_study.model.*;
import case_study.service.IBookingService;
import case_study.utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingService implements IBookingService {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void add() {
        Set<Booking> bookingList = ReadWriteBookingFileUtil.readBookingFile(Link.PATH_BOOKING.getPath());

        System.out.print("\nNhập mã đặt chỗ: ");
        String bookingId;
        while (true) {
            try {
                bookingId = SCANNER.nextLine();
                if (!bookingId.matches("^B\\d{4}$")) {
                    throw new IdFormatException("Mã đặt chỗ phải đúng định dạng: BXXXX, với XXXX là các số từ 0-9, vui lòng nhập lại!");
                }

                for (Booking booking : bookingList) {
                    if (bookingId.equals(booking.getBookingId())) {
                        throw new DuplicateIdException("Mã đặt chỗ đã tồn tại, vui lòng nhập lại!");
                    }
                }

                break;
            } catch (IdFormatException | DuplicateIdException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập ngày bắt đầu: ");
        String startDay;
        while (true) {
            try {
                startDay = RegexExceptionUtil.getDateFormat();
                if (new SimpleDateFormat("dd/MM/yyyy").parse(startDay).getTime() < new Date().getTime()) {
                    throw new DateInvalidException("Ngày bắt đầu phải không nhỏ hơn ngày hiện tại, vui lòng nhập lại!");
                }

                break;
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (DateInvalidException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập ngày kết thúc: ");
        String endDay;
        while (true) {
            try {
                endDay = RegexExceptionUtil.getDateFormat();
                if (new SimpleDateFormat("dd/MM/yyyy").parse(endDay).getTime() <= new SimpleDateFormat("dd/MM/yyyy").parse(startDay).getTime()) {
                    throw new DateInvalidException("Ngày kết thúc phải lớn hơn ngày bắt đầu, vui lòng nhập lại!");
                }

                break;
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (DateInvalidException e) {
                System.out.println(e.getMessage());
            }
        }

        new CustomerService().display();
        List<Customer> customerList = ReadWriteCustomerFileUtil.readCustomerFile(Link.PATH_CUSTOMER.getPath());
        System.out.print("Nhập mã khách hàng: ");
        String customerId;
        boolean isExistCustomerId = false;
        do {
            customerId = SCANNER.nextLine();
            for (Customer customer : customerList) {
                if (customerId.equals(customer.getId())) {
                    isExistCustomerId = true;
                    break;
                }
            }

            if (!isExistCustomerId) {
                System.out.println("Mã khách hàng khồng tồn tại, vui lòng nhập lại!");
            }
        } while (!isExistCustomerId);

        new FacilityService().display();
        Map<Facility, Integer> villaList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_VILLA.getPath());
        Map<Facility, Integer> houseList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_HOUSE.getPath());
        Map<Facility, Integer> roomList = ReadWriteFacilityFileUtil.readFacilityFile(Link.PATH_ROOM.getPath());

        System.out.print("Nhập mã dịch vụ: ");
        String serviceId;
        String serviceName = null;
        boolean isExistServiceId = false;
        do {
            serviceId = SCANNER.nextLine();

            for (Facility villa : villaList.keySet()) {
                if (serviceId.equals(villa.getServiceId())) {
                    serviceName = villa.getServiceName();
                    villaList.put(villa, villaList.get(villa) + 1);
                    ReadWriteFacilityFileUtil.writeFacilityFile(Link.PATH_VILLA.getPath(), villaList);
                    isExistServiceId = true;
                    break;
                }
            }

            for (Facility house : houseList.keySet()) {
                if (serviceId.equals(house.getServiceId())) {
                    serviceName = house.getServiceName();
                    houseList.put(house, houseList.get(house) + 1);
                    ReadWriteFacilityFileUtil.writeFacilityFile(Link.PATH_HOUSE.getPath(), houseList);
                    isExistServiceId = true;
                    break;
                }
            }

            for (Facility room : roomList.keySet()) {
                if (serviceId.equals(room.getServiceId())) {
                    serviceName = room.getServiceName();
                    roomList.put(room, roomList.get(room) + 1);
                    ReadWriteFacilityFileUtil.writeFacilityFile(Link.PATH_ROOM.getPath(), roomList);
                    isExistServiceId = true;
                    break;
                }
            }

            if (!isExistServiceId) {
                System.out.println("Mã dịch vụ khồng tồn tại, vui lòng nhập lại!");
            }
        } while (!isExistServiceId);

        bookingList.add(new Booking(bookingId, startDay, endDay, customerId, serviceId, serviceName));
        ReadWriteBookingFileUtil.writeBookingFile(Link.PATH_BOOKING.getPath(), bookingList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void display() {
        Set<Booking> bookingList = ReadWriteBookingFileUtil.readBookingFile(Link.PATH_BOOKING.getPath());
        List<Booking> bookings = new ArrayList<>();
        bookings.addAll(bookingList);
        DateComparatorUtil dateComparatorUtil = new DateComparatorUtil();
        bookings.sort(dateComparatorUtil);
        System.out.println("\nDanh sách đặt chỗ: ");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    @Override
    public void addContract() {
    }

    @Override
    public void displayContract() {
    }

    @Override
    public void editContract() {
    }
}
