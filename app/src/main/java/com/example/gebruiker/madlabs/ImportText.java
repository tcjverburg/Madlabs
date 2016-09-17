package com.example.gebruiker.madlabs;
import java.io.IOException;
import java.util.Scanner;


public class ImportText {
public Scanner scan;
public String path;


    public void main(String arg[]) throws IOException {
        Scanner scan = new Scanner("C:\\Users\\Gebruiker\\AndroidStudioProjects\\Madlabs\\app\\src\\main\\res\\raw\\madlib1_tarzan.txt");
        System.out.println(scan);
    }
}
