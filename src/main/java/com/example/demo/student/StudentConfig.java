package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student gica = new Student(
                    "Gica",
                    "gica@yahoo.com",
                    LocalDate.of(2000, Month.AUGUST, 8)
            );

            Student marian = new Student(
                    "Marian",
                    "mari@yahoo.com",
                    LocalDate.of(1996, Month.JANUARY, 8)
            );

            repository.saveAll(
                    List.of(gica, marian));

        };
    }
}
