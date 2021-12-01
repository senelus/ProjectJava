import com.google.gson.Gson;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class VkHumanParser {
    private static String token;
    private static String APIversion;
    private static String groupId;
    private static int humansCount;
    private ArrayList<Human> humans;

    public ArrayList<Human> getHumans() { return humans; }

    public VkHumanParser(String token, String APIversion, String groupId) {
        this.token = token;
        this.APIversion = APIversion;
        this.groupId = groupId;
        this.humans = new ArrayList<Human>();
    }

    public void createHumansData() {
        try {
            ArrayList<Human> partOfHumansArray = new ArrayList<>();
            Document doc = null;
            for (int offsetNow = 0; offsetNow <= humansCount;) {
                var url = "https://api.vk.com/method/groups.getMembers";
                var humanData = new HashMap<String, String>();
                humanData.put("access_token", token);
                humanData.put("offset", String.valueOf(offsetNow));
                humanData.put("group_id", groupId);
                humanData.put("count", "1000");
                humanData.put("v", APIversion);
                humanData.put("fields","sex, bdate, city, country, photo_max_orig, site, education, contacts");
                doc = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").ignoreContentType(true).data(humanData).post();
                humansCount = new JSONObject(doc.text()).getJSONObject("response").getInt("count");
                var gson = new Gson();
                var json = new JSONObject(doc.text());
                var response = json.getJSONObject("response");
                var items = response.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    var item = items.getJSONObject(i);
                    var human = gson.fromJson(item.toString(), Human.class);
                    partOfHumansArray.add(human);
                }
                if (partOfHumansArray.size() == 0)
                    break;
                offsetNow += partOfHumansArray.size();
                humans.addAll(partOfHumansArray);
                partOfHumansArray.clear();
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}