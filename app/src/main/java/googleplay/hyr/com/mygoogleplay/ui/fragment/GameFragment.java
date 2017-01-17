package googleplay.hyr.com.mygoogleplay.ui.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import googleplay.hyr.com.mygoogleplay.ui.view.LoadingPage;
import googleplay.hyr.com.mygoogleplay.utils.UIUtils;

/**
 * Created by huangyueran on 2017/1/13.
 * 游戏Fragment
 */
public class GameFragment extends BaseFragment {

    @Override
    public View onCreateSuccessView() {
        TextView textView = new TextView(UIUtils.getContext());
        textView.setText("玩游戏!!!");
        textView.setTextColor(Color.BLACK);
        return textView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_SUCCESS;
    }
}
