package com.patikapaycore.TourAgencySystem.model.entity;
import com.patikapaycore.TourAgencySystem.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "{validation.messages.hotel.name}")
    private String name;
    @NotNull(message = "{validation.messages.hotel.type}")
    private String type;
    @NotNull(message = "{validation.messages.hotel.address}")
    private String address;

    @Transient
    private List<Address> addresses;

    public List<Address> formatToAddressList() {
        String[] splittedAddresses = address.split("//");
        List<Address> resultFormat = new ArrayList<>();
        Arrays.stream(splittedAddresses).forEach(split -> {
            String[] splitteds = split.trim().split("/");
            resultFormat.add(new Address(splitteds[0], splitteds[1]));
        });
        return resultFormat;
    }
}
