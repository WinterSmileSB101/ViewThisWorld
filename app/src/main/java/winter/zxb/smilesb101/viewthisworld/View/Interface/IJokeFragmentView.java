package winter.zxb.smilesb101.viewthisworld.View.Interface;

import java.util.ArrayList;

import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanPicJokeBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanTextJokeBean;

/**
 * 项目名称：ViewThisWorld
 * 类描述：图片笑话接口
 * 创建人：SmileSB101
 * 创建时间：2017/5/9 0009 19:15
 * 修改人：Administrator
 * 修改时间：2017/5/9 0009 19:15
 * 修改备注：
 */

public interface IJokeFragmentView{
	void showLoading();
	void closeLoading();
	void showPicJoke(ArrayList<YiYuanPicJokeBean> picJokeBeanArrayList);
	void showTextJoke(ArrayList<YiYuanTextJokeBean> textJokeBeanArrayList);
	void onError(String error);
}
