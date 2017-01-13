package googleplay.hyr.com.mygoogleplay.ui.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/13.
 * 首页Fragment
 */
public class HomeFragment extends BaseFragment {

    /**
     * 如果加载数据成功，就回调此方法，在主线程中执行，可以修改界面
     *
     * @return
     */
    @Override
    public View onCreateSuccessView() {
        TextView textView = new TextView(UIUtils.getContext());
        textView.setText(getClass().getSimpleName());
        textView.setTextColor(Color.BLUE);
        return textView;
    }

    /**
     * 运行在子线程 可以直接执行网络耗时操作
     *
     * @return
     */
    @Override
    public LoadingPage.ResultState onLoad() {
        // 请求网络
        return LoadingPage.ResultState.STATE_SUCCESS;
    }
}
