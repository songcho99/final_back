package reply.data;

import java.util.List;

public interface ReplyServiceInter {
	public void insertOfReply(ReplyDto dto);
	public int selectOfReplyMaxnum();
	public void updateRestepOfReply(int reply_regroup, int reply_restep);
	public List<ReplyDto> selectOfReply();
}