/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.hotel.backend.controller;

import com.hotel.backend.entity.Booking;
import com.hotel.backend.entity.Customer;
import com.hotel.backend.entity.Room;
import com.hotel.backend.reponsitory.BookingReponsitory;
import com.hotel.backend.reponsitory.CustomerRepo;
import com.hotel.backend.reponsitory.RoomRepo;
import com.hotel.backend.request.HotelBookingRequest;
import com.hotel.backend.service.RoomService;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class HotelBookingController {
    
    @Autowired
    private BookingReponsitory BookingRepository;
    
    @Autowired
    private RoomRepo RoomRepo;
    
    @Autowired
    private CustomerRepo CustomerRepo;
    
    @Autowired
    private RoomService roomService;
    
    //show all booking by customer
    @GetMapping("/customer/booking")
    public List<Booking> showAllBooking() {
        return BookingRepository.findAll();
    }
    
    
    //get booking by room id
    @GetMapping(value = "/getbooking/{id}")
    public List<Booking> getBookingByRoomId(@PathVariable("id") Long id){
        return RoomRepo.findAllById(id);
    }
    
//    //HotelBooking
//    @PostMapping(value = "/hotelBooking")
//    public ResponseEntity<?> hotelBooking(@RequestBody HotelBookingRequest hotelBookingRequest, Model model) throws IOException {
//        //find room by id
//        List<Room> room = roomService.findById(id);
//   
//        //find user by id
//        Customer customer = CustomerRepo.findById(hotelBookingRequest.getUserId()).get();
//        System.out.println(hotelBookingRequest.getCheckInDate());
//        System.out.println(hotelBookingRequest.getCheckOutDate());
//        
//        //check in date before check out date
//        if (hotelBookingRequest.getCheckInDate().after(hotelBookingRequest.getCheckOutDate())) {
//            return ResponseEntity.badRequest().body("Check in date must be before check out date");
//        }
//        //check check in date after today
//        // if(hotelBookingRequest.getCheckInDate().before(new Date())){
//        //     return ResponseEntity.badRequest().body("Check in date must be after today");
//        // }
//        //check Number of people in room
//        int people = room.getMaxChildren() + room.getMaxAdult();
//        System.out.println(people);
//        if (people < hotelBookingRequest.getNumOfGuest()) {
//            return ResponseEntity.badRequest().body("Number of people in room must be less than " + people);
//        }
//
//        //add hotel booking
//        Booking hotelBooking = new Booking();
//        hotelBooking.setBookingCode(emailSenderService.randomString());
//        //time
//        hotelBooking.setCheckInDate(hotelBookingRequest.getCheckInDate());
//        hotelBooking.setCheckOutDate(hotelBookingRequest.getCheckOutDate());
//        hotelBooking.setNumOfGuest(hotelBookingRequest.getNumOfGuest());
//        hotelBooking.setPaymentMethod(hotelBookingRequest.getPaymentMethod());
//        hotelBooking.setTotal(hotelBookingRequest.getTotalPrice());
//        hotelBooking.setRoomId(roomId);
//        hotelBooking.setUserId(user);
//
//        Booking resultHotelBooking = BookingRepository.save(hotelBooking);
//        //room status = true
//        room.setRoomStatus(true);
//        roomRepository.save(room);
//        System.out.println(resultHotelBooking.getBookingCode());
//        //return hotel booking
//
//        //check booking success if true send mail to user
//        if (resultHotelBooking != null) {
//
//            //Qr code information resultHotelBooking
//            String qrCodeInfo = "Booking code: " + resultHotelBooking.getBookingCode()
//                    + "\n" + "Check in date: " + resultHotelBooking.getCheckInDate() + "\n"
//                    + "Check out date: " + resultHotelBooking.getCheckOutDate() + "\n"
//                    + "Number of guest: " + resultHotelBooking.getNumOfGuest() + "\n"
//                    + "Total price: " + resultHotelBooking.getTotalPrice() + "\n"
//                    + "Payment method: " + resultHotelBooking.getPaymentMethod();
//
//            //create qr code
//            String nameQr = emailSenderService.randomString() + ".png";
//            System.out.println("name Qr: " + nameQr);
//            generateQRCodeImage(qrCodeInfo, 300, 300, "uploads/" + nameQr);
//            //insert qr code to hotel booking
//            resultHotelBooking.setQrCode(nameQr);
//            hotelBookingRepository.save(resultHotelBooking);
//
//            Map<String, Object> emailMap = new HashMap<>();
//            emailMap.put("hotelBooking", resultHotelBooking);
//            emailMap.put("user", user);
//            emailMap.put("hotel", hotel);
//            emailMap.put("room", room);
//            emailMap.put("qrCode", "http://localhost:8080/api/auth/getImage/" + nameQr);
//            //address
//            String address = hotel.getLocation().getWard().getName() + ", " + hotel.getLocation().getDistrict().getName() + ", " + hotel.getLocation().getProvince().getName();
//            emailMap.put("address", address);
//            String templateHtml = emailSenderService.templateResolve("bookingSuccess", emailMap);
//            emailSenderService.sendTemplateMessage(user.getEmail(), "Booking Success", "bookingSuccess", templateHtml);
//        }
//        return ResponseEntity.ok().body(resultHotelBooking);
//    }
//    
//    //qr code
//    public static void generateQRCodeImage(String text, int width, int height, String filePath)
//            throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//
//        Path path = FileSystems.getDefault().getPath(filePath);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//
//    }
}
