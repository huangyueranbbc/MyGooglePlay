package googleplay.hyr.com.mygoogleplay.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/13.
 */
public abstract class BaseFragment extends Fragment {

    private LoadingPage mLoadingPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TextView textView = new TextView(UIUtils.getContext());
        // textView.setText(getClass().getSimpleName());
        // textView.setTextColor(Color.BLUE);
        mLoadingPage = new LoadingPage(UIUtils.getContext()) {
            @Override
            public View onCreateSuccessView() {
                return BaseFragment.this.onCreateSuccessView();
            }

            @Override
            public ResultState onLoad() {
                return BaseFragment.this.onLoad();
            }
        };
        return mLoadingPage;
    }

    /**
     * 加载成功的布局 必须由子类实现
     *
     * @return
     */
    public abstract View onCreateSuccessView();

    /**
     * 加载网络数据 必须由子类实现
     *
     * @return
     */
    public abstract LoadingPage.ResultState onLoad();

    /**
     * 开始加载数据
     */
    public void loadData() {
        if (mLoadingPage != null) {
            mLoadingPage.loadData();
        }
    }
}
