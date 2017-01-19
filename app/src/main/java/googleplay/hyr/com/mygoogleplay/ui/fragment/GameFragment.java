package googleplay.hyr.com.mygoogleplay.ui.fragment;

import android.view.View;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.http.protocol.GameProtocol;
import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;
import googleplay.hyr.com.mygoogleplay.ui.adapter.MyBaseAdapter;
import googleplay.hyr.com.mygoogleplay.ui.holder.BaseHolder;
import googleplay.hyr.com.mygoogleplay.ui.holder.GameHolder;
import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.ui.view.MyListView;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/13.
 * 游戏Fragment
 */
public class GameFragment extends BaseFragment {

    private ArrayList<AppInfo> data; // 网络请求的游戏数据

    @Override
    public View onCreateSuccessView() {
        MyListView myListView = new MyListView(UIUtils.getContext());
        myListView.setAdapter(new GameAdapter(data));
        return myListView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        GameProtocol protocol = new GameProtocol();
        data = protocol.getData(0);

        return check(data);
    }

    /**
     * 游戏ListView的Adapter
     */
    class GameAdapter extends MyBaseAdapter<AppInfo> {

        public GameAdapter(ArrayList<AppInfo> data) {
            super(data);
        }

        @Override
        public BaseHolder<AppInfo> getHolder(int position) {
            return new GameHolder();
        }

        @Override
        public ArrayList<AppInfo> onLoadMore() {
            GameProtocol protocol = new GameProtocol();
            ArrayList<AppInfo> moreData = protocol.getData(getListSize());
            return moreData;
        }
    }
}
