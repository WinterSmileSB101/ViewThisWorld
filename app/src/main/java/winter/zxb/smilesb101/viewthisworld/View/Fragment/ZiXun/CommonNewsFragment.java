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

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsChannelBean;
import winter.zxb.smilesb101.viewthisworld.Presenter.INewsFragmentPresenter;
import winter.zxb.smilesb101.viewthisworld.R;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.FragmentBase;
import winter.zxb.smilesb101.viewthisworld.View.Interface.ICommonNewsFragmentView;
import winter.zxb.smilesb101.viewthisworld.View.adapter.CommonNewsRecyclerAdapter;
import winter.zxb.smilesb101.viewthisworld.databinding.CommonNewsLayoutBinding;

/**
 * 项目名称：ViewThisWorld
 * 类描述：一般的新闻Fragment
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 21:29
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 21:29
 * 修改备注：
 */

public class CommonNewsFragment extends FragmentBase implements ICommonNewsFragmentView{
	CommonNewsLayoutBinding binding;
	INewsFragmentPresenter presenter;

	public static final String KEY_TITLE_KEY = "key_title";

	String key_title;
	YiYuanNewsChannelBean channel;

	public static CommonNewsFragment newInstance(YiYuanNewsChannelBean channel){
		Bundle args = new Bundle();

		CommonNewsFragment fragment = new CommonNewsFragment();
		args.putSerializable(TITLE_KEY,channel);
		args.putString(KEY_TITLE_KEY,"");
		fragment.setArguments(args);
		return fragment;
	}

	public static CommonNewsFragment newInstance(String title,String keyTitle){
		Bundle args = new Bundle();

		CommonNewsFragment fragment = new CommonNewsFragment();
		args.putString(TITLE_KEY,title);
		args.putString(KEY_TITLE_KEY,keyTitle);
		fragment.setArguments(args);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
		binding = DataBindingUtil.inflate(inflater,R.layout.common_news_layout,container,false);
		rootContext = container.getContext();
		rootView = binding.getRoot();
		initView();
		return rootView;
	}

	void initView()
	{
		Bundle bundle = getArguments();
		if(bundle!=null) {
			channel = (YiYuanNewsChannelBean)bundle.getSerializable(TITLE_KEY);
			key_title = bundle.getString(KEY_TITLE_KEY);
			if(channel!=null) {
				presenter = new INewsFragmentPresenter(this);
				presenter.getNews();
			}
		}
	}

	@Override
	public YiYuanNewsChannelBean getChannel(){
		return channel;
	}

	@Override
	public String getKeyTitle(){
		return key_title;
	}

	@Override
	public void showNews(ArrayList<YiYuanNewsBean> newsBeanArrayList){
		RecyclerView rv = (RecyclerView)rootView.findViewById(R.id.recyclerView);
		rv.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false));
		binding.setAdapter(new CommonNewsRecyclerAdapter(R.layout.common_news_recycler_item,newsBeanArrayList));
	}

	@Override
	public void onError(String error){

	}
}
