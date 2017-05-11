package winter.zxb.smilesb101.viewthisworld.View.Fragment.GanHuo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.NotTextGanioBean;
import winter.zxb.smilesb101.viewthisworld.Presenter.IGanioNotTextFragmentPresenter;
import winter.zxb.smilesb101.viewthisworld.R;
import winter.zxb.smilesb101.viewthisworld.View.Fragment.FragmentBase;
import winter.zxb.smilesb101.viewthisworld.View.Interface.INotTextGanioFragmentView;
import winter.zxb.smilesb101.viewthisworld.View.adapter.VideoRecyclerViewAdapter;
import winter.zxb.smilesb101.viewthisworld.databinding.VideoGanioFragmentLayoutBinding;

/**
 * 项目名称：ViewThisWorld
 * 类描述：视频的干货碎片
 * 创建人：SmileSB101
 * 创建时间：2017/5/3 0003 14:29
 * 修改人：Administrator
 * 修改时间：2017/5/3 0003 14:29
 * 修改备注：
 */

public class VideoGanioFragment extends FragmentBase implements INotTextGanioFragmentView{

	VideoGanioFragmentLayoutBinding binding;
	IGanioNotTextFragmentPresenter presenter;
	public static VideoGanioFragment newInstance(){
		
		Bundle args = new Bundle();
		
		VideoGanioFragment fragment = new VideoGanioFragment();
		fragment.setArguments(args);
		return fragment;
	}

	public VideoGanioFragment()
	{
		title = "休息视频";
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
		binding = DataBindingUtil.inflate(inflater,R.layout.video_ganio_fragment_layout,container,false);
		rootView = binding.getRoot();
		rootContext = container.getContext();
		RecyclerView rv = (RecyclerView)rootView.findViewById(R.id.recyclerView);
		rv.setLayoutManager(new LinearLayoutManager(rootContext,LinearLayoutManager.VERTICAL,false));

		presenter = new IGanioNotTextFragmentPresenter(this);
		presenter.getSearchGanio();

		return rootView;
	}

	@Override
	public void showLoading(){

	}

	@Override
	public void closeLoding(){

	}

	@Override
	public void onError(String error){

	}

	@Override
	public String getGanioType(){
		return title;
	}

	@Override
	public void showGanio(ArrayList<NotTextGanioBean> ganioBeanArrayList){
		binding.setAdapter(new VideoRecyclerViewAdapter(ganioBeanArrayList));
	}
}
