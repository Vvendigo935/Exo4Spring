package org.example.exo4spring.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4spring.util.Categ;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    private Long id;

    @NotNull
    @NotBlank(message = "recipe must have a name !")
    Categ name;

    @NotNull
    private String description;



}
