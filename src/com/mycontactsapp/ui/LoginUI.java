package com.mycontactsapp.ui;

import com.mycontactsapp.auth.*;
import com.mycontactsapp.model.*;
import com.mycontactsapp.service.*;

import java.util.Optional;
import java.util.Scanner;

public class LoginUI {

    private static Scanner scanner = new Scanner(System.in);
    
    public static void start() {
        LoginService service =
                new LoginService(new BasicAuth());

        System.out.println("\n===== Login =====");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Optional<User> user =
                service.login(email,password);

        if(user.isPresent()) {
            System.out.println(
                    "Login successful! Welcome "
                    + user.get().getName()
            );

        } else {
            System.out.println("Invalid credentials.");
        }
    }
}
