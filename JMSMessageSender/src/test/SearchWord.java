package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchWord {
	public static void main(String[] args) throws FileNotFoundException {

		File file1 = new File("C:/training/search_parameter.txt");
		Scanner in1 = new Scanner(file1);
		int parametercounter = 0;
		while (in1.hasNextLine()) {

			String word = in1.nextLine();
			System.out.println("The parameter is:" + word);
			File dir = new File("C:/training/Search");
			File[] fname = dir.listFiles();
			parametercounter++;

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

						ArrayList<Integer> lineno = new ArrayList<Integer>();

						int lineNumber = 0;
						String linefromfile = null;

						while ((linefromfile = freader.readLine()) != null)

						{

							boolean findmatch = false;
							System.out.println("linefromfile val.... "
									+ linefromfile);

							try {
								String p = word;
								System.out.println("pattern ...." + p);

								Pattern pat = Pattern.compile(p);
								Matcher mat = pat.matcher(linefromfile);
								findmatch = mat.find();

								lineNumber++;

								if (findmatch == true) {

									System.out.println("value of findmatch   :"
											+ findmatch);
									System.out
											.println(" line no in findmatch  "
													+ lineNumber);
									lineno.add(lineNumber);

								}

							} catch (Exception e) {
								System.out.println(" in excp...  " + e);
							}
						}

						for (Integer arr : lineno)

						{

							System.out.println("the pattern "
									+ " matches with : " + fileName
									+ " line no." + arr.intValue());

							String outputfilename = "parameter"
									+ parametercounter;
							System.out.println("The target file name is: "
									+ outputfilename);

							File file = new File("C:/training/"
									+ outputfilename + ".txt");

							FileWriter fstream1 = new FileWriter(file, true);

							BufferedWriter out = new BufferedWriter(fstream1);

							out.write("the word " + word + " matches with : "
									+ fileName + " and the line no."
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
