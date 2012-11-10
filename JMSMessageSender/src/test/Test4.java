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

public class Test4 {
	public static void main(String[] args) throws FileNotFoundException {

		int counter=0;
		File file1 = new File("C:/training/replace_parameter.txt");
		Scanner in1 = new Scanner(file1);
		String[] temp;
		String originalWord=null;
		String replacedWord=null;
		
		while (in1.hasNextLine()) {
			String word = in1.nextLine();
			System.out.println("The parameter is:" + word);
			File dir = new File("C:/training/Search");
			File[] fname = dir.listFiles();
			
			counter++;
			int indexOfCharacter1=-1;
			
			String delimiter = "/";
			if((indexOfCharacter1=word.indexOf('/'))!=-1){
				
				temp = word.split(delimiter);
				for(int i =0; i < 1 ; i++){
				    System.out.println("1st element"+temp[0]);
				    originalWord=temp[0];
				    System.out.println("2nd element"+temp[1]);
				    replacedWord=temp[1];
					}
				
			}
			

			if (!word.equals(null)) {

				try {

					for (int i = 0; i < fname.length; i++) {
						String fileName = fname[i].getName();
						System.out.println("file name.............................."
										+ fileName);

						FileInputStream fstream = new FileInputStream(fname[i]);
						DataInputStream in = new DataInputStream(fstream);
						BufferedReader freader = new BufferedReader(
								new InputStreamReader(in));

						ArrayList<Integer> column = new ArrayList<Integer>();

						int lineNumber = 0;
						String s1 = null;
						StringBuilder sb = new StringBuilder();
						while ((s1 = freader.readLine()) != null)

						{
							System.out.println("s1 val.... " + s1);
							
							sb.append(s1);
							sb.append(System.getProperty("line.separator"));

							try {
								String p = originalWord;
								System.out.println("pattern ...." + p);

								Pattern pat = Pattern.compile(p);
								Matcher mat = pat.matcher(s1);
								boolean b = mat.matches();


								lineNumber++;
								if (b == true) {

									String str=replacedWord;
									
									System.out.println("value of b   :" + b);
									System.out.println(" line no in b  "+ lineNumber);
									column.add(lineNumber);

									System.out.println("value of sb........"+ sb.toString());
									
									int start = -1;
									while ((start = sb.indexOf(originalWord)) > -1) 
									{
										System.out.println("start value"+ start);
										
										int end = start + originalWord.length();
										System.out.println("end value" + end);
										
										sb.replace(start, end, str);
										
									}

								}


							} catch (Exception e) {
								System.out.println(" in excp...  " + e);
							}
						}
						
						FileWriter file2 = new FileWriter(fname[i]);
						BufferedWriter file3 = new BufferedWriter(file2);
						file3.write(sb.toString());
						file3.close();

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
