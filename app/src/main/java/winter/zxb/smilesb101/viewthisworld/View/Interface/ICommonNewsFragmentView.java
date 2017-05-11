package winter.zxb.smilesb101.viewthisworld.View.Interface;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsChannelBean;

/**
 * 项目名称：ViewThisWorld
 * 类描述：一般的新闻碎片接口
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 22:16
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 22:16
 * 修改备注：
 */

public interface ICommonNewsFragmentView{
	YiYuanNewsChannelBean getChannel();
	String getKeyTitle();
	void showNews(ArrayList<YiYuanNewsBean> newsBeanArrayList);
	void onError(String error);
}
