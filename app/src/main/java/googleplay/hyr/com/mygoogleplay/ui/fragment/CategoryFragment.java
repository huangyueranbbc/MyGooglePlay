package googleplay.hyr.com.mygoogleplay.ui.fragment;

import android.view.View;

import java.util.ArrayList;

import googleplay.hyr.com.mygoogleplay.http.protocol.CategoryProtocol;
import googleplay.hyr.com.mygoogleplay.pojo.CategoryInfo;
import googleplay.hyr.com.mygoogleplay.ui.adapter.MyBaseAdapter;
import googleplay.hyr.com.mygoogleplay.ui.holder.BaseHolder;
import googleplay.hyr.com.mygoogleplay.ui.holder.CategoryHolder;
import googleplay.hyr.com.mygoogleplay.ui.holder.TitleHolder;
import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.ui.view.MyListView;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/13.
 * 分类Fragment
 */
public class CategoryFragment extends BaseFragment {

    private ArrayList<CategoryInfo> data; // 网络请求得到的解析后的数据

    @Override
    public View onCreateSuccessView() {
        MyListView listView = new MyListView(UIUtils.getContext());
        listView.setAdapter(new CategoryAdapter(data));
        return listView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        CategoryProtocol protocol = new CategoryProtocol();
        data = protocol.getData(0);
        return check(data);
    }

    class CategoryAdapter extends MyBaseAdapter<CategoryInfo> {

        public CategoryAdapter(ArrayList<CategoryInfo> data) {
            super(data);
        }

        @Override
        public BaseHolder<CategoryInfo> getHolder(int position) {
            // 根据是标题类型还是普通类型，决定返回不同的holder
            CategoryInfo categoryInfo = data.get(position);
            if (categoryInfo.isTitle()) {
                //标题类型
                return new TitleHolder();
            } else {
                //普通类型
                return new CategoryHolder();
            }
        }

        @Override
        public ArrayList<CategoryInfo> onLoadMore() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return super.getViewTypeCount() + 1; // 在原基础上增加一种标题类型
        }

        // 重写此方法 增加返回类型
        @Override
        public int getInnerType(int position) {
            // 判断是否是标题类型还是普通类型
            if (data.get(position).isTitle()) { // 是否是标题
                // 标题类型
                return super.getInnerType(position) + 1;// 保证TYPE_NORMAL=1
            } else {
                //普通类型
                return super.getInnerType(position);
            }
        }

        // 重写此方法 表示没有更多数据 隐藏加载更多布局
        @Override
        public boolean hasMore() {
            return false;
        }
    }
}
