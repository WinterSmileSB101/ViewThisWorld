package winter.zxb.smilesb101.viewthisworld.View.Interface;

/**
 * 项目名称：ViewThisWorld
 * 类描述：主活动接口类
 * 创建人：SmileSB101
 * 创建时间：2017/4/26 0026 07:53
 * 修改人：Administrator
 * 修改时间：2017/4/26 0026 07:53
 * 修改备注：
 */

public interface IMainActivityView{
	String getGanioType();
	void showGaino();
	void showLoding();
	void closeLoding();
	void onError(String error);
}
