package winter.zxb.smilesb101.viewthisworld.Bean;

/**
 * 项目名称：ViewThisWorld
 * 类描述：电影条目信息Bean
 * 创建人：SmileSB101
 * 创建时间：2017/5/6 0006 22:07
 * 修改人：Administrator
 * 修改时间：2017/5/6 0006 22:07
 * 修改备注：
 */

public class DouBanMovieItem{
	String id;//条目id
	String title;//中文名
	String original_title;//原名
	String[] aka;//又名
	String alt;//条目页URL
	String mobile_url;//移动版条目页URL
	String rating;//评分
	String ratings_count;//评分人数
	String wish_count;//想看人数
	String collect_count;//看过人数
	String do_count;//在看人数，如果是电视剧，默认值为0，如果是电影值为null
}
