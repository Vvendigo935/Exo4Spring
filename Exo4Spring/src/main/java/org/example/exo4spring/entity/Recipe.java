package org.example.exo4spring.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4spring.util.Categ;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    private Long id;

    @NotNull
    @NotBlank(message = "recipe must have a name !")
    @Size(min = 2,max = 40)
    private String name;

    @NotNull
    private List<String> ingredients;

    @NotNull
    @NotBlank(message = "recipe must have at least some description !")
    private String instruction;

    @NotNull
    Categ categ;



}
