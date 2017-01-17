package googleplay.hyr.com.mygoogleplay.http.protocol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;

/**
 * 应用网络数据解析
 * Created by huangyueran on 2017/1/17.
 */
public class AppProtocol extends BaseProtocol<ArrayList<AppInfo>> {

    @Override
    public String getKey() {
        return "app";
    }

    @Override
    public String getParams() {
        return "";
    }

    @Override
    public ArrayList<AppInfo> parseData(String result) {
        try {
            JSONArray jsonArray = new JSONArray(result);
            ArrayList<AppInfo> appInfoList = new ArrayList<AppInfo>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                AppInfo info = new AppInfo();
                info.des = jsonObject.getString("des");
                info.downloadUrl = jsonObject.getString("downloadUrl");
                info.iconUrl = jsonObject.getString("iconUrl");
                info.id = jsonObject.getString("id");
                info.name = jsonObject.getString("name");
                info.packageName = jsonObject.getString("packageName");
                info.size = jsonObject.getLong("size");
                info.stars = (float) jsonObject.getDouble("stars");

                appInfoList.add(info);
            }

            return appInfoList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
