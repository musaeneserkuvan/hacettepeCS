import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ListJsonReader {

    public ListJsonReader(Chance chanceFunc, CommunityChest chestFunc) {
        JSONParser processor = new JSONParser();

        try (Reader file = new FileReader("list.json")) {

            JSONObject jsonfile = (JSONObject) processor.parse(file);

            JSONArray chanceList = (JSONArray) jsonfile.get("chanceList");
            JSONArray communityChestList = (JSONArray) jsonfile.get("communityChestList");

            chanceFunc.setChanceList("Null");
            chestFunc.setCommunityChestList("Null");

            for (Object i : chanceList) {
                chanceFunc.setChanceList((String) ((JSONObject) i).get("item"));
            }

            for (Object i : communityChestList) {
                chestFunc.setCommunityChestList((String) ((JSONObject) i).get("item"));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

