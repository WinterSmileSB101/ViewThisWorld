package winter.zxb.smilesb101.viewthisworld.View.Fragment.ZiXun;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsChannelBean;
import winter.zxb.smilesb101.viewthisworld.Presenter.INewsFragmentPresenter;
import winter.zxb.smilesb101.viewthisworld.R;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.FragmentBase;
import winter.zxb.smilesb101.viewthisworld.View.Interface.INewsFragmentView;
import winter.zxb.smilesb101.viewthisworld.View.adapter.NewsFragmentPagerAdapter;
import winter.zxb.smilesb101.viewthisworld.databinding.ZixunFragmentLayoutBinding;

/**
 * 项目名称：ViewThisWorld
 * 类描述：资讯的碎片（包括干货{干货集中营以及知乎日报}，以及新闻）
 * 创建人：SmileSB101
 * 创建时间：2017/5/3 0003 08:20
 * 修改人：Administrator
 * 修改时间：2017/5/3 0003 08:20
 * 修改备注：
 */

public class NewsFragment extends FragmentBase implements INewsFragmentView{

	ArrayList<FragmentBase> fragmentBases;
	ArrayList<YiYuanNewsChannelBean> channelList;

	ZixunFragmentLayoutBinding binding;

	INewsFragmentPresenter presenter;

	public static NewsFragment newInstance(){
		
		Bundle args = new Bundle();
		
		NewsFragment fragment = new NewsFragment();
		fragment.setArguments(args);
		return fragment;
	}
	
	public NewsFragment()
	{
		title = "新 闻";
		titleImage = R.drawable.tab_news;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
		binding = DataBindingUtil.inflate(inflater,R.layout.zixun_fragment_layout,container,false);//碎片中通过这种方式来绑定
		rootView = binding.getRoot();
		rootContext = container.getContext();
		initView(binding);
		return rootView;
	}

	void initView(ZixunFragmentLayoutBinding binding)
	{
		Log.i(TAG,"initView: 新闻获取频道");
		presenter = new INewsFragmentPresenter(this);
		presenter.getNewsChannelList();
	}

	@Override
	public void showNewsChannels(ArrayList<YiYuanNewsChannelBean> channels){
		channelList = channels;
		Log.i(TAG,"initView: 频道个数："+channels.size());
		binding.setAdapter(new NewsFragmentPagerAdapter(this.getChildFragmentManager(),channels));
	}

	@Override
	public void onError(String s){

	}
}
