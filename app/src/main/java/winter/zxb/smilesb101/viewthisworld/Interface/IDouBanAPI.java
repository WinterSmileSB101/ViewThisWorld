package winter.zxb.smilesb101.viewthisworld.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 项目名称：ViewThisWorld
 * 类描述：豆瓣API v2
 * 创建人：SmileSB101
 * 创建时间：2017/5/7 0007 08:32
 * 修改人：Administrator
 * 修改时间：2017/5/7 0007 08:32
 * 修改备注：
 */

public interface IDouBanAPI{
	/**
	 * 获取图书信息
	 * @param id 书籍id
	 * @return 图书信息
	 */
	@GET("v2/book/{id}")
	Call<ResponseBody> getBookInfoCall(@Path("id") String id);

	/**
	 * 根据ISBN获取图书信息
	 * @param isbn isbn
	 * @return 图书信息
	 */
	@GET("v2/book/isbn/{name}")
	Call<ResponseBody> getBookbyISBNCall(@Path("name") String isbn);

	/**
	 * 搜索图书API
	 * @param keyWord 关键字与tag必传一个
	 * @param tag tag 与关键字必传一个
	 * @param offset 结果的offset 默认0
	 * @param count 结果条数 默认20，最大100
	 * @return
	 */
	@GET("v2/book/search?q={q}&tag={tag}&start={offset}&count={count}")
	Call<ResponseBody> searchBookCall(@Path("q") String keyWord,@Path("tag") String tag,@Path("offset") int offset,@Path("count") int count);
}
