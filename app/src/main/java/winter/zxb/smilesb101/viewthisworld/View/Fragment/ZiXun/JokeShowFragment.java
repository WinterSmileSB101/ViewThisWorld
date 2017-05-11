package winter.zxb.smilesb101.viewthisworld.View.Fragment.ZiXun;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanPicJokeBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanTextJokeBean;
import winter.zxb.smilesb101.viewthisworld.R;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.FragmentBase;
import winter.zxb.smilesb101.viewthisworld.View.Interface.IJokeFragmentView;
import winter.zxb.smilesb101.viewthisworld.View.adapter.JokeRecyclerAdapter;
import winter.zxb.smilesb101.viewthisworld.databinding.JokeShowFragmentLayoutBinding;


/**
 * 项目名称：ViewThisWorld
 * 类描述：动态图笑话碎片
 * 创建人：SmileSB101
 * 创建时间：2017/5/9 0009 18:55
 * 修改人：Administrator
 * 修改时间：2017/5/9 0009 18:55
 * 修改备注：
 */

public class JokeShowFragment extends FragmentBase implements IJokeFragmentView{
	int type;
	public static final String TYPE_KEY = "type";

	JokeShowFragmentLayoutBinding binding;

	public static JokeShowFragment newInstance(int type){
		
		Bundle args = new Bundle();
		
		JokeShowFragment fragment = new JokeShowFragment();
		args.putInt(TYPE_KEY,type);
		fragment.setArguments(args);
		return fragment;
	}

	public JokeShowFragment()
	{
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
		Bundle bundle = getArguments();
		if(bundle!=null)
		{
			type = bundle.getInt(TYPE_KEY);
			switch(type)
			{
				case 0:
					title = "趣 图";
					break;
				case 1:
					title = "段 子";
					break;
			}
			binding = DataBindingUtil.inflate(inflater,R.layout.joke_show_fragment_layout,container,false);
			rootView = binding.getRoot();
			rootContext = container.getContext();
			RecyclerView rv = (RecyclerView)rootView.findViewById(R.id.recyclerView);
			rv.setLayoutManager(new LinearLayoutManager(rootContext,LinearLayoutManager.VERTICAL,false));
		}
		return rootView;
	}

	@Override
	public void showLoading(){

	}

	@Override
	public void closeLoading(){

	}

	@Override
	public void showPicJoke(ArrayList<YiYuanPicJokeBean> picJokeBeanArrayList){
		if(binding!=null) {
			binding.setAdapter(new JokeRecyclerAdapter(R.layout.joke_pic_recycler_item,picJokeBeanArrayList,this.getActivity()));
		}
	}

	@Override
	public void showTextJoke(ArrayList<YiYuanTextJokeBean> textJokeBeanArrayList){
		if(binding!=null)
		{
			binding.setAdapter(new JokeRecyclerAdapter(R.layout.joke_text_recycler_item,textJokeBeanArrayList,this.getActivity(),true));
		}
	}

	@Override
	public void onError(String error){

	}
}
