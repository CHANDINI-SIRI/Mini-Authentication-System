import java.io.*;

public class UserService {

    // 🔹 REGISTER USER
    public static void saveUser(String username, String password) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))) {

            // Generate salt
            String salt = HashUtil.generateSalt();

            // Hash password with salt
            String hash = HashUtil.hashPassword(password, salt);

            // Store: username,salt,hash
            bw.write(username + "," + salt + "," + hash);
            bw.newLine();

            System.out.println("User registered successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // 🔹 LOGIN USER
    public static boolean login(String username, String password) {

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String storedUsername = data[0];
                String salt = data[1];
                String storedHash = data[2];

                // Hash entered password using stored salt
                String inputHash = HashUtil.hashPassword(password, salt);

                if (storedUsername.equals(username) && storedHash.equals(inputHash)) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return false;
    }
}