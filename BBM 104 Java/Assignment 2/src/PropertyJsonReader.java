import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PropertyJsonReader  {
     public  PropertyJsonReader(Map[] mapList){
         JSONParser processor = new JSONParser();
         try (Reader file = new FileReader("property.json")){

             JSONObject jsonfile = (JSONObject) processor.parse(file);

             JSONArray Land = (JSONArray) jsonfile.get("1");
             JSONArray RailRoad = (JSONArray) jsonfile.get("2");
             JSONArray Company = (JSONArray) jsonfile.get("3");

             for(Object i:Land) {

                 mapList[Integer.parseInt((String) ((JSONObject) i).get("id"))] = new Land(

                         Integer.parseInt((String) ((JSONObject) i).get("id")),
                         Integer.parseInt((String) ((JSONObject) i).get("cost")),
                         (String) ((JSONObject) i).get("name"),
                         "Land",
                         "Property");
             }
             for(Object i:RailRoad){

                 mapList[Integer.parseInt((String) ((JSONObject) i).get("id"))] = new RailRoads(

                         Integer.parseInt((String) ((JSONObject) i).get("id")),
                         Integer.parseInt((String) ((JSONObject) i).get("cost")),
                         (String) ((JSONObject) i).get("name") ,
                         "RailRoad",
                         "Property");
             }
             for(Object i:Company){

                 mapList[Integer.parseInt((String) ((JSONObject) i).get("id"))] = new Company(

                         Integer.parseInt((String) ((JSONObject) i).get("id")),
                         Integer.parseInt((String) ((JSONObject) i).get("cost")),
                         (String) ((JSONObject) i).get("name"),
                         "Company" ,
                         "Property");
             }

         } catch (IOException | ParseException e){
             e.printStackTrace();
         }
     }
}