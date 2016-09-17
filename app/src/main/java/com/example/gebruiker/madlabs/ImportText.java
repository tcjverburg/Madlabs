package com.example.gebruiker.madlabs;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ImportText {

public String path;

    public Scanner main(String arg[])throws IOException
    {
        File temp = new File(path);
        Scanner file = new Scanner(temp);
        return file;

    }
}
