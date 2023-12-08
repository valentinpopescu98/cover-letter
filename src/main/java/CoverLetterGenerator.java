import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CoverLetterGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for variable fields
        String fullName = "Marius-Valentin Popescu";
        String address = "Address";
        String cityCountry = "Bucharest, Romania";
        String emailAddress = "valentinpopescu98@gmail.com";
        String phoneNumber = "Phone Number";
        String todaysDate = "8-12-2023";
        String companyName = "Company Name";
        String jobTitle = "Job Title";
        String whereYouFoundJobPosting = "LinkedIn";

        // Read cover letter template from file
        String inputFilePath = ".//src//main//resources//cover-letter-in.txt";
        String coverLetterTemplate = readCoverLetterFromFile(inputFilePath);

        // Generating the cover letter
        String coverLetter = generateCoverLetter(coverLetterTemplate,
                fullName, address, cityCountry, emailAddress, phoneNumber,
                todaysDate, companyName, jobTitle, whereYouFoundJobPosting
        );

        // Write the generated cover letter to a new file
        String outputFilePath = ".//src//main//resources//cover-letter-out.txt";
        writeCoverLetterToFile(outputFilePath, coverLetter);

        System.out.println("\nGenerated Cover Letter has been saved to: " + outputFilePath);

        scanner.close();
    }

    private static String readCoverLetterFromFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.err.println("Error reading cover letter file: " + e.getMessage());
            return "";
        }
    }

    private static void writeCoverLetterToFile(String filePath, String coverLetter) {
        try {
            Files.writeString(Path.of(filePath), coverLetter);
        } catch (IOException e) {
            System.err.println("Error writing cover letter to file: " + e.getMessage());
        }
    }

    private static String generateCoverLetter(String coverLetterTemplate, String fullName, String address,
                                              String cityCountry, String emailAddress, String phoneNumber,
                                              String todaysDate, String companyName, String jobTitle,
                                              String whereYouFoundJobPosting) {
        return coverLetterTemplate
                .replace("[Your Full Name]", fullName)
                .replace("[Your Address]", address)
                .replace("[City, Country]", cityCountry)
                .replace("[Your Email Address]", emailAddress)
                .replace("[Your Phone Number]", phoneNumber)
                .replace("[Today's Date]", todaysDate)
                .replace("[Company Name]", companyName)
                .replace("[Job Title]", jobTitle)
                .replace("[where you found the job posting]", whereYouFoundJobPosting);
    }
}