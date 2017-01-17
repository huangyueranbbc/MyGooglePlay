package googleplay.hyr.com.mygoogleplay.ui.fragment;

import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.http.protocol.HomeProtocol;
import googleplay.hyr.com.mygoogleplay.pojo.AppInfo;
import googleplay.hyr.com.mygoogleplay.ui.adapter.MyBaseAdapter;
import googleplay.hyr.com.mygoogleplay.ui.holder.BaseHolder;
import googleplay.hyr.com.mygoogleplay.ui.holder.HomeHolder;
import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.ui.view.MyListView;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/13.
 * 首页Fragment
 */
public class HomeFragment extends BaseFragment {


    private ArrayList<AppInfo> data; // 加载到的网络数据

    /**
     * 如果加载数据成功，就回调此方法，在主线程中执行，可以修改界面
     *
     * @return
     */
    @Override
    public View onCreateSuccessView() {
        ListView listView = new MyListView(UIUtils.getContext());
        listView.setAdapter(new HomeAdapter(data));
        return listView;
    }

    /**
     * 运行在子线程 可以直接执行网络耗时操作
     *
     * @return
     */
    @Override
    public LoadingPage.ResultState onLoad() {
        // 请求网络
        HomeProtocol protocol = new HomeProtocol();
        data = protocol.getData(0);// 加载第一页数据

        return check(data); // 校验数据并返回状态
    }


    class HomeAdapter extends MyBaseAdapter<AppInfo> {

        public HomeAdapter(ArrayList<AppInfo> data) {
            super(data);
        }

        /**
         * 获取当前页面的holder对象
         *
         * @return
         */
        @Override
        public BaseHolder<AppInfo> getHolder() {
            return new HomeHolder();
        }

        /**
         * 网络加载更多数据
         *
         * @return
         */
        @Override
        public ArrayList<AppInfo> onLoadMore() {
            HomeProtocol protocol = new HomeProtocol();
            // 下一页数据开始位置=当前集合大小
            ArrayList<AppInfo> moreData = protocol.getData(getListSize());

            return moreData;
        }

//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ViewHolder holder;
//            if (convertView == null) {
//                //1.加载布局文件
//                convertView = UIUtils.inflate(R.layout.list_item_home);
//                //2.初始化控件
//                holder = new ViewHolder();
//                holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
//                //3.打一个标记
//                convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//
//            // 4.根据数据来刷新界面
//            String content = getItem(position);
//            holder.tvContent.setText(content);
//
//            return convertView;
//        }
    }

}
