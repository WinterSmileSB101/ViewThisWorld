package winter.zxb.smilesb101.viewthisworld.View.adapter;

import android.app.Activity;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanPicJokeBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanTextJokeBean;
import winter.zxb.smilesb101.viewthisworld.R;

/**
 * 项目名称：ViewThisWorld
 * 类描述：图片的笑话列表adapter
 * 创建人：SmileSB101
 * 创建时间：2017/5/9 0009 18:59
 * 修改人：Administrator
 * 修改时间：2017/5/9 0009 18:59
 * 修改备注：
 */

public class JokeRecyclerAdapter extends BaseRecylerViewAdapter{
	ArrayList<YiYuanPicJokeBean> picJokeBeanArrayList;
	ArrayList<YiYuanTextJokeBean> textJokeBeanArrayList;
	Activity activity;
	boolean IsText;

	public JokeRecyclerAdapter(int layoutID,ArrayList<YiYuanPicJokeBean> picJokeBeanArrayList,Activity activity){
		super(layoutID);
		this.picJokeBeanArrayList = picJokeBeanArrayList;
		this.IsText = false;
	}

	public JokeRecyclerAdapter(int layoutID,ArrayList<YiYuanTextJokeBean> textJokeBeanArrayList,Activity activity,boolean text){
		super(layoutID);
		this.textJokeBeanArrayList = textJokeBeanArrayList;
		this.IsText = true;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder,int position){
		MyViewHolder holder1 = (MyViewHolder)holder;
		if(!IsText)
		{
			YiYuanPicJokeBean picJokeBean = picJokeBeanArrayList.get(position);
			Glide.with(activity)
					.load(picJokeBean.getImg())
					.into(holder1.imageView);
			holder1.getBinding().setVariable(BR.picItem,picJokeBean);

		}
		else
		{
			YiYuanTextJokeBean textJokeBean = textJokeBeanArrayList.get(position);
			holder1.getBinding().setVariable(BR.picItem,textJokeBean);
		}
		holder1.getBinding().executePendingBindings();//执行修改
	}
	class MyViewHolder extends RecyclerView.ViewHolder{
		ImageView imageView;
		ViewDataBinding binding;
		public MyViewHolder(View itemView){
			super(itemView);
			//排除不同布局的影响
			if(itemView.findViewById(R.id.imageView)!=null) {
				imageView = (ImageView)itemView.findViewById(R.id.imageView);
			}
		}

		public ViewDataBinding getBinding(){
			return binding;
		}

		public void setBinding(ViewDataBinding binding){
			this.binding = binding;
		}
	}
}
