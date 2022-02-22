package com.patikapaycore.TourAgencySystem.model;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.StringJoiner;
@Data
public class HotelDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotEmpty
    private List<@Valid Address> addresses;

    public String formatAddresses() {
        StringJoiner strJoiner = new StringJoiner(" // ");
        getAddresses().forEach(address -> strJoiner.add(address.dbFormat()));
        return strJoiner.toString();
    }
}
