package winter.zxb.smilesb101.viewthisworld.Bean;

/**
 * 项目名称：ViewThisWorld
 * 类描述：豆瓣图书信息
 * 创建人：SmileSB101
 * 创建时间：2017/5/6 0006 23:02
 * 修改人：Administrator
 * 修改时间：2017/5/6 0006 23:02
 * 修改备注：
 */

public class DouBanBookInfo{
	String id;
	String isbn10;
	String isbn13;
	String title;
	String origin_title;
	String alt_title;
	String subtitle;
	String url;
	String alt;
	String image;
	String images;//一个json字符串，value：small，large，medium
	String[] author;
	String[] translator;
	String publisher;
	String pubdate;
	String rating;//一个json字符串，value：max，numRaters，average，min
	String tags;//json字符串数组 每组{count，name}
	String binding;
	String price;
	String series;//Json字符串，id，title
	String pages;
	String author_intro;
	String summary;
	String catalog;
	String ebook_url;//没有电子书的话没有这个字符串
	String ebook_price;
}
