package winter.zxb.smilesb101.viewthisworld.Bean;

import java.io.Serializable;

/**
 * 项目名称：ViewThisWorld
 * 类描述：易源频道bean
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 12:07
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 12:07
 * 修改备注：
 */

	public class YiYuanNewsChannelBean implements Serializable{
	String channelId;
	String name;

	public String getChannelId(){
		return channelId;
	}

	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
}
