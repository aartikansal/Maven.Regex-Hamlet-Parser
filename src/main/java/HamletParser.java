import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private Pattern pattern;
    private Matcher matcher;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


public Integer countHamlet(String hamletText){
    pattern = Pattern.compile("(?i)Hamlet");
    matcher = pattern.matcher(hamletText);
    Integer count=0;
    while (matcher.find()){
        count++;
    }
    return count;
}
public Integer countHoratio(String horatioText){
    pattern = Pattern.compile("(?i)Horatio");
    matcher = pattern.matcher(horatioText);
    Integer count=0;
    while(matcher.find()){
        count++;
    }
    return count;
}

public String changeHamlet(String newName){
        String result= hamletData.replaceAll("(?i)Hamlet", newName);
        return result;
                
    }
    public String changeHoratio(String newName){
        String result = hamletData.replaceAll("(?i)Horatio", newName);
        return result;
    }
}