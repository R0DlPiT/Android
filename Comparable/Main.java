package com.company;

import java.util.ArrayList;

/**
 * За основу взято разделение кинематогрофа по типам произведений
 *
 * Entity - абстрактный класс сущности
 * Serial - класс сериала
 * Film - класс фильма
 * Cartoon - класс мультфильма
 *
 */

//Класс сущности
abstract class Entity implements Comparable<Entity>{
    abstract int getTime();

    public int compareTo(Entity entity){
        if (entity == null) return 1;

        if(this.getTime() > entity.getTime()) return 1;
        else if(this.getTime() < entity.getTime()) return -1;
        else return 0;

    }
}

class Serial extends Entity{

    int series;
    int time;
    String name;

    Serial(int series, int time){
        this.series = series;
        this.time = time;
        this.name = "Сериал";
    }

    public String getName() {
        return name;
    }

    @Override
    int getTime() {
        return this.series + this.time;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Serial serial = (Serial) o;

        return this.getName().equals(serial.getName()) && this.series == serial.series
                && this.time == serial.time;

    }

    @Override
    public String toString(){
        return "Тип произведения - " + this.name + ", его продолжительность минут - " + this.time +", количество серий - " + this.series;
    }
}

class Film extends Entity{

    int time;
    String name;

    Film(int time){
        this.time = time;
        this.name = "Полнометражный фильм";
    }

    public String getName() {
        return name;
    }

    @Override
    int getTime() {
        return this.time;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        return this.getName().equals(film.getName()) && this.time == film.time;

    }

    @Override
    public String toString(){
        return "Тип произведения - " + this.name + ", его продолжительность минут " + this.time;
    }
}

class Cartoon extends Entity{

    int time;
    int pg;
    String name;

    Cartoon(int time, int pg){
        this.time = time;
        this.pg = pg;
        this.name = "Мультфильм";
    }

    public String getName() {
        return name;
    }

    @Override
    int getTime() {
        return this.time + this.pg;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cartoon cartoon = (Cartoon) o;

        return this.getName().equals(cartoon.getName()) && this.pg == cartoon.pg
                && this.time == cartoon.time;

    }

    @Override
    public String toString(){
        return "Тип произведения - " + this.name + ", его продолжительность минут " + this.time + ", возрастной рейтинг - "  + this.pg + "+";
    }
}

public class Main {

    public static void main(String[] args) {


        Serial serial1 = new Serial(20, 50);
        Serial serial2 = new Serial(24, 50);
        Serial serial3 = serial1;
        
        System.out.println("serial1 == serial2 - " + serial1.equals(serial2) + ", serial1 == serial3 - "
                + serial1.equals(serial3) + "\n");

        //Показываю сортировку
        ArrayList<Serial> serials = new ArrayList<>();
        serials.add(serial2);
        serials.add(serial1);
        serials.add(serial3);

        for (Serial serial : serials) System.out.println(serial);
        System.out.println("\n");

        serials.sort(Serial::compareTo);

        for (Serial serial : serials) System.out.println(serial);

    }
}
