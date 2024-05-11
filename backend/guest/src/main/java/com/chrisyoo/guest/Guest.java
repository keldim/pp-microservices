package com.chrisyoo.guest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guest {
    @Id
    @SequenceGenerator(
            name = "guest_id_sequence",
            sequenceName = "guest_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guest_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
