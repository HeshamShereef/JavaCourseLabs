import java.io.*;

public class Lab1 {

	public static void main(String[] args) throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		System.out.println("Enter data: ");
		String line = "";
		FileWriter fw = new FileWriter("file0.text");
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(!line.equals("stop")) {
			line = br.readLine();
			bw.write(line + "\n");
		}
		br.close();
		bw.close();

	}

}
