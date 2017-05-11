package winter.zxb.smilesb101.viewthisworld.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 项目名称：ViewThisWorld
 * 类描述：易源数据API
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 10:32
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 10:32
 * 修改备注：
 */

public interface IYiYuanAPI{

	/**
	 * 获取新闻（每天200次）
	 * @param appId 应用id 必须
	 * @param appKey 应用key 必须
	 * @param channelId 频道id 精确匹配 可为空
	 * @param channelName 频道名称 模糊匹配 可为空
	 * @param title 关键词 模糊匹配 可为空
	 * @param page 页数 默认1 可为空
	 * @param needContent 是否需要正文 默认 0 可为空
	 * @param needHtml 是否需要html正文 默认 0 可为空
	 * @param needAllList 是否需要所有内容列表（最全） 默认 0 可为空
	 * @param maxResult 每页最大条目数 默认 20 最大 100 可为空
	 * @return
	 */
	@GET("109-35?showapi_appid={showapi_appid}&showapi_sign={showapi_sign}&channelId={channelId}&channelName={channelName}&title={title}&page={page}&needContent={needContent}&needHtml={needHtml}&needAllList={needAllList}&maxResult={maxResult}")
	Call<ResponseBody> getNewsCall(@Path("showapi_appid") String appId,@Path("showapi_sign") String appKey,@Path("channelId") String channelId,@Path("channelName") String channelName,@Path("title") String title,@Path("page") int page,@Path("needContent") int needContent,@Path("needHtml") int needHtml,@Path("needAllList") int needAllList,@Path("maxResult") int maxResult);

	/**
	 * 获取新闻频道
	 * @param appId 应用id 必须
	 * @param appKey 应用key 必须
	 * @return
	 */
	@GET("109-34?showapi_appid={showapi_appid}&showapi_sign={showapi_sign}")
	Call<ResponseBody> getNewsChannelCall(@Path("showapi_appid") String appId,@Path("showapi_sign") String appKey);

	/**
	 * 获取动态搞笑图的API
	 * @param page 页数 可选
	 * @param maxResult 每页最大条目数 1-50 可选
	 * @param appId 应用id
	 * @param appkey 应用key
	 * @return
	 */
	@GET("341-3?page={page}&maxResult={maxResult}&showapi_appid={showapi_appid}&showapi_sign={showapi_sign}")
	Call<ResponseBody> getDanmicPicJokeCall(@Path("page") int page,@Path("maxResult") int maxResult,@Path("showapi_appid") String appId,@Path("showapi_sign") String appkey);

	/**
	 * 获取笑话大全（静态图片笑话-文字笑话）的API
	 * @param time 从这个时间开始的最新笑话 yy-mm-dd
	 * @param page 页数 可选
	 * @param maxResult 每页最大条目数 1-50 可选
	 * @param appId 应用id
	 * @param appkey 应用key
	 * @return
	 */
	@GET("341-3?time={time}&page={page}&maxResult={maxResult}&showapi_appid={showapi_appid}&showapi_sign={showapi_sign}")
	Call<ResponseBody> getJokeBookCall(@Path("time") String time,@Path("page") int page,@Path("maxResult") int maxResult,@Path("showapi_appid") String appId,@Path("showapi_sign") String appkey);
}
