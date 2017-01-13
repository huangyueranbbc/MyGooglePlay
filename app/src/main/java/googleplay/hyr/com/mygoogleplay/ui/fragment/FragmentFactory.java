package googleplay.hyr.com.mygoogleplay.ui.fragment;

import java.util.HashMap;

/**
 * Created by huangyueran on 2017/1/13.
 * 生产Fragment的工厂
 */
public class FragmentFactory {

    private static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int pos) {

        BaseFragment fragment = mFragmentMap.get(pos);

        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AppFragment();
                    break;
                case 2:
                    fragment = new GameFragment();
                    break;
                case 3:
                    fragment = new SubjjectFragment();
                    break;
                case 4:
                    fragment = new RecommendFragment();
                    break;
                case 5:
                    fragment = new CategoryFragment();
                    break;
                case 6:
                    fragment = new HotFragment();
                    break;
                default:
                    break;
            }
        }


        mFragmentMap.put(pos, fragment); // 保存在集合中
        return fragment;
    }

}
