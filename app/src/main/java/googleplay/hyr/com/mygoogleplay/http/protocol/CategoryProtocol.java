package googleplay.hyr.com.mygoogleplay.http.protocol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.pojo.CategoryInfo;

/**
 * Created by huangyueran on 2017/1/19.
 * 分类网络数据解析
 */
public class CategoryProtocol extends BaseProtocol<ArrayList<CategoryInfo>> {

    @Override
    public String getKey() {
        return "category";
    }

    @Override
    public String getParams() {
        return "";
    }

    @Override
    public ArrayList<CategoryInfo> parseData(String result) {
        try {
            JSONArray jsonArray = new JSONArray(result);
            ArrayList<CategoryInfo> list = new ArrayList<CategoryInfo>();

            for (int i = 0; i < jsonArray.length(); i++) {// 遍历大分类, 2次
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // 初始化标题对象
                if (jsonObject.has("title")) {// 判断是否有title这个字段
                    CategoryInfo titleInfo = new CategoryInfo();
                    titleInfo.setTitle(jsonObject.getString("title"));
                    titleInfo.setTitle(true);
                    list.add(titleInfo);
                }

                // 初始化分类对象
                if (jsonObject.has("infos")) {
                    JSONArray ja1 = jsonObject.getJSONArray("infos");

                    for (int j = 0; j < ja1.length(); j++) {// 遍历小分类
                        JSONObject jo1 = ja1.getJSONObject(j);
                        CategoryInfo info = new CategoryInfo();
                        info.setName1(jo1.getString("name1"));
                        info.setName2(jo1.getString("name2"));
                        info.setName3(jo1.getString("name3"));
                        info.setUrl1(jo1.getString("url1"));
                        info.setUrl2(jo1.getString("url2"));
                        info.setUrl3(jo1.getString("url3"));
                        info.setTitle(false);

                        list.add(info);
                    }
                }
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
