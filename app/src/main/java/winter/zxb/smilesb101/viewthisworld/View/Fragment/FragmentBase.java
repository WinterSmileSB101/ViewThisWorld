package winter.zxb.smilesb101.viewthisworld.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 项目名称：ViewThisWorld
 * 类描述：碎片基类
 * 创建人：SmileSB101
 * 创建时间：2017/5/3 0003 08:10
 * 修改人：Administrator
 * 修改时间：2017/5/3 0003 08:10
 * 修改备注：
 */

public class FragmentBase extends Fragment{
	protected View rootView;
	protected Context rootContext;
	protected String TAG;
	protected String title;
	protected int titleImage;

	protected static final String TITLE_KEY = "title";
	protected static final String TITLEIMAGE_KEY = "title";

	public FragmentBase()
	{
		TAG = getClass().getName();
	}

	public static FragmentBase newInstance(){
		
		Bundle args = new Bundle();
		
		FragmentBase fragment = new FragmentBase();
		fragment.setArguments(args);
		return fragment;
	}

	public String getTitle(){
		return title;
	}

	public int getTitleImage(){
		return titleImage;
	}
}
