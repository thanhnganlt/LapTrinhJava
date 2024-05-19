package com.example.quanLySach.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data //geter seter
@NoArgsConstructor //tao khong tham so
@AllArgsConstructor //htao có tham so
@Builder // builder
public class Book {
    private int id;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 100, message = "Tiêu đề không được vượt quá 100 ký tự")
    private  String title;

    @NotBlank(message = "Tác giả không được để trống.")
    @Size(max = 100, message = "Tác giả không được vượt quá 100 ký tự.")
    private String author;

    @NotNull(message = "Giá không được để trống.")
    @Min(value = 0, message = "Giá phải là một số không âm.")
    private Double price;

    @NotBlank(message = "Thể loại không được để trống.")
    @Pattern(regexp = "^[A-Za-z]+$",message = "Thể loại chỉ chấp nhận chữ cái và khoảng trắng.")
    private String category;

    private String imageUrl;
}
