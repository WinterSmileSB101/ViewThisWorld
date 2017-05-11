package winter.zxb.smilesb101.viewthisworld.View.Interface;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsChannelBean;

/**
 * 项目名称：ViewThisWorld
 * 类描述：资讯中新闻的接口类
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 22:01
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 22:01
 * 修改备注：
 */

public interface INewsFragmentView{
	void showNewsChannels(ArrayList<YiYuanNewsChannelBean> channels);
	void onError(String s);
}
