import java.security.SecureRandom;

public class OTPGenerator {

    // Method to generate OTP of given length
    public static String generateOTP(int length) {

        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);   // generates 0-9
            otp.append(digit);
        }

        return otp.toString();
    }
}
