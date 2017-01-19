package googleplay.hyr.com.mygoogleplay.ui.fragment;

import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.http.protocol.AppProtocol;
import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;
import googleplay.hyr.com.mygoogleplay.ui.adapter.MyBaseAdapter;
import googleplay.hyr.com.mygoogleplay.ui.holder.AppHolder;
import googleplay.hyr.com.mygoogleplay.ui.holder.BaseHolder;
import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.ui.view.MyListView;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/13.
 * 应用Fragment
 */
public class AppFragment extends BaseFragment {

    private ArrayList<AppInfo> data; // 加载到的网络数据

    @Override
    public View onCreateSuccessView() {
        ListView listView = new MyListView(UIUtils.getContext());
        listView.setAdapter(new AppAdapter(data));
        return listView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        // 请求网络
        AppProtocol protocol = new AppProtocol();
        data = protocol.getData(0);// 加载第一页数据

        return check(data); // 校验数据并返回状态
    }

    class AppAdapter extends MyBaseAdapter<AppInfo> {

        public AppAdapter(ArrayList<AppInfo> data) {
            super(data);
        }

        @Override
        public BaseHolder<AppInfo> getHolder(int position) {
            return new AppHolder();
        }

        @Override
        public ArrayList<AppInfo> onLoadMore() {
            AppProtocol protocol = new AppProtocol();
            ArrayList<AppInfo> moreData = protocol.getData(getListSize());
            return moreData;
        }
    }
}
