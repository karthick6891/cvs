package wordtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
	public static void main(String[] args) throws FileNotFoundException {

		File file1 = new File("C:/training/search_parameter.txt");
		Scanner in1 = new Scanner(file1);
		int counter=0;
		while (in1.hasNextLine()) {
			String word = in1.nextLine();
			System.out.println("The parameter is:" + word);
			File dir = new File("C:/training/Search");
			File[] fname = dir.listFiles();
			counter++;

			if (!word.equals(null)) {

				try {

					for (int i = 0; i < fname.length; i++) {

						String fileName = fname[i].getName();
						System.out
								.println("file name.............................."
										+ fileName);

						FileInputStream fstream = new FileInputStream(fname[i]);
						DataInputStream in = new DataInputStream(fstream);
						BufferedReader freader = new BufferedReader(
								new InputStreamReader(in));

						ArrayList<Integer> column = new ArrayList<Integer>();

						int lineNumber = 0;
						String s1 = null;

						while ((s1 = freader.readLine()) != null)

						{
							System.out.println("s1 val.... " + s1);

							try {
								String p = word;
								System.out.println("pattern ...." + p);

								Pattern pat = Pattern.compile(p);
								Matcher mat = pat.matcher(s1);
								boolean b = mat.matches();

								Pattern pat1 = Pattern.compile(word + ".+?");
								Matcher mat1 = pat1.matcher(s1);
								boolean c = mat1.matches();

								lineNumber++;
								if (b == true) {

									System.out.println("value of b   :" + b);
									System.out.println(" line no in b  "
											+ lineNumber);
									column.add(lineNumber);

								}

								if (c == true) {

									System.out.println("value of c   :" + c);
									System.out.println(" line no  in c "
											+ lineNumber);
									column.add(lineNumber);

								}

							} catch (Exception e) {
								System.out.println(" in excp...  " + e);
							}
						}

						for (Integer arr : column)

						{

							System.out.println("the pattern "
									+ " matches with : " + fileName
									+ " line no." + arr.intValue());

							String result = "parameter"+counter;
							System.out.println("The target file name is: "+ result);

							File file = new File("C:/training/" + result
									+ ".txt");

							FileWriter fstream1 = new FileWriter(file, true);

							BufferedWriter out = new BufferedWriter(fstream1);

							out.write("the pattern " + " matches with : "
									+ fileName + " and the column no."
									+ arr.intValue());
							out.newLine();
							out.close();

						}

					}

				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

	}

}
