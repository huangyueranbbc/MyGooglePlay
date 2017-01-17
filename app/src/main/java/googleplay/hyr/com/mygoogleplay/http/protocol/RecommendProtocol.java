package googleplay.hyr.com.mygoogleplay.http.protocol;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * 推荐网络数据解析
 * Created by huangyueran on 2017/1/17.
 */
public class RecommendProtocol extends BaseProtocol<ArrayList<String>> {

    @Override
    public String getKey() {
        return "recommend";
    }

    @Override
    public String getParams() {
        return "";
    }

    @Override
    public ArrayList<String> parseData(String result) {
        try {
            JSONArray jsonArray = new JSONArray(result);
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < jsonArray.length(); i++) {
                String keyword = jsonArray.getString(i);
                list.add(keyword);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
