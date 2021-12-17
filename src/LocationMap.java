import java.util.*;
import java.io.*;


//class that behaves like a map
public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME =  "locations.txt";
    private static final String DIRECTIONS_FILE_NAME =  "directions.txt";

    /** TODO
     * create a static locations HashMap
     */ static HashMap<Integer,Location> locations = new HashMap<>();
    static {
        /** TODO
         * create a FileLogger object
         */
        FileLogger fileLogger = new FileLogger();

        /** TODO
         * create a ConsoleLogger object
         */
        ConsoleLogger consoleLogger = new ConsoleLogger();

        /** TODO
         * Read from LOCATIONS_FILE_NAME so that a user can navigate from one location to another
         * use try-with-resources/catch block for the FileReader
         * extract the location and the description on each line
         * print all locations and descriptions to both console and file
         * check the ExpectedOutput files
         * put the location and a new Location object in the locations HashMap, using temporary empty hashmaps for exits
         */
        ArrayList<Location> arr = new ArrayList<Location>();
        try(FileReader fileReader = new FileReader(LOCATIONS_FILE_NAME);) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            fileLogger.log("Available locations:");
            consoleLogger.log("Available locations:");
            while((line = bufferedReader.readLine()) != null)
            {
                String[] location = line.split(",",2);
                fileLogger.log(location[0]+": "+location[1]);
                consoleLogger.log(location[0]+": "+location[1]);
                Location location2 = new Location(Integer.parseInt(location[0]),location[1],new HashMap<>());
                arr.add(location2);
                locations.put(Integer.parseInt(location[0]),location2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**TODO
         * Read from DIRECTIONS_FILE_NAME so that a user can move from A to B, i.e. current location to next location
         * use try-with-resources/catch block for the FileReader
         * extract the 3 elements  on each line: location, direction, destination
         * print all locations, directions and destinations to both console and file
         * check the ExpectedOutput files
         * add the exits for each location
         */
        try(FileReader fr = new FileReader(DIRECTIONS_FILE_NAME);)
        {
            BufferedReader br = new BufferedReader(fr);
            String line1;
            fileLogger.log("Available directions:");
            consoleLogger.log("Available directions:");
            while((line1 = br.readLine()) != null)
            {
                String[] location1 = line1.split(",",3);
                (arr.get(Integer.parseInt(location1[0]))).addExit(location1[1],Integer.parseInt(location1[2]));
                fileLogger.log(location1[0]+": "+location1[1]+": "+location1[2]);
                consoleLogger.log(location1[0]+": "+location1[1]+": "+location1[2]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**TODO
     * implement all methods for Map
     * @return
     */
    @Override
    public int size() {
        //TODO
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        //TODO
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //TODO
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        //TODO
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        //TODO
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        //TODO
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        //TODO
        locations.putAll(m);
    }

    @Override
    public void clear() {
        //TODO
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        //TODO
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        //TODO
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        //TODO
        return locations.entrySet();
    }
}
