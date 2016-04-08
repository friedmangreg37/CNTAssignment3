import java.io.*;
import java.nio.*;
import java.util.*;

public class linkstate {
	public static void main(String args[]) throws Exception {
		if(args.length < 1) {
            //requires the user to supply the filename at runtime
            throw new Exception("Please supply the text filename");
        }
        //get the filename:
        String filename = args[0];
        //reader to get the input from the text file:
        BufferedReader inFromFile = new BufferedReader(new FileReader(filename));
        //create ArrayList of strings to hold all of the lines of input:
        ArrayList<String> lineStrings = new ArrayList<String>();
        //temp variable to hold each reading:
        String line = inFromFile.readLine();
        //continue until you reach the end of file delimiter:
        while(!line.equals("EOF.")) {
        	System.out.println(line);
        	//append the string to the list of them:
        	lineStrings.add(line);
        	//get the next line:
        	line = inFromFile.readLine();
        }

        //get the number of nodes in the network:
        int numberNodes = lineStrings.size();
        int[][] nodeMatrix = new int[numberNodes][numberNodes];

        //fill the node matrix:
        for(int i = 0; i < numberNodes; i++) {
        	//get array of the weights in each line:
        	String[] splitLine = lineStrings.get(i).split(",");
        	//remove period from the end of the last number string:
        	String lastNumber = splitLine[splitLine.length-1];
        	splitLine[splitLine.length-1] = lastNumber.substring(0,lastNumber.length()-1);
        	//convert each string to integer and put in the matrix:
        	for(int j = 0; j < numberNodes; j++) {
        		//if 'N', then set weight to infinity (max integer value):
        		if(splitLine[j].equals("N")) {
        			nodeMatrix[i][j] = Integer.MAX_VALUE;
        		}
        		//otherwise, convert it to an int and set weight to this:
        		else {
	        		nodeMatrix[i][j] = Integer.parseInt(splitLine[j]);
	        	}
        	}
        }

        /* FOR DEBUGGING PURPOSES:
        for(int i = 0; i < numberNodes; i++) {
        	for(int j = 0; j < numberNodes; j++) {
        		System.out.println(nodeMatrix[i][j]);
        	}
        	System.out.println();
        }
		*/
	}
}