package googleplay.hyr.com.mygoogleplay.http.protocol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;

/**
 * 首页网络数据解析
 * Created by huangyueran on 2017/1/15.
 */
public class HomeProtocol extends BaseProtocol<ArrayList<AppInfo>> {


    private ArrayList<String> pictures;

    @Override
    public String getKey() {
        return "home";
    }

    @Override
    public String getParams() {
        return ""; //如果没有参数，就传递空字符串
    }

    @Override
    public ArrayList<AppInfo> parseData(String result) {
        //Gson,JsonObject
        try {
            JSONObject jsonObject = new JSONObject(result);

            // 解析应用列表数据
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            ArrayList<AppInfo> appInfoList = new ArrayList<AppInfo>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jo1 = jsonArray.getJSONObject(i);

                AppInfo info = new AppInfo();
                info.des = jo1.getString("des");
                info.downloadUrl = jo1.getString("downloadUrl");
                info.iconUrl = jo1.getString("iconUrl");
                info.id = jo1.getString("id");
                info.name = jo1.getString("name");
                info.packageName = jo1.getString("packageName");
                info.size = jo1.getLong("size");
                info.stars = (float) jo1.getDouble("stars");

                appInfoList.add(info);
            }

            // 初始化轮播条的数据
            JSONArray jsonArray1 = jsonObject.getJSONArray("picture");
            pictures = new ArrayList<String>();
            for (int i = 0; i < jsonArray1.length(); i++) {
                String pic = jsonArray1.getString(i);
                pictures.add(pic);
            }

            return appInfoList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 返回轮播条图片数据
     *
     * @return
     */
    public ArrayList<String> getPictureList() {
        return pictures;
    }
}
