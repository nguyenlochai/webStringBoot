package com.example.dimonshop.webEntity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class UserRegister {

    @NotBlank(message = "thông tin bắt buộc")
    @Size(min = 1, message = "min là 1")
    private String username;


    @NotNull(message = "thông tin bắt buộc")
    @Size(min=8, message = "độ dài tối thiểu là 8")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$",
            message = "Mật khẩu phải chứa ít nhất 1 chữ số và 1 ký tự đặc biệt")
    private String password;

    @NotNull(message = "SDT không được để trống")
    private String sdt;

    @NotBlank(message = "thông tin bắt buộc")
    private String address;

    @NotBlank(message = "thông tin bắt buộc")
    private String firstName;



    @NotBlank(message = "thông tin bắt buộc")
    private String lastName;

    @NotBlank(message = "thông tin bắt buộc")
    @Email(message = "email không hợp lệ")
    private String email;

    public UserRegister(String username, String password, String sdt, String address, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.sdt = sdt;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserRegister() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }
}
