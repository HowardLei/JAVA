package com.company;

import lombok.*;

/**
 * Person class
 *
 * @author apple
 * @date 2020/3/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private int money;
}