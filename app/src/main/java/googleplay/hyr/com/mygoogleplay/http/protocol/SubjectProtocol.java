package googleplay.hyr.com.mygoogleplay.http.protocol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.pojo.SubjectInfo;

/**
 * 专题网络数据解析
 * Created by huangyueran on 2017/1/17.
 */
public class SubjectProtocol extends BaseProtocol<ArrayList<SubjectInfo>> {

    @Override
    public String getKey() {
        return "subject";
    }

    @Override
    public String getParams() {
        return "";
    }

    @Override
    public ArrayList<SubjectInfo> parseData(String result) {
        try {
            JSONArray jsonArray = new JSONArray(result);

            ArrayList<SubjectInfo> list = new ArrayList<SubjectInfo>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                SubjectInfo info = new SubjectInfo();
                info.des = jsonObject.getString("des");
                info.url = jsonObject.getString("url");

                list.add(info);
            }

            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
