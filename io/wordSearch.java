package io;

import java.io.BufferedReader;
import java.io.FileReader;

public class wordSearch {

	public static void main(String[] args) throws Exception 
	{ 
		//Read file and return 2 separate strings that contain both the words and the word search
		String[] batch = inputToString("input.txt"); 
		String data = batch[1];
		String firstLine = batch[0];
		//Converts the firstLine string into individual words in an array
		String[] words = firstLine.split("\\W+");

		//Create 2d Char array
		char[][] boardArray = new char[15][15];
		int next = 0;
		//finds the square root of the total letters of the input
		double maxRow = 0;
		maxRow = Math.sqrt(data.length());
		//Add each char to array using the square root as the limit
		for (int i=0; i < maxRow ; i++) {
			for (int j=0; j < maxRow; j++) {
				boardArray[i][j] = data.charAt(next++);
			}
		}
		int amount = words.length;
		for (int i=0; i < amount; i++) {
			//Prints out and chooses the word that will be searched for
			String word = words[i];
			System.out.println(word);
			boolean wordFound = false;
			int size = boardArray[0].length;
			//Runs through the char array and finds the matching first letter
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					if (wordFound == false && boardArray[row][column] == word.charAt(0)) {
						wordFound = wordFind(word, row, column, boardArray);
					}
				}
			}
			if (wordFound == false)
				System.out.println(word + " Word doesnt exist.");
		}
	}

	public static boolean wordFind(String word, int x, int y, char[][] boardArray) { 
		boolean check = false;
		int wordSize = word.length();

		//Words to the left
		if ((y - wordSize) >= -1) {
			int counter = 0;
			String[] temp = new String[word.length()];
			for (int i = y; i >= (y - wordSize) + 1; i--) {
				//Saves position of letter to temp array
				temp[counter] = word.charAt(counter) + ": (" + x +","+ i + ") ";
				if (word.charAt(counter) != boardArray[x][i]) {
					break;
				}
				//If the size of the word is matched
				if (i == (y - wordSize) + 1) {
					check = true;

					//Print the word coordinates
					for(int z=0;z<=word.length();z++) {
						System.out.print(temp[z]);
						if(z == word.length()-1) {
							System.out.println();
							break;
						}
					}
				}
				counter++;
			}
		}

		//Words to the right
		if ((y + wordSize) <= boardArray[0].length) { 
			int counter = 0;
			String[] temp = new String[word.length()];
			for (int i = y; i <= (y + wordSize) - 1; i++) {
				//Saves position of letter to temp array
				temp[counter] = word.charAt(counter) + ": (" + x +","+ i + ") ";
				if (word.charAt(counter) != boardArray[x][i]) {
					break;
				}
				//If the size of the word is matched
				if (i == (y + wordSize) - 1) { 
					check = true;

					//Print the word coordinates
					for(int z=0;z<=word.length();z++) {
						System.out.print(temp[z]);
						if(z == word.length()-1) {
							System.out.println();
							break;
						}
					}
				}
				counter++;
			}
		}

		//Words going up
		if ((x - wordSize) >= -1) {
			int counter = 0;
			String[] temp = new String[word.length()];
			for (int i = x; i >= (x - wordSize) + 1; i--) {
				//Saves position of letter to temp array
				temp[counter] = word.charAt(counter) + ": (" + i +","+ y + ") ";
				if (word.charAt(counter) != boardArray[i][y]) {
					break;
				}
				//If the size of the word is matched
				if (i == (x - wordSize) + 1) {
					check = true;

					//Print the word coordinates
					for(int z=0;z<=word.length();z++) {
						System.out.print(temp[z]);
						if(z == word.length()-1) {
							System.out.println();
							break;
						}
					}
				}
				counter++;
			}
		}

		//Words going down
		if ((x + wordSize) <= boardArray[0].length) {
			int counter = 0;
			String[] temp = new String[word.length()];
			for (int i = x; i <= (x + wordSize) - 1; i++) {
				//Saves position of letter to temp array
				temp[counter] = word.charAt(counter) + ": (" + i +","+ y + ") ";
				if (word.charAt(counter) != boardArray[i][y]) {
					break;
				}
				//If the size of the word is matched
				if (i == (x + wordSize) - 1) {
					check = true;

					//Print the word coordinates
					for(int z=0;z<=word.length();z++) {
						System.out.print(temp[z]);
						if(z == word.length()-1) {
							System.out.println();
							break;
						}
					}
				}
				counter++;
			}
		}

		//Top left words
		if ((x - wordSize) >= -1 && (y - wordSize) >= -1) {
			int counter = 0;
			int j = y;
			String[] temp = new String[word.length()];
			for (int i = x; i >= (x - wordSize) + 1; i--) {
				//Saves position of letter to temp array
				temp[counter] = word.charAt(counter) + ": (" + i +","+ j + ") ";
				if (word.charAt(counter) != boardArray[i][j]) {
					break;
				}
				//If the size of the word is matched
				if (i == (x - wordSize) + 1) {
					check = true;

					//Print the word coordinates
					for(int z=0;z<=word.length();z++) {
						System.out.print(temp[z]);
						if(z == word.length()-1) {
							System.out.println();
							break;
						}
					}
				}
				counter++;
				j--;
			}
		}

		//Top right words
		if ((x - wordSize) >= -1 && (y + wordSize) <= boardArray[0].length) {
			int wordPos = 0;
			int j = y;
			String[] temp = new String[word.length()];
			for (int i = x; i >= (x - wordSize) + 1; i--) {
				//Saves position of letter to temp array
				temp[wordPos] = word.charAt(wordPos) + ": (" + i +","+ j + ") ";
				if (word.charAt(wordPos) != boardArray[i][j]) {
					break;
				}
				//If the size of the word is matched
				if (i == (x - wordSize) + 1) {
					check = true;

					//Print the word coordinates
					for(int z=0;z<=word.length();z++) {
						System.out.print(temp[z]);
						if(z == word.length()-1) {
							System.out.println();
							break;
						}
					}
				}
				wordPos++;
				j++;
			}
		}

		//Bottom left words
		if ((x + wordSize) <= boardArray[0].length && (y - wordSize) >= -1) {
			int counter = 0;
			int j = y;
			String[] temp = new String[word.length()];
			for (int i = x; i <= (x + wordSize) - 1; i++) {
				//Saves position of letter to temp array
				temp[counter] = word.charAt(counter) + ": (" + i +","+ j + ") ";
				if (word.charAt(counter) != boardArray[i][j]) {
					break;
				}
				//If the size of the word is matched
				if (i == (x + wordSize) - 1) {
					check = true;

					//Print the word coordinates
					for(int z=0;z<=word.length();z++) {
						System.out.print(temp[z]);
						if(z == word.length()-1) {
							System.out.println();
							break;
						}
					}
				}
				counter++;
				j--;
			}
		}

		//Bottom right words
		if ((x + wordSize) <= boardArray[0].length && (y + wordSize) <= boardArray[0].length) {
			int counter = 0;
			int j = y;
			String[] temp = new String[word.length()];
			for (int i = x; i <= (x + wordSize) - 1; i++) {
				//Saves position of letter to temp array
				temp[counter] = word.charAt(counter) + ": (" + i +","+ j + ") ";
				if (word.charAt(counter) != boardArray[i][j]) {
					break;
				}
				//If the size of the word is matched
				if (i == (x + wordSize) - 1) {
					check = true;

					//Print the word coordinates
					for(int z=0;z<=word.length();z++) {
						System.out.print(temp[z]);
						if(z == word.length()-1) {
							System.out.println();
							break;
						}
					}
				}
				counter++;
				j++;
			}
		}
		return check;
	}


	public static String[] inputToString(String fileName)throws Exception 
	{ 
		//Initializes the buffered reader
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		//Reads the first line of the input file so it isnt included in the string
		String firstLine = reader.readLine(); 
		//Initialize the variables needed to read in the file
		String skipLine = null;
		String line = null;
		String data = null;
		StringBuffer stbuffer = new StringBuffer();

		//Skips first line
		while ((skipLine = reader.readLine()) != null){ 
			//Reads in text line by line
			while((line = reader.readLine())!=null){
				stbuffer.append(line).append("\n");

			}
			//Sets the appended string to a string variable
			data = stbuffer.toString();
		}
		System.out.println("Words to find: " + firstLine);

		//Prints out initial Word search as preview
		System.out.println("\nCurrent Wordsearch:");
		System.out.println(data + "\n"); 
		//Remove all commas from string
		data = data.replace(",", "");
		//Remove all line breaks from string
		data = data.replace("\n", "").replace("\r", "");

		//Return String
		//Create String array to contain both firstLine and data 
		String batch[] = new String[2];
		batch[0] = firstLine;
		batch[1] = data;
		//Return both firstLine and data
		return batch;
	} 
}