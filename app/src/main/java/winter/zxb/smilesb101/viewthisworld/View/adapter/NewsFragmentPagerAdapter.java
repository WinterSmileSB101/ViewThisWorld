package winter.zxb.smilesb101.viewthisworld.View.adapter;

import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsChannelBean;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.FragmentBase;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.ZiXun.CommonNewsFragment;

/**
 * 项目名称：ViewThisWorld
 * 类描述：资讯的viewpageradater
 * 创建人：SmileSB101
 * 创建时间：2017/5/3 0003 08:48
 * 修改人：Administrator
 * 修改时间：2017/5/3 0003 08:48
 * 修改备注：
 */

public class NewsFragmentPagerAdapter extends BaseFragmentPagerAdapter{
	ArrayList<FragmentBase> fragmentBases;
	ArrayList<YiYuanNewsChannelBean> channels;

	public NewsFragmentPagerAdapter(FragmentManager fm,ArrayList<YiYuanNewsChannelBean> channels){
		super(fm);
		this.channels = channels;
		for(YiYuanNewsChannelBean chennel:channels) {
			fragmentBases = new ArrayList<>();
			fragmentBases.add(CommonNewsFragment.newInstance(chennel));
		}
	}

	@Override
	public CharSequence getPageTitle(int position){

		return fragmentBases.get(position).getTitle();
	}
}
