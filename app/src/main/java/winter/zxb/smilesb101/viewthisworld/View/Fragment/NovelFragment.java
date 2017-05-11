package winter.zxb.smilesb101.viewthisworld.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import winter.zxb.smilesb101.viewthisworld.R;

/**
 * 项目名称：ViewThisWorld
 * 类描述：小说碎片
 * 创建人：SmileSB101
 * 创建时间：2017/4/25 0025 12:11
 * 修改人：Administrator
 * 修改时间：2017/4/25 0025 12:11
 * 修改备注：
 */

public class NovelFragment extends Fragment{
	View rootView;
	Context context;

	public static NovelFragment newInstance(){
		
		Bundle args = new Bundle();
		
		NovelFragment fragment = new NovelFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
		context = container.getContext();
		rootView = inflater.inflate(R.layout.novel_fragment_layout,container,false);
		return rootView;
	}
}
