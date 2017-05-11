package winter.zxb.smilesb101.viewthisworld.Presenter;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanPicJokeBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanTextJokeBean;
import winter.zxb.smilesb101.viewthisworld.Model.IYiYuanModel;
import winter.zxb.smilesb101.viewthisworld.View.Interface.IJokeFragmentView;

/**
 * 项目名称：ViewThisWorld
 * 类描述：笑话的桥梁
 * 创建人：SmileSB101
 * 创建时间：2017/5/9 0009 21:26
 * 修改人：Administrator
 * 修改时间：2017/5/9 0009 21:26
 * 修改备注：
 */

public class IJokeFragmentPresenter{
	IJokeFragmentView iJokeFragmentView;

	public IJokeFragmentPresenter(IJokeFragmentView iJokeFragmentView){
		this.iJokeFragmentView = iJokeFragmentView;
	}


	/**
	 * 获取动态图片图片笑话
	 */
	public void getDanymicPicJoke()
	{
		if(iJokeFragmentView !=null) {
			IYiYuanModel.YI_YUAN_MODEL.getDanmicJoke(1,25,new IYiYuanModel.PicJokeListener(){
				@Override
				public void onSuccess(ArrayList<YiYuanPicJokeBean> picJokeBeanArrayList){
					iJokeFragmentView.showPicJoke(picJokeBeanArrayList);
				}

				@Override
				public void onError(String error){
					iJokeFragmentView.onError(error);
				}
			});
		}
	}

	/**
	 * 获取文字笑话大全
	 */
	public void getTextJoke()
	{
		if(iJokeFragmentView!=null)
		{
			IYiYuanModel.YI_YUAN_MODEL.getJoke("2015-07-10",1,25,new IYiYuanModel.TextJokeListener(){
				@Override
				public void onSuccess(ArrayList<YiYuanTextJokeBean> textJokeBeanArrayList){
					iJokeFragmentView.showTextJoke(textJokeBeanArrayList);
				}

				@Override
				public void onError(String error){
					iJokeFragmentView.onError(error);
				}
			});
		}
	}

	/**
	 * 获取图片笑话大全
	 */
	public void getPicJoke()
	{
		if(iJokeFragmentView !=null) {
			IYiYuanModel.YI_YUAN_MODEL.getJoke("2015-07-10",1,25,new IYiYuanModel.PicJokeListener(){
				@Override
				public void onSuccess(ArrayList<YiYuanPicJokeBean> picJokeBeanArrayList){
					iJokeFragmentView.showPicJoke(picJokeBeanArrayList);
				}

				@Override
				public void onError(String error){
					iJokeFragmentView.onError(error);
				}
			});
		}
	}

}
