package cn.gqxqd.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.gqxqd.dao.NotebookDao;
import cn.gqxqd.entity.Notebook;
import cn.gqxqd.util.NoteResult;
import cn.gqxqd.util.NoteUtil;

@Service
public class NotebookServiceImpl implements NotebookService {

	@Resource
	private NotebookDao notebookDao;

	@Override
	public NoteResult loadUserNotebook(String userId) {
		NoteResult noteResult = new NoteResult();
		List<Notebook> notebooks = notebookDao.findByUserId(userId);
		notebooks.forEach(note -> {
			System.out.println(note.getCn_notebook_name());
		});
		noteResult.setStatus(0);
		noteResult.setMsg("查询成功！");
		noteResult.setData(notebooks);
		return noteResult;
	}

	@Override
	public NoteResult addNotebook(String userId, String bookName) {
		NoteResult noteResult = new NoteResult();
		try {
			Notebook notebook = new Notebook();
			notebook.setCn_notebook_id(NoteUtil.createId());
			notebook.setCn_user_id(userId);
			notebook.setCn_notebook_name(bookName);
			notebook.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
			notebookDao.saveNotebook(notebook);
			noteResult.setStatus(0);
			noteResult.setMsg("添加成功！");
		} catch (Exception e) {
			noteResult.setStatus(1);
			noteResult.setMsg("添加失败！" + e.getMessage());
		}
		return noteResult;
	}

	@Override
	public NoteResult updateNotebook(String bookId, String bookName) {
		NoteResult noteResult = new NoteResult();
		try {
			Notebook notebook = new Notebook();
			notebook.setCn_notebook_id(bookId);
			notebook.setCn_notebook_name(bookName);
			int result = notebookDao.rename(notebook);
			noteResult.setStatus(0);
			noteResult.setMsg("修改成功！" + result);
		} catch (Exception e) {
			noteResult.setStatus(1);
			noteResult.setMsg("修改失败！" + e.getMessage());
		}
		return noteResult;
	}

}