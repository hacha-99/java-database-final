package com.project.code.Model;

import java.lang.annotation.Inherited;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Customer {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;

    @NotNull(message = "name cannot be null")
    @Size(min=2)
    private String name;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "phone cannot be null")
    private String phone;

    @JsonManagedReference // proper json serialization
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER) // one customer has many orders
    private List<OrderItem> orders;

    public Long  getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

