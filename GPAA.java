


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GPAA {
	public static void main(String[] args) {

		Path file = Paths.get("\\Tom.doc\\");
		InputStream input = null;
		try {
			input = Files.newInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String studentName = null;
			String s = "placeholder";
			int n = 1;
			double GPA;
			while (s != null) {
				studentName = reader.readLine(); // assigns next line to studentName
				s = reader.readLine(); // reads next line and assigns to 's'
				int begin = s.indexOf(":"); // locates character before the grade
				int end = s.indexOf(";"); // locates character after the grade
				String gradeS = s.substring(begin + 1, end); // assigns grade to gradeS
				double gradeD = Double.parseDouble(gradeS); // converts string to double
				gradeD = convertTo4Point(gradeD);
				double gradePoints = gradeD; // assigns first grade to GradePoints
				s = reader.readLine(); // reads next line and assigns to 's'
				n = 1;
				while (s != null && s.indexOf("-") == -1) // loop will run if line doesn't have a dash and isn't blank
				{
					n = n + 1; // tracks number of courses that have been included in gradePoints
					begin = s.indexOf(":"); // begin & end redefined for current line
					end = s.indexOf(";");
					gradeS = s.substring(begin + 1, end); // finds the grade in current line
					gradeD = Double.parseDouble(gradeS); // convert grade string to double
					gradeD = convertTo4Point(gradeD); // converts to 4 point scale
					gradePoints = gradePoints + gradeD; // add current line to sum of gradePoints
					s = reader.readLine(); // read next line and restart loop
				}
				GPA = gradePoints / n; // calculates GPA
				System.out.println(studentName + "'s current GPA is " + GPA);
			}
			input.close();
		} catch (IOException e) {
			System.out.println(e);

		}
	}

	public static double convertTo4Point(double points) {
		double grade;
		if (points >= 94 && points <= 100) {
			grade = 4.0;
		} else if (points >= 90 && points < 93.99) {
			grade = 3.7;
		} else if (points >= 87 && points < 89.99) {
			grade = 3.3;
		} else if (points >= 84 && points < 86.99) {
			grade = 3.0;
		} else if (points >= 80 && points < 83.99) {
			grade = 2.7;
		} else if (points >= 77 && points < 79.99) {
			grade = 2.3;
		} else if (points >= 74 && points < 76.99) {
			grade = 2;
		} else if (points >= 70 && points < 73.99) {
			grade = 1.7;
		} else if (points >= 67 && points < 69.99) {
			grade = 1.3;
		} else if (points >= 64 && points < 66.99) {
			grade = 1.0;
		} else if (points >= 60 && points < 63.99) {
			grade = 0.7;
		} else if (points < 60) {
			grade = 0.0;
		} else {
			grade = 1000;
		}
		return grade;
	}

}

