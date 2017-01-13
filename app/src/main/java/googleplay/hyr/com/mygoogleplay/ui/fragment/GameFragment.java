package googleplay.hyr.com.mygoogleplay.ui.fragment;

import android.view.View;

import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;

/**
 * Created by huangyueran on 2017/1/13.
 * 游戏Fragment
 */
public class GameFragment extends BaseFragment {

    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_EMPTY;
    }
}
