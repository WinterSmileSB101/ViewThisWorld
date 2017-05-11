package winter.zxb.smilesb101.viewthisworld.View.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsBean;

/**
 * 项目名称：ViewThisWorld
 * 类描述：一般新闻的RecyclerAdapter
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 21:47
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 21:47
 * 修改备注：
 */

public class CommonNewsRecyclerAdapter extends BaseRecylerViewAdapter{
	ArrayList<YiYuanNewsBean> newsBeanArrayList;

	public CommonNewsRecyclerAdapter(int layoutID,ArrayList<YiYuanNewsBean> newsBeanArrayList){
		super(layoutID);
		this.newsBeanArrayList = newsBeanArrayList;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder,int position){
		super.onBindViewHolder(holder,position);
	}

	@Override
	public int getItemCount(){
		return newsBeanArrayList.size();
	}
}
