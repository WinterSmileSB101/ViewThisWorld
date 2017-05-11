package winter.zxb.smilesb101.viewthisworld.View.Fragment.ZiXun;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import winter.zxb.smilesb101.viewthisworld.R;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.FragmentBase;
import winter.zxb.smilesb101.viewthisworld.View.adapter.JokeFragmentPagerAdapter;
import winter.zxb.smilesb101.viewthisworld.databinding.JokeFragmentLayoutBinding;

/**
 * 项目名称：ViewThisWorld
 * 类描述：笑话碎片
 * 创建人：SmileSB101
 * 创建时间：2017/5/9 0009 18:35
 * 修改人：Administrator
 * 修改时间：2017/5/9 0009 18:35
 * 修改备注：
 */

public class JokeFragment extends FragmentBase{
	JokeFragmentLayoutBinding binding;

	public static JokeFragment newInstance(){

		Bundle args = new Bundle();

		JokeFragment fragment = new JokeFragment();
		fragment.setArguments(args);
		return fragment;
	}

	public JokeFragment()
	{
		title = "笑 话";
		titleImage = R.drawable.tab_joke;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
		binding = DataBindingUtil.inflate(inflater,R.layout.joke_fragment_layout,container,false);
		rootView = binding.getRoot();
		rootContext = container.getContext();
		initView();
		return rootView;
	}

	void initView()
	{
		binding.setAdapter(new JokeFragmentPagerAdapter(this.getChildFragmentManager()));
	}
}
