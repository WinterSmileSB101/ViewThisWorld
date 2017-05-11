package winter.zxb.smilesb101.viewthisworld.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import winter.zxb.smilesb101.viewthisworld.R;

/**
 * 项目名称：ViewThisWorld
 * 类描述：音乐碎片
 * 创建人：SmileSB101
 * 创建时间：2017/4/25 0025 10:52
 * 修改人：Administrator
 * 修改时间：2017/4/25 0025 10:52
 * 修改备注：
 */

public class MusicFragment extends FragmentBase{

	View rootView;
	Context context;

	public static MusicFragment newInstance(){

		Bundle args = new Bundle();

		MusicFragment fragment = new MusicFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
		context = container.getContext();
		rootView = inflater.inflate(R.layout.music_fragment_layout,container,false);
		return rootView;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		title = getResources().getString(R.string.ZiXunName);//获取碎片标题,必须在这里进行赋值，否则次碎片会由于没有吸附在活动上而报错
	}
}
