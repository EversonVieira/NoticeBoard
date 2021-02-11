package noticeboard.bo;

import noticeboard.dao.NoticeDAO;
import noticeboard.domain.Notice;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeBO {
/*
    This class represent the Business layer that is responsable for dealing with the Data Access Object Layer (DAO),
    in this case, that we're using spring boot, i've opted to use the entity mapper what is one of the ways to connect
    and deal with the Data.
* */
    @Autowired
    private NoticeDAO noticeDAO;

    public List<Notice> getAll(){
        return noticeDAO.findAll();
    }
    public List<Notice> getList(Integer page){
        Page<Notice> notices = noticeDAO.findAll(PageRequest.of(page,5,Sort.by(Sort.Direction.DESC, "publishDate")));
        List<Notice> noticesAsList = notices.getContent();
        return noticesAsList;
    }
    public Notice getById(Integer id){
        return noticeDAO.findById(id).orElse(null);
    }
    public void insert(Notice notice){
        try{
            noticeDAO.save(notice);
        }catch(Exception ex) {
            throw ex;
        }
    }
    public void update(Notice notice){
        try{
            noticeDAO.save(notice);
        }catch (Exception ex){
            throw ex;
        }
    }
    public void deleteById(Integer id){
        try{
            noticeDAO.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
    }
}
