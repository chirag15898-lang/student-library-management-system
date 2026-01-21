package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "pages" , nullable = false)
    private int  Pages;

    @Column(name = "publisher_name" , nullable = false)
    private String publisherName;

    @Column(name = "published_date")
    private Date publishedDate;

    @Column(name = "category" , nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "Availability",nullable = false)
    private boolean availability;

    @Column(name = "rack_no", nullable = false)
    private String rackNo;
}
