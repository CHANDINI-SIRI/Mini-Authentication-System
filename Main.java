import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            new LoginFrame();
        try (Scanner sc = new Scanner(System.in)) {

            while (true) {

                System.out.println("\n===== Mini Authentication System =====");
                System.out.println("1. OTP Verification");
                System.out.println("2. Generate Password");
                System.out.println("3. Register User");
                System.out.println("4. Login");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        String otp = OTPGenerator.generateOTP(6);
                        long startTime = System.currentTimeMillis();

                        System.out.println("Generated OTP: " + otp);
                        System.out.println("OTP valid for 30 seconds.");

                        int attempts = 0;
                        boolean verified = false;

                        while (attempts < 3) {

                            System.out.print("Enter OTP: ");
                            String userOtp = sc.next();

                            long currentTime = System.currentTimeMillis();
                            long elapsedTime = (currentTime - startTime) / 1000;

                            if (elapsedTime > 30) {
                                System.out.println("OTP Expired!");
                                break;
                            }

                            if (userOtp.equals(otp)) {
                                System.out.println("OTP Verified Successfully!");
                                verified = true;
                                break;
                            } else {
                                attempts++;
                                System.out.println("Incorrect OTP. Attempts left: " + (3 - attempts));
                            }
                        }

                        if (!verified) {
                            System.out.println("Verification failed.");
                        }
                        break;

                    case 2:
                        String password = PasswordGenerator.generatePassword(10);
                        System.out.println("Generated Password: " + password);
                        System.out.println("Strength: " + PasswordGenerator.checkStrength(password));
                        break;

                    case 3:
                        System.out.print("Enter username: ");
                        String username = sc.next();

                        String pwd = PasswordGenerator.generatePassword(10);
                        System.out.println("Generated Password: " + pwd);

                        UserService.saveUser(username, pwd);
                        break;

                    case 4:
                        System.out.print("Enter username: ");
                        String u = sc.next();

                        System.out.print("Enter password: ");
                        Console console = System.console();
                        char[] passArray = console.readPassword("Enter password: ");
                        String p = new String(passArray);
                        if (UserService.login(u, p)) {
                            System.out.println("Login Successful!");
                        } else {
                            System.out.println("Invalid Credentials.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }
}