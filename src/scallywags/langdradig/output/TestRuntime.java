package scallywags.langdradig.output;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestRuntime {

	public static void main(String[] args) throws IOException {
		List<String> result = new ArrayList<>();
		

		ProcessBuilder pBuilder = new ProcessBuilder("runhaskell", "RuntimeTest.hs").directory(new File("src/scallywags/langdradig/output"));

		Process process = pBuilder.start();

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		String s = null;
		while ((s = stdInput.readLine()) != null) {
			result.add(s);
		}

		while ((s = stdError.readLine()) != null) {
			result.add(s);
		}
		
		result.forEach(System.out::println);

	}

}
