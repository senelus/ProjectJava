import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.users.Fields;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public abstract  class VkHumanParser {
    public static ArrayList<HashMap<String,String>> humanDataParse() throws Exception {
        var client = HttpTransportClient.getInstance();
        var vkApi = new VkApiClient(client);
        var actor = new UserActor(159659472, "37f932bd44ce13ec7a0cea7785a56fe8b8dc386de013ca4a353650dddb111010be89c4fe251c13b2e57f6");
        var fields = new Fields[] { Fields.PERSONAL, Fields.PHOTO_MAX_ORIG, Fields.ABOUT, Fields.ABOUT, Fields.BDATE, Fields.CITY, Fields.CONTACTS };
        var jsonString = vkApi.groups().getMembers(actor).groupId("198188261").count(1000).offset(0).fields(fields).executeAsString();
        var json = new JSONObject(jsonString).getJSONObject("response").getJSONArray("items");
        var data = new ArrayList<HashMap<String,String>>();
        for (var i = 0; i < json.length(); i++) {
            var humanData = new HashMap<String,String>();
            humanData.put("name",json.getJSONObject(i).getString("first_name"));
            humanData.put("surname",json.getJSONObject(i).getString("last_name"));
            humanData.put("id",String.valueOf(json.getJSONObject(i).getInt("id")));
            //humanData.put("birthday", json.getJSONObject(i).getString("bdate"));
            //humanData.put("status", json.getJSONObject(i).getString("about"));
            data.add(humanData);
        }
        return data;
    }
}
