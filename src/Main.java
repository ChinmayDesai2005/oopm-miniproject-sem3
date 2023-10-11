import Controller.Controller;
import Model.*;
import View.View;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
    }
}