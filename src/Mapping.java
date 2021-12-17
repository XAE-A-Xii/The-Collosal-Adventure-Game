import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;

    /** TODO
     * create a static LocationMap object
     */
    static LocationMap map = new LocationMap();

    /** TODO
     * create a vocabulary HashMap to store all directions a user can go
     */
    HashMap<String, String> vocabulary = new HashMap<String, String>();

    /** TODO
     * create a FileLogger object
     */
    FileLogger fileLogger = new FileLogger();

    /** TODO
     * create a ConsoleLogger object
     */
    ConsoleLogger consoleLogger = new ConsoleLogger();


    public Mapping() {
        //vocabulary.put("QUIT", "Q"); //example
        /** TODO
         * complete the vocabulary HashMap <Key, Value> with all directions.
         * use the directions.txt file and crosscheck with the ExpectedInput and ExpectedOutput files to find the keys and the values
         */
        vocabulary.put("QUIT", "Q");
        vocabulary.put("UP", "U");
        vocabulary.put("DOWN", "D");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTHWEST", "SW");
        vocabulary.put("SOUTHEAST", "SE");
        vocabulary.put("NORTHWEST", "NW");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("NORTHEAST", "NE");
        vocabulary.put("Q", "Q");
        vocabulary.put("U", "U");
        vocabulary.put("D", "D");
        vocabulary.put("S", "S");
        vocabulary.put("N", "N");
        vocabulary.put("SW", "SW");
        vocabulary.put("SE", "SE");
        vocabulary.put("NE", "NE");
        vocabulary.put("W", "W");
        vocabulary.put("E", "E");
        vocabulary.put("NW", "NW");
    }

    public void mapping() {

        /** TODO
         * create a Scanner object
         */
        Scanner keyboard = new Scanner(System.in);

        /**
         * initialise a location variable with the INITIAL_LOCATION
         */
        int location = INITIAL_LOCATION;

        while (true) {

            /** TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
             map.get(location);
            fileLogger.log(map.get(location).getDescription());
            consoleLogger.log(map.get(location).getDescription());


            /** TODO
             * verify if the location is exit
             */if(location == 0)
            {
                return;
            }


            /** TODO
             * get a map of the exits for the location
             */
            Map<String,Integer> map1 = map.get(location).getExits();

            /** TODO
             * print the available exits (to both console and file)
             * crosscheck with the ExpectedOutput files
             * Hint: you can use a StringBuilder to append the exits
             */
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Available exits are ");
            for(String s : map1 .keySet())
            {
                stringBuilder.append(s + ", ");
            }
            consoleLogger.log(stringBuilder.toString());
            fileLogger.log(stringBuilder.toString());


            /** TODO
             * input a direction
             * ensure that the input is converted to uppercase
             */
            String input;
            input = keyboard.nextLine().toUpperCase();

            /** TODO
             * are we dealing with a letter / word for the direction to go to?
             * available inputs are: a letter(the HashMap value), a word (the HashMap key), a string of words that contains the key
             * crosscheck with the ExpectedInput and ExpectedOutput files for examples of inputs
             * if the input contains multiple words, extract each word
             * find the direction to go to using the vocabulary mapping
             * if multiple viable directions are specified in the input, choose the last one
             */
            String[] input1 = input.split(" ");
            boolean isFound = false;
            for( int j = input1.length -1; j >=0 ; j--)
            {
                String direct = vocabulary.get(input1[j]);
                if(direct != null)
                {
                    Integer destin = map1.get(direct);
                    if(destin != null)
                    {
                        location = destin;
                        isFound = true;
                        break;
                    }
                }
            }
            /*for(int i = 0 ; i < input1.length ; i++) {
                for (String s : vocabulary.keySet())
                {
                    if (input1[i].equals(s)) {
                        isFound = true;
                        direction = map1.get(input1[i]);
                        location = direction;
                        break;
                    }
                }
                for (String s : vocabulary.values()) {
                    if (input1[i].equals(s)) {
                        isFound = true;
                        direction = map1.get(input1[i]);
                        location = direction;
                        break;
                    }
                }
                }
             */


                /** TODO
                 * if user can go in that direction, then set the location to that direction
                 * otherwise print an error message (to both console and file)
                 * check the ExpectedOutput files
                 */


            if(!isFound)
            {
                consoleLogger.log("You cannot go in that direction");
                fileLogger.log("You cannot go in that direction");
            }
        }
    }


    public static void main(String[] args) {
        /**TODO
         * run the program from here
         * create a Mapping object
         * start the game
         */
        Mapping mapping = new Mapping();
        mapping.mapping();
    }
}
