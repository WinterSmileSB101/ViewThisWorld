package winter.zxb.smilesb101.viewthisworld.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanNewsChannelBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanPicJokeBean;
import winter.zxb.smilesb101.viewthisworld.Bean.YiYuanTextJokeBean;
import winter.zxb.smilesb101.viewthisworld.Interface.IYiYuanAPI;

/**
 * 项目名称：ViewThisWorld
 * 类描述：易源数据的Model类
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 10:21
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 10:21
 * 修改备注：
 */

public class IYiYuanModel{
	private String API_KEY;
	private String API_SECRET;

	public static final IYiYuanModel YI_YUAN_MODEL = new IYiYuanModel();

	public interface NewsListener{
		void onSuccess(ArrayList<YiYuanNewsBean> newsBeanArrayList);
		void onError(String error);
	}

	public interface NewsChannelListener{
		void onSuccess(ArrayList<YiYuanNewsChannelBean> channels);
		void onError(String error);
	}

	public interface PicJokeListener{
		void onSuccess(ArrayList<YiYuanPicJokeBean> picJokeBeanArrayList);
		void onError(String error);
	}

	public interface TextJokeListener{
		void onSuccess(ArrayList<YiYuanTextJokeBean> textJokeBeanArrayList);
		void onError(String error);
	}

	public IYiYuanModel()
	{
		API_KEY = "37567";
		API_SECRET = "ba3baad72a6848fd9dfdfeb4d5b9656b";
	}

	/**
	 *
	 * @param channelId 频道id 精确匹配 可为空
	 * @param channelName 频道名称 模糊匹配 可为空
	 * @param title 关键词 模糊匹配 可为空
	 * @param page 页数 默认1 可为空
	 * @param needContent 是否需要正文 默认 0 可为空
	 * @param needHtml 是否需要html正文 默认 0 可为空
	 * @param needAllList 是否需要所有内容列表（最全） 默认 0 可为空
	 * @param maxResult 每页最大条目数 默认 20 最大 100 可为空
	 * @param listener 监听
	 */
	public void getNewsInfo(String channelId,String channelName,String title,int page,int needContent,int needHtml,int needAllList,int maxResult,final NewsListener listener)
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://route.showapi.com/")
				.build();
		IYiYuanAPI api = retrofit.create(IYiYuanAPI.class);
		Call<ResponseBody> call = api.getNewsCall(this.API_KEY,this.API_SECRET,channelId,channelName,title,page,needContent,needHtml,needAllList,maxResult);
		call.enqueue(new Callback<ResponseBody>(){
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response){
				try {
					JSONObject jsonObject = new JSONObject(response.body().toString());
					String result = checkResultCode(jsonObject.getInt("showapi_res_code"));
					if(result.equals("success")) {
						Gson gson = new Gson();
						ArrayList<YiYuanNewsBean> list = gson.fromJson(jsonObject.getJSONObject("showapi_res_body").getJSONObject("pagebean").getString("contentlist"),new TypeToken<ArrayList<YiYuanNewsBean>>(){
						}.getType());
						listener.onSuccess(list);
					}
					else
					{
						listener.onError(result);//报告错误
					}
				} catch(JSONException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t){
				listener.onError(t.getMessage());
			}
		});
	}

	/**
	 * 获取新闻频道
	 * @param listener
	 */
	public void getNewsChannel(final NewsChannelListener listener)
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://route.showapi.com/")
				.build();
		IYiYuanAPI api = retrofit.create(IYiYuanAPI.class);
		Call<ResponseBody> call = api.getNewsChannelCall(API_KEY,API_SECRET);
		call.enqueue(new Callback<ResponseBody>(){
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response){
				try {
					JSONObject jsonObject = new JSONObject(response.body().toString());
					String result = checkResultCode(jsonObject.getInt("showapi_res_code"));
					if(result.equals("success")) {
						Gson gson = new Gson();
						ArrayList<YiYuanNewsChannelBean> list = gson.fromJson(jsonObject.getJSONObject("showapi_res_body").getString("channelList"),new TypeToken<ArrayList<YiYuanNewsChannelBean>>(){
						}.getType());
						listener.onSuccess(list);
					}
					else
					{
						listener.onError(result);//报告错误
					}
				} catch(JSONException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t){
				listener.onError(t.getMessage());
			}
		});
	}

	/**
	 * 获取动态图片笑话
	 * @param page 页数 可选
	 * @param maxResult 每页最大条目 1-50 可选
	 * @param picJokeListener 监听
	 */
	public void getDanmicJoke(int page,int maxResult,final PicJokeListener picJokeListener)
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://route.showapi.com/")
				.build();
		IYiYuanAPI api = retrofit.create(IYiYuanAPI.class);
		Call<ResponseBody> call = api.getDanmicPicJokeCall(page,maxResult,API_KEY,API_SECRET);
		call.enqueue(new Callback<ResponseBody>(){
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response){
				try {
					JSONObject jsonObject = new JSONObject(response.body().toString());
					String result = checkResultCode(jsonObject.getInt("showapi_res_code"));
					if(result.equals("success")) {
						Gson gson = new Gson();
						ArrayList<YiYuanPicJokeBean> jokeBeanArrayList = gson.fromJson(jsonObject.getJSONObject("showapi_res_body").getString("contentlist"),new TypeToken<ArrayList<YiYuanPicJokeBean>>(){
						}.getType());

						picJokeListener.onSuccess(jokeBeanArrayList);//提交成功
					}
					else
					{
						picJokeListener.onError(result);//报告错误
					}

				} catch(JSONException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t){
				picJokeListener.onError(t.getMessage());
			}
		});
	}

	/**
	 * 获取文字笑话大全笑话
	 * @param time 从这个时间起的最新笑话 格式 yy-mm-dd 可选
	 * @param page 页数 可选
	 * @param maxResult 每页最大条目 1-50 可选
	 * @param textJokeListener 监听
	 */
	public void getJoke(String time,int page,int maxResult,final TextJokeListener textJokeListener)
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://route.showapi.com/")
				.build();
		IYiYuanAPI api = retrofit.create(IYiYuanAPI.class);
		Call<ResponseBody> call = api.getJokeBookCall(time,page,maxResult,API_KEY,API_SECRET);
		call.enqueue(new Callback<ResponseBody>(){
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response){
				try {
					JSONObject jsonObject = new JSONObject(response.body().toString());
					String result = checkResultCode(jsonObject.getInt("showapi_res_code"));
					if(result.equals("success")) {
						Gson gson = new Gson();
						ArrayList<YiYuanTextJokeBean> jokeBeanArrayList = gson.fromJson(jsonObject.getJSONObject("showapi_res_body").getString("contentlist"),new TypeToken<ArrayList<YiYuanTextJokeBean>>(){
						}.getType());

						textJokeListener.onSuccess(jokeBeanArrayList);//提交成功
					}
					else
					{
						textJokeListener.onError(result);//报告错误
					}

				} catch(JSONException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t){
				textJokeListener.onError(t.getMessage());
			}
		});
	}

	/**
	 * 获取图片笑话大全笑话
	 * @param time 从这个时间起的最新笑话 格式 yy-mm-dd 可选
	 * @param page 页数 可选
	 * @param maxResult 每页最大条目 1-50 可选
	 * @param picJokeListener 监听
	 */
	public void getJoke(String time,int page,int maxResult,final PicJokeListener picJokeListener)
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://route.showapi.com/")
				.build();
		IYiYuanAPI api = retrofit.create(IYiYuanAPI.class);
		Call<ResponseBody> call = api.getJokeBookCall(time,page,maxResult,API_KEY,API_SECRET);
		call.enqueue(new Callback<ResponseBody>(){
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response){
				try {
					JSONObject jsonObject = new JSONObject(response.body().toString());
					String result = checkResultCode(jsonObject.getInt("showapi_res_code"));
					if(result.equals("success")) {
						Gson gson = new Gson();
						ArrayList<YiYuanPicJokeBean> jokeBeanArrayList = gson.fromJson(jsonObject.getJSONObject("showapi_res_body").getString("contentlist"),new TypeToken<ArrayList<YiYuanPicJokeBean>>(){
						}.getType());

						picJokeListener.onSuccess(jokeBeanArrayList);//提交成功
					}
					else
					{
						picJokeListener.onError(result);//报告错误
					}

				} catch(JSONException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t){
				picJokeListener.onError(t.getMessage());
			}
		});
	}

	/**
	 * 返回码校验
	 * @param code 返回码
	 * @return
	 */
	private String checkResultCode(int code)
	{
		switch(code)
		{
			case 0:
				return "success";
			case 1:
				return "系统调用错误";
			case 2:
				return "可调用次数或金额为0";
			case 3:
				return "读取超时";
			case 4:
				return "服务端返回数据解析错误";
			case 5:
				return "后端服务器DNS解析错误";
			case 6:
				return "服务不存在或未上线";
			case 1000:
				return "系统维护";
			case 1002:
				return "showapi_appid字段必传";
			case 1003:
				return "showapi_sign字段必传";
			case 1004:
				return "签名sign验证有误";
			case 1005:
				return "showapi_timestamp无效";
			case 1006:
				return "app无权限调用接口";
			case 1007:
				return "没有订购套餐";
			case 1008:
				return "服务商关闭对您的调用权限";
			case 1010:
				return "找不到您的应用";
			case 1011:
				return "子授权app_child_id无效";
			case 1012:
				return "子授权已过期或失效";
			case 1013:
				return "子授权ip受限";
			default:
				return "";
		}
	}
}
