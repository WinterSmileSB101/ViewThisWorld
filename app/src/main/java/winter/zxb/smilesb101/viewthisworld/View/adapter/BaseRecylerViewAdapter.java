package winter.zxb.smilesb101.viewthisworld.View.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 项目名称：ViewThisWorld
 * 类描述：视频
 * 创建人：SmileSB101
 * 创建时间：2017/5/3 0003 14:36
 * 修改人：Administrator
 * 修改时间：2017/5/3 0003 14:36
 * 修改备注：
 */

public class BaseRecylerViewAdapter extends RecyclerView.Adapter{
	int layoutID;//布局文件ID

	public BaseRecylerViewAdapter(int layoutID){
		this.layoutID = layoutID;
	}
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
		ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),layoutID,parent,false);
		MyViewHolder holder = new MyViewHolder(dataBinding.getRoot());
		holder.setDataBinding(dataBinding);
		return holder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder,int position){
		MyViewHolder holder1 = (MyViewHolder)holder;
	}

	@Override
	public int getItemCount(){
		return 0;
	}

	class MyViewHolder extends RecyclerView.ViewHolder{
		ViewDataBinding dataBinding;

		public MyViewHolder(View itemView){
			super(itemView);
		}

		public ViewDataBinding getDataBinding(){
			return dataBinding;
		}

		public void setDataBinding(ViewDataBinding dataBinding){
			this.dataBinding = dataBinding;
		}
	}
}
