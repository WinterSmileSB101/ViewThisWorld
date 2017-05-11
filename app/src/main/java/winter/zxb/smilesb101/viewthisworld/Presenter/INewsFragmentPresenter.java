package winter.zxb.smilesb101.viewthisworld.Presenter;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsChannelBean;
import winter.zxb.smilesb101.viewthisworld.Model.IYiYuanModel;
import winter.zxb.smilesb101.viewthisworld.View.Interface.ICommonNewsFragmentView;
import winter.zxb.smilesb101.viewthisworld.View.Interface.INewsFragmentView;

/**
 * 项目名称：ViewThisWorld
 * 类描述：资讯新闻的桥梁
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 22:04
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 22:04
 * 修改备注：
 */

public class INewsFragmentPresenter{
	INewsFragmentView iNewsFragmentView;//主Fragment类
	ICommonNewsFragmentView iCommonNewsFragmentView;//一般新闻的接口

	public INewsFragmentPresenter(INewsFragmentView iNewsFragmentView)
	{
		this.iNewsFragmentView = iNewsFragmentView;
	}

	public INewsFragmentPresenter(ICommonNewsFragmentView iCommonNewsFragmentView){
		this.iCommonNewsFragmentView = iCommonNewsFragmentView;
	}

	/**
	 * 获取频道列表
	 */
	public void getNewsChannelList()
	{
		if(iNewsFragmentView!=null) {
			IYiYuanModel.YI_YUAN_MODEL.getNewsChannel(new IYiYuanModel.NewsChannelListener(){
				@Override
				public void onSuccess(ArrayList<YiYuanNewsChannelBean> channels){
					iNewsFragmentView.showNewsChannels(channels);
				}

				@Override
				public void onError(String error){
					iNewsFragmentView.onError(error);
				}
			});
		}
	}

	public void getNews()
	{
		if(iCommonNewsFragmentView!=null) {
			IYiYuanModel.YI_YUAN_MODEL.getNewsInfo(iCommonNewsFragmentView.getChannel().getChannelId(),
					iCommonNewsFragmentView.getChannel().getName(),iCommonNewsFragmentView.getKeyTitle(),1,0,1,0,20,new IYiYuanModel.NewsListener(){
						@Override
						public void onSuccess(ArrayList<YiYuanNewsBean> newsBeanArrayList){
							iCommonNewsFragmentView.showNews(newsBeanArrayList);
						}

						@Override
						public void onError(String error){
							iCommonNewsFragmentView.onError(error);
						}
					});
		}
	}
}
