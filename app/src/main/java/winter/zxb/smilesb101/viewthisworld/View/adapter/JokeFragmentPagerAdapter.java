package winter.zxb.smilesb101.viewthisworld.View.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import winter.zxb.smilesb101.viewthisworld.View.Fragment.ZiXun.JokeShowFragment;

/**
 * 项目名称：ViewThisWorld
 * 类描述：笑话的viewpageradapter
 * 创建人：SmileSB101
 * 创建时间：2017/5/9 0009 18:42
 * 修改人：Administrator
 * 修改时间：2017/5/9 0009 18:42
 * 修改备注：
 */

public class JokeFragmentPagerAdapter extends BaseFragmentPagerAdapter{
	public JokeFragmentPagerAdapter(FragmentManager fm){
		super(fm);
	}

	JokeShowFragment picJoke,textJoke;

	@Override
	public Fragment getItem(int position){
		switch(position)
		{
			case 0:
				if(picJoke==null)
				{
					picJoke = JokeShowFragment.newInstance(0);
				}
				return picJoke;
			case 1:
				if(textJoke==null)
				{
					textJoke = JokeShowFragment.newInstance(1);
				}
				return textJoke;
			default:
				break;
		}
		return super.getItem(position);
	}

	@Override
	public CharSequence getPageTitle(int position){
		switch(position)
		{
			case 0:
				return picJoke.getTitle();
			case 1:
				return textJoke.getTitle();
		}
		return super.getPageTitle(position);
	}
}
