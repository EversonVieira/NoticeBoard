package noticeboard.dao;

import noticeboard.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
    This class represents the Data Access Object in the context of this project, like as said in NoticeBO, I've opted
    to use the framework entity mapper, so it's just because of this that this interface is so empty.
 */
@Repository
public interface NoticeDAO extends JpaRepository<Notice,Integer> {

    @Transactional(readOnly = true)
    Notice findByTitle(String Title);

}
