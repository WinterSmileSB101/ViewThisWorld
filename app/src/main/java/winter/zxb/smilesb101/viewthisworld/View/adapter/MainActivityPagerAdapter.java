package winter.zxb.smilesb101.viewthisworld.View.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.View.Fragment.FragmentBase;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.GanHuo.GainoFragment;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.GanHuo.ImageGanioFragment;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.GanHuo.ZhiHuFragment;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.ZiXun.JokeFragment;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.ZiXun.NewsFragment;

/**
 * 项目名称：ViewThisWorld
 * 类描述：
 * 创建人：SmileSB101
 * 创建时间：2017/4/25 0025 09:24
 * 修改人：Administrator
 * 修改时间：2017/4/25 0025 09:24
 * 修改备注：
 */

public class MainActivityPagerAdapter extends FragmentPagerAdapter{
	ArrayList<FragmentBase> fragmentList;
	String TAG = "MainActivity";
	ArrayList<String> titles;
	Activity activity;
	ArrayList<Integer> titleImages;

	public MainActivityPagerAdapter(FragmentManager fm,Activity activity,int pos){
		super(fm);
		this.activity = activity;
		initFragments(pos);
	}
	public MainActivityPagerAdapter(FragmentManager fm,ArrayList<FragmentBase> fragmentList,Activity activity,int pos){
		super(fm);
		this.activity = activity;
		this.fragmentList = fragmentList;
		if(fragmentList!=null) {
			initFragments(pos);
		}
	}


	public void initFragments(int pos)
	{
		switch(pos) {
			case 0://干货分区
				fragmentList = new ArrayList<>();
				fragmentList.add(GainoFragment.newInstance());//阅读
				fragmentList.add(ImageGanioFragment.newInstance());//福利
				fragmentList.add(ZhiHuFragment.newInstance());//知乎
				break;
			default:
				fragmentList = new ArrayList<>();
				fragmentList.add(GainoFragment.newInstance());//阅读
				fragmentList.add(ImageGanioFragment.newInstance());//福利
				fragmentList.add(ZhiHuFragment.newInstance());//知乎
				break;
			case 1://资讯分区
				Log.i(TAG,"initFragments: 资讯分区实例化");
				fragmentList = new ArrayList<>();
				fragmentList.add(NewsFragment.newInstance());//新闻
				fragmentList.add(JokeFragment.newInstance());//笑话
				break;
			case 2://豆瓣分区
				break;
			case 3://音乐分区
				break;
			case 4://漫画-小说分区
				break;
		}

		titles = new ArrayList<>();
		titleImages = new ArrayList<>();
		for(FragmentBase fragment : fragmentList) {
			Log.i(TAG,"MainActivityPagerAdapter: " + fragment.getTitle());
			titles.add(fragment.getTitle());
			titleImages.add(fragment.getTitleImage());
		}
		notifyDataSetChanged();//通知改变
	}

	@Override
	public Fragment getItem(int position){
		return fragmentList.get(position);
	}

	@Override
	public int getCount(){
		return fragmentList.size();
	}

	@Override
	public CharSequence getPageTitle(int position){
		Drawable drawable;
		String title = "";
//		drawable = ContextCompat.getDrawable(activity,titleImages.get(position));
//		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//		ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
//		SpannableString spannableString = new SpannableString(" " + title);
//		spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//		return spannableString;
		return title;
	}

	public ArrayList<String> getPageTitles()
	{
		return titles;
	}

	public ArrayList<Integer> getPageImages()
	{
		return titleImages;
	}
}
