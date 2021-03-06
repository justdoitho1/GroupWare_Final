package com.group.board.dao;

import java.util.List;

import com.group.board.dto.BoardComment;
import com.group.exception.AddException;
import com.group.exception.FindException;
import com.group.exception.RemoveException;

public interface BoardCommentDAO {
	/**
	 * 특정 게시글에 대한 모든 댓글을 조회한다
	 * @param bd_no 특정 게시글의 게시글 번호
	 * @return 특정 게시글에 대한 모든 댓글
	 */
	public List<BoardComment> selectAll(String bd_no) throws FindException; 
	/**
	 * 댓글을 등록한다
	 * @param cm 댓글 내용을 담고 있는 객체
	 */
	public void insert(BoardComment cm) throws AddException;
	/**
	 * 댓글을  삭제한다
	 * @param cm_no 삭제할 댓글 번호
	 */
	public void delete(BoardComment cm) throws RemoveException;
	/**
	 * 관리자가 댓글을  삭제한다
	 * @param cm_no 삭제할 댓글 번호
	 */
	public void deleteAdmin(BoardComment cm) throws RemoveException;
}
