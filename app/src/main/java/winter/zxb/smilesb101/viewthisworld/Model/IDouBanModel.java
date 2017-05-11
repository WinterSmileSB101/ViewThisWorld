package winter.zxb.smilesb101.viewthisworld.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import winter.zxb.smilesb101.viewthisworld.Bean.DouBanBookInfo;
import winter.zxb.smilesb101.viewthisworld.Interface.IDouBanAPI;

/**
 * 项目名称：ViewThisWorld
 * 类描述：豆瓣信息获取类
 * 创建人：SmileSB101
 * 创建时间：2017/5/7 0007 08:31
 * 修改人：Administrator
 * 修改时间：2017/5/7 0007 08:31
 * 修改备注：
 */

public class IDouBanModel{
	public static final IDouBanModel I_DOU_BAN_MODEL = new IDouBanModel();

	public interface BookInfoListener{
		void onSuccess(DouBanBookInfo bookInfo);
		void onError(String error);
	}

	public interface BookListListener{
		void onSuccess(ArrayList<DouBanBookInfo> bookInfos);
		void onError(String error);
	}

	/**
	 * 获取图书信息
	 * @param book_id 图书id
	 * @param listener 监听
	 */
	public void getBookInfo(String book_id,final BookInfoListener listener)
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.douban.com/")
				.build();//获取retrofit实例

		IDouBanAPI iDouBanAPI = retrofit.create(IDouBanAPI.class);//实例化api
		Call<ResponseBody> call = iDouBanAPI.getBookInfoCall(book_id);//实例化call
		//异步提交请求
		call.enqueue(new Callback<ResponseBody>(){
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response){
				Gson gson = new Gson();
				DouBanBookInfo bookInfo = gson.fromJson(response.body().toString(),new TypeToken<DouBanBookInfo>(){
				}.getType());
				listener.onSuccess(bookInfo);
			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t){
				listener.onError(t.getMessage());
			}
		});
	}

	/**
	 * 根据isbn获取图书
	 * @param book_isbn 图书isbn
	 * @param listener 监听
	 */
	public void getBookByISBN(String book_isbn,final BookInfoListener listener)
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.douban.com/")
				.build();//获取retrofit实例

		IDouBanAPI iDouBanAPI = retrofit.create(IDouBanAPI.class);//实例化api
		Call<ResponseBody> call = iDouBanAPI.getBookbyISBNCall(book_isbn);//实例化call
		//异步提交请求
		call.enqueue(new Callback<ResponseBody>(){
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response){
				Gson gson = new Gson();
				DouBanBookInfo bookInfo = gson.fromJson(response.body().toString(),new TypeToken<DouBanBookInfo>(){
				}.getType());
				listener.onSuccess(bookInfo);
			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t){
				listener.onError(t.getMessage());
			}
		});
	}


	/**
	 * 搜索图书
	 * @param keyWord 关键字 与tag必传其一，不传作为""
	 * @param tag 标签 与关键字必传其一 不传作为""
	 * @param offset 结果偏移 默认0
	 * @param count 结果条数 默认20，最大100
	 * @param listener 监听
	 */
	public void seachBook(String keyWord,String tag,int offset,int count,final BookListListener listener)
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.douban.com/")
				.build();//获取retrofit实例

		IDouBanAPI iDouBanAPI = retrofit.create(IDouBanAPI.class);//实例化api
		Call<ResponseBody> call = iDouBanAPI.searchBookCall(keyWord,tag,offset,count);//实例化call
		//异步提交请求
		call.enqueue(new Callback<ResponseBody>(){
			@Override
			public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response){
				Gson gson = new Gson();
				ArrayList<DouBanBookInfo> bookInfo = gson.fromJson(response.body().toString(),new TypeToken<ArrayList<DouBanBookInfo>>(){
				}.getType());
				listener.onSuccess(bookInfo);
			}

			@Override
			public void onFailure(Call<ResponseBody> call,Throwable t){
				listener.onError(t.getMessage());
			}
		});
	}

	/**
	 *
	 * @param keyWord 关键字 与tag必传其一，不传作为""
	 * @param tag 标签 与关键字必传其一 不传作为""
	 * @param offset 结果偏移 默认0
	 * @param listener 监听
	 */
	public void seachBook(String keyWord,String tag,int offset,final BookListListener listener)
	{
		seachBook(keyWord,tag,offset,25,listener);
	}

	/**
	 *
	 * @param keyWord 关键字 与tag必传其一，不传作为""
	 * @param tag 标签 与关键字必传其一 不传作为""
	 * @param listener 监听
	 */
	public void seachBook(String keyWord,String tag,final BookListListener listener)
	{
		seachBook(keyWord,tag,0,25,listener);
	}

}
